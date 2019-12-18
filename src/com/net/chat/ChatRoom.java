package com.net.chat;

import java.net.DatagramSocket;
public class ChatRoom {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		DatagramSocket ds=new DatagramSocket(8900);
		new Thread(new ChatReceiver(ds),"接受服务").start();
		new Thread(new ChatSender(ds,3000),"发送服务").start();
	}

}
