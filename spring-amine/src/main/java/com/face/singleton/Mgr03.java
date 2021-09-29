package com.face.singleton;

/**
 * 懒汉式-静态内部类
 */
public class Mgr03 {
	private Mgr03(){
	}

	private static class Mgr03Instance{
		private static final Mgr03 INSTANCE = new Mgr03();
	}

	public static Mgr03 getInstance(){
		return Mgr03Instance.INSTANCE;
	}
}
