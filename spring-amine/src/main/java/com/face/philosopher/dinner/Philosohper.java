package com.face.philosopher.dinner;

/**
 * 哲学家
 */
public class Philosohper extends Thread {
	/**
	 * 左手筷子
	 **/
	private ChopStick left;
	/**
	 * 右手筷子
	 **/
	private ChopStick right;
	/**
	 * 编号
	 **/
	private int index;

	public Philosohper(String name, int index, ChopStick left, ChopStick right) {
		// 线程名字
		this.setName(name);
		this.index = index;
		this.left = left;
		this.right = right;
	}

	@Override
	public void run() {
		try {
			// 避免死锁
			// 效率最高的写法，奇数 偶数分开，混进一半的左撇子
			if(index % 2 == 0){
				synchronized (left) {
					System.out.println(index + "号哲学家左手拿到了" + left.getNo());
					// Thread.sleep((1 + index) * 1000);
					synchronized (right) {
						Thread.sleep(1000);
						System.out.println(index + "号哲学家左手拿到了" + left.getNo() + "号哲学家右手拿到了" + right.getNo() + "吃完了");
					}
				}
			}else {
				synchronized (right) {
					System.out.println(index + "号哲学家右手手拿到了" + right.getNo());
					// Thread.sleep((1 + index) * 1000);
					synchronized (left) {
						Thread.sleep(1000);
						System.out.println(index + "号哲学家右手手拿到了" + right.getNo() + "号哲学家左手拿到了" + left.getNo() + "吃完了");
					}
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public ChopStick getLeft() {
		return left;
	}

	public void setLeft(ChopStick left) {
		this.left = left;
	}

	public ChopStick getRight() {
		return right;
	}

	public void setRight(ChopStick right) {
		this.right = right;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
