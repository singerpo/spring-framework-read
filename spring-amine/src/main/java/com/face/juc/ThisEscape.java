package com.face.juc;

import java.io.IOException;

/**
 * 不要在构造方法里面执行线程
 */
public class ThisEscape {
	private int num = 8;


	public ThisEscape(){
		new Thread(()-> System.out.println(this.num)).start();
	}

	public static void main(String[] args) throws IOException {
		new ThisEscape();
		System.in.read();
	}
}
