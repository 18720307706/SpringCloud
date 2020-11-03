package org.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置
 *
 * @author Lch on 2020/10/29
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
            RouteLocatorBuilder.Builder routes=  routeLocatorBuilder.routes();
            routes.route("path_route_baidu",r-> r.path("/").uri("http://www.bilibili.com/")).build();
            return routes.build();
    }
}