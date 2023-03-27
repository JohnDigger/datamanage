package com.datamanage.datamanage.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registryFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CorsFilter()); // 添加过滤的类
        registration.addUrlPatterns("/*"); // 设置过滤地址
        registration.setName("CorsFilter"); // 设置过滤器名字
        registration.setOrder(1);
        return registration;
    }
}
