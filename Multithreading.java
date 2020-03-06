package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Multithreading {
	public static int a = 0;
	public static ReentrantLock lock = new ReentrantLock();
	public static CountDownLatch l = new CountDownLatch(10);
	
	public static void add1() {
		lock.lock();
		++a;
		System.out.println(Thread.currentThread().getName() + ": " + a);
		lock.unlock();
	}
	
	static Runnable r = new Runnable() {
		public void run() {
			for (int i = 0; i < 1000; i++) {
				try {
					add1();
					Thread.sleep(2);
				} catch (InterruptedException e) {
				}
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
