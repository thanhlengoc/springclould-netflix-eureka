package com.example.apigateway.config;

import com.example.apigateway.fallback.MyFallbackProvider;
import com.example.apigateway.filters.ErrorFilter;
import com.example.apigateway.filters.PostFilter;
import com.example.apigateway.filters.PreFilter;
import com.example.apigateway.filters.RouteFilter;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableZuulProxy
public class ZuulConfig {

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

    @Bean
    public MyFallbackProvider fallbackProvider() {
        return new MyFallbackProvider();
    }

}
