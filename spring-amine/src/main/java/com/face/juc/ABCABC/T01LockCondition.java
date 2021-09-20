package com.face.juc.ABCABC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class T01LockCondition {

	static Thread t1 = null;
	static Thread t2 = null;
	static Thread t3 = null;

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition();
		Condition condition2 = lock.newCondition();
		Condition condition3 = lock.newCondition();

		CountDownLatch latch2 = new CountDownLatch(1);
		CountDownLatch latch3 = new CountDownLatch(1);

		t1 = new Thread(() -> {
			lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					System.out.print("A");
					condition2.signal();
					if(i == 0){
						latch2.countDown();
					}
					condition1.await();
				}
				condition2.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}, "t1");

		t2 = new Thread(() -> {
			try {
				latch2.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					System.out.print("B");
					condition3.signal();
					if(i == 0){
						latch3.countDown();
					}
					condition2.await();
				}
				condition3.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}, "t2");

		t3 = new Thread(() -> {
			try {
				latch3.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.lock();
			try {
				for (int i = 0; i < 10; i++) {
					System.out.print("C");
					condition1.signal();
					condition3.await();
				}
				condition1.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}, "t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
