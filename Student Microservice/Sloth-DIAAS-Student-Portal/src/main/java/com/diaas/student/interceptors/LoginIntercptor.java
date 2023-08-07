package com.diaas.student.interceptors;


import com.diaas.student.annotation.RequireLogin;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginIntercptor implements HandlerInterceptor {
	 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        HandlerMethod method = null;
        if (handler instanceof HandlerMethod) {
            method = (HandlerMethod) handler;
            RequireLogin rl = method.getMethodAnnotation(RequireLogin.class);
            if (rl != null) {
                boolean flag = rl.value();
                if(flag) {
                     Object obj = session.getAttribute("user_id");
                    if (obj !=null) {
                        return true;
                    } else {
                        //response.getWriter().println(("not login"));
                    	response.sendRedirect("http://localhost:8888/");
                        return false;
                    }
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
