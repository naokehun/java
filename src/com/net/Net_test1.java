package com.net;

import java.net.InetAddress;

public class Net_test1 {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		InetAddress ip=InetAddress.getLocalHost();
		System.out.println("本机IP地址是:"+ip.getHostAddress());
		InetAddress ip2= InetAddress.getByName("www.hbjhart.com");
		System.out.println("江汉艺术职业学院的IP地址是："+ip2.getCanonicalHostName());
		if (ip2.isReachable(3000)) {
			System.out.println("从本机到江汉艺术职业学院web服务器3到达");
		}else {
			System.out.println("从本机到江汉艺术职业学院web服务器3不可到达");
		}
		System.out.println("江汉艺术职业学院web服务器的名字是："+ip2.getHostName());
	}
}
