package com.face.philosopher.dinner;

/**
 * 模拟哲学家问题
 * 主要避免死锁问题
 */
public class T01DeadLock {

	public static void main(String[] args) {
		ChopStick cs0 = new ChopStick("cs0");
		ChopStick cs1 = new ChopStick("cs1");
		ChopStick cs2 = new ChopStick("cs2");
		ChopStick cs3 = new ChopStick("cs3");
		ChopStick cs4 = new ChopStick("cs4");

		Philosohper p0 = new Philosohper("p0",0,cs0,cs1);
		Philosohper p1 = new Philosohper("p1",1,cs1,cs2);
		Philosohper p2 = new Philosohper("p2",2,cs2,cs3);
		Philosohper p3 = new Philosohper("p3",3,cs3,cs4);
		Philosohper p4 = new Philosohper("p4",4,cs4,cs0);

		p0.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();

	}
}
