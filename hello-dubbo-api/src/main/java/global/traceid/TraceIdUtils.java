package global.traceid;

import java.util.Optional;
import java.util.UUID;

/**
 * @ClassName TraceIdUtils
 * @Description TraceId工具类
 * @Author hwd
 * @Date 2020/9/16 9:26 PM
 * @Version 1.0
 */
public class TraceIdUtils {
    private static final ThreadLocal<String> TRACE_ID = new ThreadLocal<>();

    private static final String HTTP_TYPE = "HTTP-";
    private static final String RPC_TYPE = "RPC-";

    public static String getTraceId() {
        return TRACE_ID.get();
    }

    public static String getTraceId(String type) {
        if (TRACE_ID.get() == null) {
            setTraceId(type + UUID.randomUUID().toString());
        }
        return Optional.ofNullable(TRACE_ID.get()).orElse("");
    }

    public static String getHttpTraceId() {
        return TraceIdUtils.getTraceId(HTTP_TYPE);
    }

    public static String getRpcTraceId() {
        return TraceIdUtils.getTraceId(RPC_TYPE);
    }

    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }
}
