package MultithreadsDemo;

/*
 * In java, there are three ways to create threads:
 * 1. Subclassing Thread and Overriding run
 * 2. Implement Runnable
 * 3. Callable and call
 * 
 * Thread vs Runnable, which is better
 * Both are good. Base on my opinion, since there is Thread Pool and all thread objects are created, 
 * then runnable might be better.
 * 
 * This is the case to open 10 threads which named from 1 ~ 10
 * each thread will print its own name and then stop.
 * 
 * Attention: 
 * MyRunnable runnable = new MyRunnable();
 * Thread thread = new Thread(runnable, "New Thread");
 * thread.start();
 * System.out.println(thread.getName());
 * 
 * However, MyRunnable is not subclass of Thread, so MyRunnable has no getName(),
 * we can get instance of currentThread by 
 * Thread.currentThread();
 * so we can get the name of by 
 * String threadName = Thread.currentThread().getName();
 */

public class basicDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {
			new Thread("" + i) {
				public void run() {
					System.out.println("Thread: " + getName() + "running");
				}
			}.start();
		}
	}
}

/*
main
Thread: 0running
Thread: 1running
Thread: 2running
Thread: 3running
Thread: 4running
Thread: 5running
Thread: 6running
Thread: 7running
Thread: 8running
Thread: 9running
*/
