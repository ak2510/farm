package com.magadh.farm.common.aspect;

import jakarta.servlet.*;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

public class MDCFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MDC.put("requestId", UUID.randomUUID().toString());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
