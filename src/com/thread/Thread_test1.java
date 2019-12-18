package com.thread;

class Mythread1 implements Runnable{

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		int i=0;
		while (i++<5) {
			System.out.println(Thread.currentThread().getName()+"的run（）方法正在进行");
		}	
	}
}
public class Thread_test1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Mythread1 t1=new Mythread1();
		Thread t2=new Thread(t1,"t2");
		t2.start();
		Thread t3=new Thread(t1,"t3");
		t3.start();
	}

}
