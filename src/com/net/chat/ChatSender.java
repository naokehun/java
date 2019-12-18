package com.net.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ChatSender implements Runnable {
	private DatagramSocket ds;
	private int port;

	public ChatSender(DatagramSocket ds, int port) {
		// TODO 自动生成的构造函数存根
		this.ds=ds;
		this.port=port;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		//创建套接字
		Scanner sc=new Scanner(System.in);
		while (true) {	
			    System.out.println("我说：");
				String str=sc.nextLine();
			try {
			
				byte[] zjsz=str.getBytes("UTF-8");
				System.out.println("这条信息要发给哪个IP:");
				String ip=sc.nextLine();
				
				//创建要发送的数据报
				DatagramPacket dp=new DatagramPacket(zjsz, zjsz.length,InetAddress.getByName(ip),8900);
				ds.send(dp);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}	
	}
}
