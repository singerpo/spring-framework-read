package com.face.juc.ABCABC;

import java.util.concurrent.locks.LockSupport;

public class T02LockSupport {
	static Thread t1 = null;
	static Thread t2 = null;
	static Thread t3 = null;

	public static void main(String[] args) {

		t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.print("A");
				LockSupport.unpark(t2);
				LockSupport.park();
			}
		}, "t1");
		t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				LockSupport.park();
				System.out.print("B");
				LockSupport.unpark(t3);
			}
		}, "t2");
		t3 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				LockSupport.park();
				System.out.print("C");
				LockSupport.unpark(t1);
			}

		}, "t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
