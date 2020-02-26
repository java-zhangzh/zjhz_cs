package com.zjhz.gateway.config;

import com.zjhz.gateway.feign.AuhtenticationServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

/**
 * <b>功能名：</b>AccessGatewayFilter<br>
 * <b>说明：</b><br>
 * <b>著作权：</b> Copyright (C) 2018 WULUXIXING  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019/2/22  zhangzhonghao
 */
@Component
public class AccessGatewayFilter implements GlobalFilter, Ordered {
    @Autowired
    AuhtenticationServiceFeign auhtenticationServiceFeign;
    @Value("${swagger.show}")
    private boolean swaggerShow;
    @Autowired
    private RedisTemplate redisCacheTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        String method = serverHttpRequest.getMethodValue();
        HttpHeaders headers = serverHttpRequest.getHeaders();
        String token = null;
        if (headers.containsKey("token")) {
            List<String> tokenList = headers.get("token");
            if (tokenList != null && tokenList.size() > 0) {
                token = tokenList.get(0);
            }
        }
        String uria = serverHttpRequest.getURI() + "";
        String uri = uria.substring(uria.lastIndexOf("/") + 1);
        if ("POST".equals(method)) {
            if ("login".equals(uri)) {
                return chain.filter(exchange);
            } else if ("registerUser".equals(uri)) {
                return chain.filter(exchange);
            } else if ("registerUserUpdatePassword".equals(uri)) {
                return chain.filter(exchange);
            }else if("senderCode".equals(uri)){
                return chain.filter(exchange);
            }else if("updatePassword".equals(uri)){
                return chain.filter(exchange);
            }else if("getVersionByiPad".equals(uri)){
                return chain.filter(exchange);
            }else if("uploadSimple".equals(uri)){
                return chain.filter(exchange);
            }else if("uploadMore".equals(uri)){
                return chain.filter(exchange);
            }else if("deleteOBS".equals(uri)){
                return chain.filter(exchange);
            }else if("getKgsByLocation".equals(uri)){
                return chain.filter(exchange);
            }else if("getKgIntroduce".equals(uri)){
                return chain.filter(exchange);
            }else if("getClassApplyInfo".equals(uri)){
                return chain.filter(exchange);
            }else if("applyForClass".equals(uri)){
                return chain.filter(exchange);
            }else if("getApplyListByParentId".equals(uri)){
                return chain.filter(exchange);
            }else if("modifyApply".equals(uri)){
                return chain.filter(exchange);
            }else if("addVisitInfo".equals(uri)){
                return chain.filter(exchange);
            }else if("getExpActivitiesByKgId".equals(uri)){
                return chain.filter(exchange);
            }else if("getActivityInfo".equals(uri)){
                return chain.filter(exchange);
            }else if("addExpActivityInfo".equals(uri)){
                return chain.filter(exchange);
            }else if("decodeOpenid".equals(uri)){
                return chain.filter(exchange);
            }else if("wxUserInfo".equals(uri)){
                return chain.filter(exchange);
            }else if("wxPhone".equals(uri)){
                return chain.filter(exchange);
            }else if("binDingPhone".equals(uri)){
                return chain.filter(exchange);
            }else if("enroll".equals(uri)){
                return chain.filter(exchange);
            }
            else {
                if (token == null) {
                    return exchange.getResponse().writeWith(Flux.just(dataBuffer(exchange)));
                }else{
                    Set<String> strings = redisCacheTemplate.keys(token);
                    if(strings.size()==0){
                        return exchange.getResponse().writeWith(Flux.just(dataBuffer(exchange)));
                    }
                }
            }
        } else if ("GET".equals(method)) {

            if(uri.contains("index.html")){
                return chain.filter(exchange);
            }
            if (!"login".equals(uri) && !isSwaggerUri(uria)) {
                if (token == null) {
                    return exchange.getResponse().writeWith(Flux.just(dataBuffer(exchange)));
                }
                boolean falg = auhtenticationServiceFeign.getAccountByDharmaByName(token);
                if (!falg) {
                    return exchange.getResponse().writeWith(Flux.just(dataBuffer(exchange)));
                }
            }
        }
        return chain.filter(exchange);
    }

    boolean isSwaggerUri(String uri)
    {
        boolean isSwagger=false;
        if (!swaggerShow)
        {
            return isSwagger;
        }
        if (uri.indexOf("swagger")!=-1)
        {
            isSwagger=true;
        }else if (uri.indexOf("/v2/api-docs")!=-1)
        {
            isSwagger=true;
        }


        return isSwagger;
    }

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
    @Override
    public int getOrder() {
        return -200;
    }
}
