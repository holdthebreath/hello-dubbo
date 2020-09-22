package helloworld.web.filter;

import global.traceid.TraceIdUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName WebTraceIdFilter
 * @Description HTTP请求拦截器
 * @Author hwd
 * @Date 2020/9/21 8:50 PM
 * @Version 1.0
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
@Order(-9999)
public class WebTraceIdFilter implements Filter {
    private static final String TRACE_ID = "traceId";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String httpTraceId = TraceIdUtils.getHttpTraceId();
        log.info("接受http请求添加traceId:{}", httpTraceId);
        MDC.put(TRACE_ID, httpTraceId);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
