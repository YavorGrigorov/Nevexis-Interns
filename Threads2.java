package test;

import java.util.concurrent.ArrayBlockingQueue;

public class Threads2 {

	public static int x = 0;
	public static ArrayBlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(1);

	static int a = 0;
	
	static String loack1 = "fdfgsdff";
	
	synchronized static void incA() {
		System.out.println("start system ......");
		
		synchronized (loack1) {
			a = a+1;
		}
		
		System.out.println("start system ......");
	}
	
	static Runnable r = new Runnable() {
		public void run() {
			for (int i = 0; i < 100000; i++) {
				try {
					incA();
					Thread.sleep(2);
				} catch (InterruptedException e) {
				}
				System.out.println(Thread.currentThread().getName() + ": cycle" + i);
			}
		}
	};

	public static void main(String[] args) {

		System.out.println("start system ......");

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(r, "thrd" + i);
			t.start();
		}

		System.out.println("stop system ......");
	}

}
