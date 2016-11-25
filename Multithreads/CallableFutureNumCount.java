package MultithreadsDemo;

//use Callable Future to calculate 1 ~ 100 = 5050
//Use Long for Callable since the total might be big than Integer.MAX_VALUE;

import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

class MyCallable implements Callable<Long>{
	
	private Long start;
	private Long end;
	public MyCallable(Long start, long end){
		this.start = start;
		this.end = end;
	}
	
	public Long call()throws Exception{
		long sum = 0;
		for(long i = start; i <= end; i++){
			sum += i;
		}
		System.out.println(Thread.currentThread().getName() + " " +start + "-" + end + "=" + sum);
		return sum;
	}
}

public class CallableFutureNumCount {
	
	private static final int PARTITIONS = 10;
	
	public static void main(String[] args){
		ExecutorService executor = Executors.newFixedThreadPool(PARTITIONS);
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		for(long i = 0; i < PARTITIONS; i++){
			Callable<Long> worker = new MyCallable(i * PARTITIONS + 1, (i + 1) * PARTITIONS);
			Future<Long> submit = executor.submit(worker);
			list.add(submit);
		}
		
		long sum = 0;
		for(Future<Long> future : list){
			try{
				sum += future.get();
			}catch (InterruptedException e1){
				e1.printStackTrace();
			}catch(ExecutionException e2){
				e2.printStackTrace();
			}
		}
		executor.shutdown();
		System.out.println("sum = " + sum);
	}
}