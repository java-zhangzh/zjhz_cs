package com.zjhz.gismap.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author DencyCheng
 *
 */
@Component
public class WebSocketUtil {
    @Autowired
	private SimpMessagingTemplate messagingTemplate;

	/**
	 * 发送数据
	 * 
	 * @param url
	 * @param msg
	 */
	public void sendMsg(String url, Object msg) {
		messagingTemplate.convertAndSend(url, msg);
	}

	
}