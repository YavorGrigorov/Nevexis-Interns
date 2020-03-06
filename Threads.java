package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Threads {

	public static int x = 0;
	public static ArrayBlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(1);
	public static CountDownLatch l = new CountDownLatch(10);
	
	static Runnable r = new Runnable() {
		public void run() {
			for (int i = 0; i < 1000; i++) {
				try {
					bq.put(x);
					Thread.sleep(2);
					bq.take();
				} catch (InterruptedException e) {
				}
				System.out.println(Thread.currentThread().getName() + ": cycle" + i);
			}
			l.countDown();
		}
	};
	
	public static void main(String[] args) {

		System.out.println("start system ......");
		
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(r, "thrd" + i);
			t.start();
		}
		
		try {
			l.await();
		} catch (InterruptedException e) {
		}

		System.out.println("stop system ......");
	}

}
