package com.face.juc.A1B2C3;

import org.springframework.context.support.StaticApplicationContext;

import java.util.concurrent.locks.LockSupport;

/**
 * 用LockSupport实现线程交替
 * LockSupport park 当前线程阻塞（停止）
 * unpark(Thread t)
 */
public class T03LockSupport {
	static Thread t1 = null;
	static Thread t2 = null;

	public static void main(String[] args) {
		char[] a1 = "1234567".toCharArray();
		char[] a2 = "ABCDEFG".toCharArray();

		t1 = new Thread(() -> {
			for (char c : a1) {
				System.out.print(c);
				LockSupport.unpark(t2);//叫醒t2
				LockSupport.park();//t1阻塞（当前线程阻塞）
			}
		},"t1");

		t2 = new Thread(() -> {
			for (char c : a2) {
				LockSupport.park();//t2阻塞
				System.out.print(c);
				LockSupport.unpark(t1);//叫醒t1

			}
		},"t2");

		t1.start();
		t2.start();
	}
}
