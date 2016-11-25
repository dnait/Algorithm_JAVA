package MultithreadsDemo;
/*
 * The fork-join and work-stealing
 * The fork-join framework reduces contention for the work queue by using a technique known as work stealing. 
 * Each worker thread has its own work queue, which is implemented using a double-ended queue, or deque. 
 * (Java 6 adds several deque implementations to the class library, including ArrayDeque and LinkedBlockingDeque.) 
 * When a task forks a new thread, it pushes it onto the head of its own deque. When a task executes a join operation with another task that has not yet completed, rather than 
 *sleeping until the target task is complete (as Thread.join() would), it pops another task off the head of its deque and executes that. In the event the thread's task queue is empty, 
 *it then tries to steal another task off the tail of another thread's deque.
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

//It is very similar to divide-and-conquer
//step1: divide the task into smaller ones
//step2: combine. The spited task into deque, then threads retrieve tasks from the deques.
//All small tasks' results are put into a deque, one thread will retrieve the data and combine them


public class ForkJoinCountTask extends RecursiveTask<Integer>{

	private static final int THRESHOLD = 2;
	private int start;	
	private int end;
	
	public ForkJoinCountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}


	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++)
				sum += i;
		} else {
			
			//If the task is larger than range, then split into subtasks
			int mid = (start + end) / 2;
			ForkJoinCountTask leftTask = new ForkJoinCountTask(start, mid);
			ForkJoinCountTask rightTask = new ForkJoinCountTask(mid+1, end);
			
			//subtasks are running
			leftTask.fork();
			rightTask.fork();
			
			//wait for subtasks to give the sub results
			int leftResult = (int)leftTask.join();
			int rightResult = (int)rightTask.join();
			
			//combine subtasks' results
			sum = leftResult + rightResult;
			System.out.println("sum = " + sum);
		}
		
		return sum;
	}
			

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		
        //create a task to calculate 1~ 100
		ForkJoinCountTask task = new ForkJoinCountTask(1, 100); 
        Future<Integer> result = forkJoinPool.submit(task);
        try {
        	System.out.println("Final total sum is " + result.get());
		} catch (Exception e) {
		}
	}
}
/*
sum = 10
sum = 310
sum = 553
sum = 399
sum = 363
sum = 99
sum = 210
sum = 63
sum = 435
sum = 513
sum = 110
sum = 28
sum = 203
sum = 1066
sum = 834
sum = 249
sum = 378
sum = 135
sum = 234
sum = 585
sum = 741
sum = 1575
sum = 285
sum = 534
sum = 549
sum = 213
sum = 91
sum = 416
sum = 1134
sum = 950
sum = 325
sum = 2200
sum = 1275
sum = 3775
sum = 5050
Final total sum is 5050
*/
