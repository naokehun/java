package com.thread;
class YieThread extends Thread{
	public YieThread(String name) {
		super();
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+"-----"+i);
			if (i==2) {
				System.out.println("线程让步:");
				Thread.yield();
			}
		}
	}
}
public class Thread_test9 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new YieThread("线程1").start();
		new YieThread("线程2").start();
	}

}
