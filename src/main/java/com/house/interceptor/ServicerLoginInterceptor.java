package com.house.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
服务人员登陆拦截器
 */
public class ServicerLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("serviceraccount");
        if(obj != null){
            return true;
        }
        else{
            response.sendRedirect("/login/servicer");
            return false;
        }
    }
}
