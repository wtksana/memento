package com.tt.memento.config;

import com.tt.memento.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * date: 2018/1/9
 * author: wt
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthInterceptor authInterceptor;
    private static final String[] EXCLUDE_PATH_PATTERNS = {"/", "/login", "/register", "/error"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).excludePathPatterns(EXCLUDE_PATH_PATTERNS);
        super.addInterceptors(registry);
    }
}
