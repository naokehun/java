package com.thread;

import org.apache.poi.hssf.record.PageBreakRecord.Break;

class TicketWindow3 implements Runnable{


	private int tickets=100;
	Object lock=new Object();
	public void run() {
		while(true) {
		synchronized (lock) {
			if (tickets>0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
			if (tickets>0) {
				System.out.println(Thread.currentThread().getName()+"正在卖"+tickets--+"张票");
			}else {
				break;
				}
			}
		}
	}

public class Thread_test11 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TicketWindow3 tw=new TicketWindow3();
		new Thread(tw,"窗口1").start();
		new Thread(tw,"窗口2").start();
		new Thread(tw,"窗口3").start();
		new Thread(tw,"窗口4").start();
	}

}
