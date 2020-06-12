package com.rzdp.staticdatasourcerouting.interceptor;

import com.rzdp.staticdatasourcerouting.datasource.BranchContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DataSourceInterceptor extends HandlerInterceptorAdapter {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        log.info("Getting branch name from header [x-branch-name]");
        String branch = request.getHeader("x-branch-name");
        log.info("Branch name [{}] fetched. Assigning it to branch data source context", branch);
        BranchContextHolder.setBranchContext(branch);
        log.info("[{}] assigned successfully", branch);
        return super.preHandle(request, response, handler);
    }
}
