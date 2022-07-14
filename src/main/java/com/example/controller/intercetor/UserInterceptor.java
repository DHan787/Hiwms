package com.example.controller.intercetor;

import com.example.domain.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ginger
 */
@Component
public class UserInterceptor implements HandlerInterceptor {
    @Override
    /**
     * 拦截器
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object users = request.getSession().getAttribute("users");
        if (users != null) {
            return true;
        }
        response.sendRedirect("/");
        return false;
    }
}
