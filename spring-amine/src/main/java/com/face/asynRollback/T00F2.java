package com.face.asynRollback;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 异步回调回滚问题-CompletableFuture
 * （大任务分解成小任务）
 */
public class T00F2 {
	static  List<Worker> workers = new ArrayList<Worker>();

	public static void main(String[] args) throws IOException, InterruptedException {

		Worker t1 = new Worker("t1", 3, Result.SUCCESS);
		Worker t2 = new Worker("t2", 4, Result.SUCCESS);
		Worker t3 = new Worker("t3", 1, Result.FAIL);

		workers.add(t1);
		workers.add(t2);
		workers.add(t3);

		for (Worker worker : workers) {
			CompletableFuture<Void> f = CompletableFuture.supplyAsync(() -> worker.runTask())
					.thenAccept((result) -> callback(result, worker));

			TimeUnit.SECONDS.sleep(10);
		}

	}

	private static Result callback(Result result, Worker worker) {
		if(Result.FAIL == result){
			for (Worker _worker : workers) {
				if(_worker != worker){
					_worker.cancel();
				}
			}
		}
		return result;
	}

	private static enum Result {
		SUCCESS, FAIL, CANCELLED
	}

	private static class Worker  {

		private String name;
		private int timeSeconds;
		private Result result;

		private boolean cancelling = false;
		volatile boolean cancelled = false;

		public Worker(String name, int timeSeconds, Result result) {
			this.name = name;
			this.timeSeconds = timeSeconds;
			this.result = result;
		}

		public Result runTask() {
			int interval = 100;
			int total = 0;
			for (; ; ) {
				try {
					Thread.sleep(interval);//cpu密集型
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(cancelling){
					continue;
				}
				total += interval;
				if (total >= timeSeconds) {
					break;
				}
				if(cancelled){
					return Result.CANCELLED;
				}
			}

			System.out.println(name + " end! ");
			return result;

		}

		public void cancel() {
			cancelling = true;
			synchronized (this){
				System.out.println(name + " cancelling");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " cancelled");
			}

			cancelled = true;

		}

		public Result getResult() {
			return result;
		}
	}
}
