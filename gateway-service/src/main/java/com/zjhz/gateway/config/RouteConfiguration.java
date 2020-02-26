package com.zjhz.gateway.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.core.io.buffer.DataBuffer;

import java.nio.charset.StandardCharsets;

/**
 * <b>功能名：</b>ProductServiceFeign<br>
 * <b>说明：</b>跨域方法类<br>
 * <b>著作权：</b> Copyright (C) 2019 ZJHZ  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019/5/7   zhangzhonghao
 */
@Configuration
public class RouteConfiguration {
    private static final String ALLOWED_HEADERS = "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client";
    private static final String ALLOWED_METHODS = "*";
    private static final String ALLOWED_ORIGIN = "*";
    private static final String ALLOWED_XPOSE= "*";
    private static final String MAX_AGE = "18000L";

    private static final String SWAGGER_UI_URI = "swagger-ui.html";
    @Value("${swagger.show}")
    private boolean swaggerShow;

    private static Logger logger = LoggerFactory.getLogger(RouteConfiguration.class);

    /**
     * <b>方法名：</b>返回错误信息 <br>
     * <b>说明：</b> <br>
     * <b>@param </b>[exchange]<br>
     * <b>@return：</b>org.springframework.core.io.buffer.DataBuffer<br>
     * <b>修改履历：</b>
     *
     * @author 2019/5/7 zhangzhonghao
     */
    public DataBuffer dataBuffer(ServerWebExchange exchange) {
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        byte[] bytes = "{\"errorCode\":\"401\",\"errorMessage\":\"无权登入\",\"success\":\"false\",\"model\":null}".getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);

        return buffer;
    }
    @Bean
    public WebFilter corsFilter() {
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            if (!CorsUtils.isCorsRequest(request)) {
                return chain.filter(ctx);
            }

            if (!swaggerShow){
                String uri = request.getURI()+"";
                if (uri.indexOf(SWAGGER_UI_URI)!=-1){
                    return ctx.getResponse().writeWith(Flux.just(dataBuffer(ctx)));
                }
            }
            if (CorsUtils.isCorsRequest(request)) {
                ServerHttpResponse response = ctx.getResponse();
                HttpHeaders headers = response.getHeaders();

                headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
                headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
                headers.add("Access-Control-Max-Age", MAX_AGE);
                headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS);
                headers.add("Access-Control-Expose-Headers", ALLOWED_XPOSE);
                headers.add("Access-Control-Allow-Credentials", "true");
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(ctx);
        };
    }
}
