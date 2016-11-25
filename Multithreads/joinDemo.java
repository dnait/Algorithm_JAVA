package MultithreadsDemo;

//The join() method waits for a thread to die. In other words, it causes the currently running 
//threads to stop executing until the thread it joins with completes its task.
//Syntax:
//public void join()throws InterruptedException
//public void join(long milliseconds)throws InterruptedException

//Here, we created another thread t in main thread. t need to run 5 seconds (we use sleep)
//the main thread first run 2 seconds, then need to wait t thread to finish 
//so we use join()


public class joinDemo {

	public static void main(String[] args) throws InterruptedException {
		long gap = System.currentTimeMillis();
		System.out.println("Running...");
		Thread t = new Thread(){
			@Override
			public void run() {
				try {
					//mythread will run 5 seconds
					System.out.println("mythread is starting...");
					Thread.sleep(5000);
					System.out.println("mythread stopped.");
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
		
		//assume main thread will run 2 seconds;
		Thread.sleep(2000);
		System.out.println("mainthread is done, waiting for t thread");
		long joinstart = System.currentTimeMillis();
		t.join();
		System.out.println("t thread has done. Main thread waits for " + (System.currentTimeMillis() - joinstart) / 1000 + " seconds");
		System.out.println("Total runtime is " + (System.currentTimeMillis() - gap) / 1000 + " seconds.");

	}
}

/*
output:
Running...
mythread is starting...
mainthread is done, waiting for t thread
mythread stopped.
t thread has done. Main thread waits for 3 seconds
Total runtime is 5 seconds.
*/
