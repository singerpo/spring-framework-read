package com.face.singleton;

/**
 * 饿汉式
 * 简单实用，推荐实用
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 */
public class Mgr01 {
	private static final Mgr01 INSTANCE = new Mgr01();

	private Mgr01(){}

	public static Mgr01 getInstance(){
		return INSTANCE;
	}

	public static void main(String[] args) {
		Mgr01 m1 = Mgr01.getInstance();
		Mgr01 m2 = Mgr01.getInstance();
		System.out.println(m1 == m2);
	}
}
