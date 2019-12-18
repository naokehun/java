package com.net.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatReceiver implements Runnable {
	private DatagramSocket ds;
	public ChatReceiver(DatagramSocket ds) {
		// TODO 自动生成的构造函数存根
		this.ds=ds;
	}
	@Override
	public void run() {
		//创建套接字
		while (true) {
			byte[] buf=new byte[1024];
			//定义一个数据报对象，用于封装接受数据
			DatagramPacket dp=new DatagramPacket(buf, buf.length);
			while (true) {
				try {
					ds.receive(dp);
					String xinxi=new String(dp.getData(),0,dp.getLength());
					System.out.println(dp.getAddress().getHostAddress()+":"+xinxi);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}
	}
}

