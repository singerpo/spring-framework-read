package com.face.juc.A1B2C3;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * 使用同步队列实现线程交替
 */
public class T04TransferQueue {
	public static void main(String[] args) {
		char[] a1 = "1234567".toCharArray();
		char[] a2 = "ABCDEFG".toCharArray();

		// 容量为0的同步队列
		TransferQueue<Character> queue = new LinkedTransferQueue<>();
		new Thread(() -> {
			try {
				for (char c : a1) {
					System.out.print(queue.take());
					queue.transfer(c);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		}, "t1").start();

		new Thread(() -> {
			try {
				for (char c : a2) {
					queue.transfer(c);
					System.out.print(queue.take());

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		}, "t2").start();
	}
}
