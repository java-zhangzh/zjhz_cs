package com.zjhz.gismap.interceptor;

import com.zjhz.base.annotaion.Permission;
import com.zjhz.base.model.UserInfo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 12947 on 2019/5/25.
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ((handler instanceof HandlerMethod)) {
            return super.preHandle(request, response, handler);
        }
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        RedisTemplate redisCacheTemplate=(RedisTemplate)  factory.getBean("redisTemplate");
        redisCacheTemplate.setKeySerializer(new StringRedisSerializer());
        redisCacheTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        HandlerMethod hm = (HandlerMethod) handler;
        Permission classPermission = hm.getBean().getClass().getAnnotation(Permission.class);
        Permission methodPermission = hm.getMethodAnnotation(Permission.class);
        boolean flag = true;
        String token=  request.getHeader("token");
        //rides获取权限code数组
        UserInfo userInfo= (UserInfo) redisCacheTemplate.opsForValue().get(token);

     /*   String [] permissions= new String[userInfo.getPermissionList().size()];
        flag=HasPermissionUtil.hasPermission(classPermission,methodPermission,Constant.CLIENT_APP,permissions);
        if(!flag){

            response.reset();
            //设置编码格式
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            JSONObject jsonObject= new JSONObject();
            jsonObject.put("errorCode","403");
            jsonObject.put("errorMessage","没有权限");
            jsonObject.put("success",false);
            pw.write(jsonObject.toJSONString());
            pw.flush();
            pw.close();
            return  false;

        }*/
        return super.preHandle(request, response, handler);
    }



}
