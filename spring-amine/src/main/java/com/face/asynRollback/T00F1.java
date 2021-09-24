package com.face.asynRollback;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 异步回调回滚问题（大任务分解成小任务）
 */
public class T00F1 {

	private static class Boss extends Thread {
		private List<Worker> workers = new ArrayList<>();

		public void addTask(Worker worker) {
			workers.add(worker);
		}

		@Override
		public void run() {
			workers.stream().forEach((t) -> t.start());
		}

		public void end(Worker worker) {
			if (worker.getResult() == Result.FAILED) {
				cancel(worker);
			}
		}

		private void cancel(Worker worker) {
			for (Worker w : workers) {
				if (w != worker) {
					w.cancel();
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Boss boss = new Boss();
		Worker t1 = new Worker(boss, "t1", 3, true);
		Worker t2 = new Worker(boss, "t2", 4, true);
		Worker t3 = new Worker(boss, "t3", 1, false);

		boss.addTask(t1);
		boss.addTask(t2);
		boss.addTask(t3);

		boss.start();

		System.in.read();


	}

	private static enum Result {
		NOTEND, SUCCESSED, FAILED, CANCELLED
	}

	private static class Worker extends Thread {
		private Result result = Result.NOTEND;

		private Boss boss;
		private String name;
		private int timeSeconds;
		private boolean success;
		private boolean cancelling;

		public Worker(Boss boss, String name, int timeSeconds, boolean success) {
			this.boss = boss;
			this.name = name;
			this.timeSeconds = timeSeconds;
			this.success = success;
		}

		@Override
		public void run() {
			int interval = 100;
			int total = 0;
			for (; ; ) {
				try {
					Thread.sleep(interval);//cpu密集型
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				total += interval;
				if (total / 1000 >= timeSeconds) {
					System.out.println(name + " 任务结束！" + result);//正常结束
					result = success ? Result.SUCCESSED : Result.FAILED;
					break;
				}

				if (cancelling) {
					rollback();
					result = Result.CANCELLED;
					cancelling = false;
					System.out.println(name + "任务结束！" + result);
					break;
				}
			}

			boss.end(this);
		}

		private void rollback() {
			// 如何书写回滚？
			System.out.println(name + " rollback start ...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " rollback end!");

		}

		public void cancel() {
			// 思考一下，如何才能cancel?
			cancelling = true;
			// 思考一下，在run中如何处理

		}

		public Result getResult() {
			return result;
		}
	}
}
