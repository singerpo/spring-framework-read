package com.face.juc.A1B2C3;

import java.util.concurrent.CountDownLatch;

public class T01SyncWaitNotify {

	/**这个类使一个线程等待其他线程各自执行完毕后再执行 **/
	private static CountDownLatch latch = new CountDownLatch(1);

	public static void main(String[] args) {
		final Object obj = new Object();
		char[] a1 = "1234567".toCharArray();
		char[] a2 = "ABCDEFG".toCharArray();
		new Thread(()-> {
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (obj){
				for (char c : a1) {
					System.out.print(c);
					obj.notify();
					try {
						obj.wait();//让出锁(wait等待会释放锁，sleep不会）
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				obj.notify();//必须，否则无法停止程序
			}
		},"t1").start();

		new Thread(()-> {
			synchronized (obj){
				for (char c : a2) {
					System.out.print(c);
					latch.countDown();
					obj.notify();
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				obj.notify();//必须，否则无法停止程序
			}
		},"t2").start();

	}
}
