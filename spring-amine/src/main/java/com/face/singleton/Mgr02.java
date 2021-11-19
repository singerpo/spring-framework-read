package com.face.singleton;


/**
 * 懒汉式-同步代码块-双重检查
 */
public class Mgr02 {

	private static volatile Mgr02 mgr02;

	private Mgr02(){

	}

	public static Mgr02 getInstance(){
		if(mgr02 == null){
			synchronized (Mgr02.class){
				if(mgr02 == null){
					mgr02 = new Mgr02();
				}
			}
		}
		return mgr02;
	}
}
