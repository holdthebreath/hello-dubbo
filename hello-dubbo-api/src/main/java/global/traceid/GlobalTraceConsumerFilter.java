package global.traceid;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;

import static org.apache.dubbo.common.constants.CommonConstants.CONSUMER;

/**
 * @ClassName GlobalTraceConsumerFilter
 * @Description 全局消费者分配traceId过滤器
 * @Author hwd
 * @Date 2020/9/16 9:28 PM
 * @Version 1.0
 */
@Slf4j
@Activate(group = {CONSUMER})
public class GlobalTraceConsumerFilter implements Filter {
    private static final String TRACE_ID = "traceId";

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String traceId = TraceIdUtils.getRpcTraceId();
        if (StringUtils.isNotEmpty(traceId)) {
            log.info("消费端当前traceId:{}", traceId);
            RpcContext.getContext().setAttachment(TRACE_ID, traceId);
        } else {
            // 调用无traceID
            RpcContext.getContext().setAttachment(TRACE_ID, TraceIdUtils.getRpcTraceId());
        }
        return invoker.invoke(invocation);
    }
}
