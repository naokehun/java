package com.net;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		//创建服务器套接字,监听8899
		ServerSocket fwqtjz=new ServerSocket(8899);
		while (true) {
			Socket khdtjz=fwqtjz.accept();
			new Thread(()->{
				try {
					//通过客户端套接字获取客户端的IP地址
					String ip=khdtjz.getInetAddress().getHostAddress();
					//通过客户端套接字获取客户端的端口号
					int prot=khdtjz.getPort();
					System.out.println("和客户端ip地址是"+ip+"，端口号是"+prot+"连接上了");
					InputStream is=khdtjz.getInputStream();
					byte[]zjhc=new byte[1024];
					FileOutputStream fout=new FileOutputStream("d:\\upload\\"+ip+"png");
					int b=is.read();
					while (b!=-1) {
						fout.write(zjhc,0,b);
						b=is.read(zjhc);
					}
					String xinxi="文件上传成功";
					zjhc=new byte[1024];
					OutputStream os=khdtjz.getOutputStream();
					os.write(xinxi.getBytes("UTF-8"));
					os.close();
					khdtjz.close();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}) .start();
			//String xinxi="客户端你好，来自服务器的问候";
			//通过客户端套接字获取输出流
			//通过输出流写入到网络中
		}	
	}
}
