package MultithreadsDemo;

import java.util.concurrent.Semaphore;

//The Semaphore flag signaling system is an alphabet signalling system based on the waving of 
//a pair of hand-held flags in a particular pattern.

//So what is semaphore in java? The simplest way to think of a semaphore is to consider it an abstraction that 
//allows n units to be acquired, and offers acquire and release mechanisms. It safely allows us 
//to ensure that only n processes can access a certain resource at a given time.
//acquire() can get a permission,  release() can release a permission (must acquire() first)


//case:
//The factory has 5 machines but 8 workers, one machine can only be used by one person.
//Workers can only use it when one machine is available. How to arrange this?
//Use Semaphore
public class SemaphoreDemo {

	public static void main(String[] args) {
		int workers = 8;
		Semaphore semaphore = new Semaphore(5); //machines' number
		for (int i = 0; i < workers; i++) {
			new Arranger(i, semaphore).start();
		}
	}
	
	static class Arranger extends Thread {
		private int num;
		private Semaphore semaphore;
		public Arranger(int num, Semaphore semaphore) {
			this.num = num;
			this.semaphore = semaphore;
		}
		
		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("worker " + this.num + "is using a machine");
				Thread.sleep(2000);
				System.out.println("worker " + this.num + "releases the machine" );
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
/*
worker 0is using a machine
worker 2is using a machine
worker 3is using a machine
worker 1is using a machine
worker 4is using a machine
worker 3releases the machine
worker 1releases the machine
worker 2releases the machine
worker 6is using a machine
worker 4releases the machine
worker 0releases the machine
worker 7is using a machine
worker 5is using a machine
worker 6releases the machine
worker 7releases the machine
worker 5releases the machine

or

worker 0is using a machine
worker 3is using a machine
worker 2is using a machine
worker 1is using a machine
worker 4is using a machine
worker 3releases the machine
worker 4releases the machine
worker 2releases the machine
worker 1releases the machine
worker 0releases the machine
worker 6is using a machine
worker 7is using a machine
worker 5is using a machine
worker 5releases the machine
worker 7releases the machine
worker 6releases the machine
*/
