package com.diaas.student.web.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.diaas.student.interceptors.LoginIntercptor;
import com.diaas.student.interceptors.RoleInterceptor;

@Configuration
public class WebConfig  implements WebMvcConfigurer{

    @Autowired
    LoginIntercptor intercptor;

    @Autowired
    RoleInterceptor roleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(intercptor)
                .addPathPatterns("/student/admin/**", "/student/user/**");
        registry
                .addInterceptor(roleInterceptor)
                .addPathPatterns("/student/admin/**", "/student/user/**");
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry
//                .addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("*")
//                .allowedMethods("*")
//                .allowedHeaders("*");
//    }
}
