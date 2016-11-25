package MultithreadsDemo;

//About thread name, JVM will give a name if we don't give a name. The name will help to 
//tell which thread is running

public class basicDemo01 {

	public static void main(String[] args) {
		
		//Print man thread's name
		System.out.println("main thread's name: " + Thread.currentThread().getName());
		
		//Create a thread without a name, then JVM will assign one.
		new Thread() {
			@Override 
			public void run() {
				
				//Check the name JVM assigned:
				System.out.println("JVM name is: " + this.getName());
				
			}
		}.start();
		
		//Create a thread with our name		
		new Thread(new MyRunnable(), "our thread").start();
		new Thread(new MyRunnable(), "Your thread").start();

	}
	
	static class MyRunnable implements Runnable{
		@Override
		public void run() {
			
			//Print current thread name
			System.out.println("Current thread name: " + Thread.currentThread().getName());
		}
	}
	

}

/*
output:
main thread's name: main
JVM name is: Thread-0
Current thread name: our thread
Current thread name: Your thread
*/
