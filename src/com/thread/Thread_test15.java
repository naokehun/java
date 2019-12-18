package com.thread;

import java.util.concurrent.*;
class MyThread6 implements Callable<Object>{

	@Override
	public Object call() throws Exception {
		// TODO 自动生成的方法存根
		int i=0;
		while (i++<5) {
			System.out.println(Thread.currentThread().getName()+"的call()方法在运行");
		}
		return i;
	}
	
}
public class Thread_test15 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO 自动生成的方法存根
		//2.创建Callable接口实现类的对象
		MyThread6 mt6=new MyThread6();
		//.使用Excutors线程执行创建可扩展的线程池
		ExecutorService pool=Executors.newCachedThreadPool();
		//将Callable接口实现类的对象提交到线程池进行管理
		Future<Object> result1=pool.submit(mt6);
		Future<Object> result2=pool.submit(mt6);
		Future<Object> result3=pool.submit(mt6);
		//关闭线程池
		pool.shutdown();
		//对于有返回值的线程任务，获取执行结果
		System.out.println("thread-1返回结果"+result1.get());
		System.out.println("thread-2返回结果"+result2.get());
		
	}

}
