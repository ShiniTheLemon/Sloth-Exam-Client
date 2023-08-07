package com.diaas.student.interceptors;


import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.diaas.student.annotation.RequireRole;
import com.diaas.student.entities.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class RoleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        HandlerMethod method = null;
        if (handler instanceof HandlerMethod) {
            method = (HandlerMethod) handler;
            RequireRole rr = method.getMethodAnnotation(RequireRole.class);
            if (rr != null) {
                int i = rr.value();
                int member = (int)session.getAttribute("role");
                int user_id=(int)session.getAttribute("user_id");
                if (user_id != 0) {
                    if(member == i){
                        return true;
                    } else {
                       // response.getWriter().println("permission denied");
                    	response.sendRedirect("http://localhost:8888/403");
                        return false;
                    }
                } else {
                    response.getWriter().println("you need login first");
                    return false;
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
