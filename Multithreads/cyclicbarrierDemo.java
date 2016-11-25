package MultithreadsDemo;

//CyclicBarrier: A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.


//CyclicBarrier vs CountdownLatch

//1. One major difference is that CyclicBarrier takes an (optional) Runnable task which is run once the common barrier condition is met.
//It also allows you to get the number of clients waiting at the barrier and the number required to trigger the barrier. 
//Once triggered the barrier is reset and can be used again.


//2. in CoundownLatch, the countdown value could not be reset, that can happen in the case of CyclicBarrier.

//For simple use cases - services starting etc... a CountdownLatch is fine. A CyclicBarrier is useful.
//for more complex co-ordination tasks. An example of such a thing would be parallel computation - where 
//multiple subtasks are involved in the computation - kind of like MapReduce.



//scenario:
//10 persons are heading for a visit. They have to move until everyone arrives the spot

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class cyclicbarrierDemo {

	public static void main(String[] args) {
		int visitors = 10;
		CyclicBarrier barrier = new CyclicBarrier(visitors, new Runnable() {
			@Override
			public void run() {
				System.out.println("Let's go together!");
			}
		});
		for (int i = 1; i <= visitors; i++) {
			new Thread(new CyclicBarrierWorker(i, barrier)).start();
		}
	}
}

class CyclicBarrierWorker implements Runnable {
	private int id;
	private CyclicBarrier barrier;
	public CyclicBarrierWorker(int id, final CyclicBarrier barrier) {
		this.id = id;
		this.barrier = barrier;
	}
	@Override
	public void run() {
		try {
			System.out.println(id + " th people is waiting");
			barrier.await();  //everyone is waiting for the last person.
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}

/*
2 th people is waiting
4 th people is waiting
3 th people is waiting
6 th people is waiting
1 th people is waiting
7 th people is waiting
5 th people is waiting
8 th people is waiting
9 th people is waiting
10 th people is waiting
Let's go together!
*/
