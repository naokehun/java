package com.thread;

import java.util.concurrent.*;

public class Thread_test16 {

	public static void main(String[] args) throws Exception, ExecutionException {
		// TODO 自动生成的方法存根
		CompletableFuture<Integer>comparableFuturl=CompletableFuture.supplyAsync(()->{
			int sum=0,i=0;
			while(i++<5) {
				sum+=i;
				//显示线程任务执行过程
				System.out.println(Thread.currentThread().getName()+"线程任务正在执行...:i"+i);
			}
			return sum;
		});
		//创建第二个线程，执行6到10相加运算
		CompletableFuture<Integer>comparableFuture2=CompletableFuture.supplyAsync(()->{
			int sum=0,j=5;
			while(j++<10) {
				sum+=j;
				//显示线程任务执行过程
				System.out.println(Thread.currentThread().getName()+"线程任务正在执行...:j"+j);
			}
			return sum;
		});
		//将两个线程执行结果进行获取整合
		CompletableFuture<Integer>comparableFuture3=comparableFuturl.thenCombine(comparableFuture2,(result1,result2)->result1+result2);
		System.out.println("1加到10的结果为："+comparableFuture3.get());
	}

}
