package com.example.demo.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

@ServerEndpoint("/websocketPing/{ip}")
@Component
public class WebSocketHandlePing {

	private static final Logger log = LoggerFactory.getLogger(WebSocketHandlePing.class);

	private Process process;

	private InputStream inputStream;

	/**
	 * 新的WebSocket请求开启
	 */
	@OnOpen
	public void onOpen(@PathParam(value = "ip") String ip, Session session, EndpointConfig config) {
		try {
			// 执行
			String elec = "python3 " + "/opt/script/systemmanage/network_tools.py ping " + URLDecoder.decode(ip, "UTF-8");
			System.out.println(elec);
			process = Runtime.getRuntime().exec(elec);

			inputStream = process.getInputStream();
			// 一定要启动新的线程，防止InputStream阻塞处理WebSocket的线程
			TailThread thread = new TailThread(inputStream, session);
			thread.start();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnMessage
	public void onMessage(String ip, Session session) {
		log.info("来自客户端的消息:" + ip);
	}

	/**
	 * WebSocket请求关闭
	 */
	@OnClose
	public void onClose() {
		try {
			if (inputStream != null)
				inputStream.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (process != null)
			process.destroy();
	}

	@OnError
	public void onError(Throwable thr) {
		thr.printStackTrace();
	}
}