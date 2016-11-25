package MultithreadsDemo;
//A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
//A CountDownLatch is initialized with a given count. The await methods block until the current count reaches zero due 
//to invocations of the countDown() method, after which all waiting threads are released and any subsequent invocations of 
//await return immediately. This is a one-shot phenomenon -- the count cannot be reset. 
//If you need a version that resets the count, consider using a CyclicBarrier.
//only one onstructor: public CountDownLatch(int count) {  }; 	

import java.util.concurrent.CountDownLatch;

//main thread has to wait until CountDownLatch == 0;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(2);
		new Thread() {
			public void run() {
				try {
					System.out.println("subthread " + Thread.currentThread().getName() + " is running");
					Thread.sleep(3000);
					System.out.println("subthread " + Thread.currentThread().getName() + "stopped");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				try {
					System.out.println("subthread " + Thread.currentThread().getName() + " is running");
					Thread.sleep(3000);
					System.out.println("subthread " + Thread.currentThread().getName() + "stopped");
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		
		try {
			System.out.println("Waiting for two subthreads to finish...");
			latch.await();
			System.out.println("Two subthreads are done");
			System.out.println("Continue to run main thread");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/*
subthread Thread-0 is running
Waiting for two subthreads to finish...
subthread Thread-1 is running
subthread Thread-0stopped
subthread Thread-1stopped
Two subthreads are done
Continue to run main thread

or 

subthreadThread-0 is running
Waiting for two subthreads to finish...
subthread Thread-1 is running
subthread Thread-1stopped
subthreadThread-0stopped
Two subthreads are done
Continue to run main thread
*/
