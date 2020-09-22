package global.traceid;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

import static org.apache.dubbo.common.constants.CommonConstants.PROVIDER;

/**
 * @ClassName GlobalTraceProviderFilterX
 * @Description 全局生产者分配traceId过滤器
 * @Author hwd
 * @Date 2020/9/16 10:13 PM
 * @Version 1.0
 */
@Slf4j
@Activate(group = {PROVIDER})
public class GlobalTraceProviderFilter implements Filter {
    private static final String TRACE_ID = "traceId";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = invocation.getAttachment(TRACE_ID);
        if (!StringUtils.isBlank(traceId)) {
            MDC.put(TRACE_ID, traceId);
            log.info("服务端当前traceId:{}", traceId);
            RpcContext.getContext().setAttachment(TRACE_ID, traceId);
            TraceIdUtils.setTraceId(traceId);
        } else {
            log.warn("服务端缺少traceId");
            RpcContext.getContext().setAttachment(TRACE_ID, TraceIdUtils.getRpcTraceId());
            TraceIdUtils.setTraceId(traceId);
        }
        return invoker.invoke(invocation);
    }
}
