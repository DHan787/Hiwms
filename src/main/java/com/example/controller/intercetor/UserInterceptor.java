package com.example.controller.intercetor;

import com.example.domain.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        Users users = (Users)request.getSession().getAttribute("users");
        if(users!=null){
            return true;
        }
        response.sendRedirect("/static/pages/login.html");
        return false;
    }
}
