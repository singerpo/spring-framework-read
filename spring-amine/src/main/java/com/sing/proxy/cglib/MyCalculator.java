package com.sing.proxy.cglib;

import com.sing.proxy.jdk.Calculator;

/**
 * @author songbo
 * @date 2021-12-22
 */
public class MyCalculator {
	public int add(int i, int j) {
		int result = i + j;
		return result;
	}

	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}

	public int mult(int i, int j) {
		int result = i * j;
		return result;
	}

	public int div(int i, int j) {
		int result = i / j;
		return result;
	}
}
