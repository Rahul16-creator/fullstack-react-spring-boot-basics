package com.fullstack_basics.book_rest_api.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class BoolInteceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private BookInteceptor bookInteceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bookInteceptor);
    }
}
