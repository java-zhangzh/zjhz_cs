package com.zjhz.gismap.listener;

import com.zjhz.base.constants.Constant;

import com.zjhz.gismap.util.ReverseUtil;

import com.zjhz.util.SendSmsUtil;
import com.zjhz.util.TimeUtil;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by 12947 on 2019/6/25.
 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {



    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }


    /**
     * 针对redis数据失效事件，进行数据处理
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        try {
            if (expiredKey.startsWith("kgSignIn")) {

            }
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());

        }
        System.out.println(expiredKey);
    }





}
