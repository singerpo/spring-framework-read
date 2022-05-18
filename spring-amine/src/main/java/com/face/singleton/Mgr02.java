package com.face.singleton;


/**
 * 懒汉式-同步代码块-双重检查
 */
public class Mgr02 {
	/**
	 * volatile 禁止指令重排序
	 */
	private static volatile Mgr02 mgr02;

	private Mgr02(){

	}

	public static Mgr02 getInstance(){
		if(mgr02 == null){
			// 双重检查
			synchronized (Mgr02.class){
				if(mgr02 == null){
					mgr02 = new Mgr02();
				}
			}
		}
		return mgr02;
	}
}
