package MultithreadsDemo;

import java.util.Date;

//sleep will make thread wait a little bit since in Java ,there is a specific 
//function called Timer
public class sleepandTimer {

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				
				while(true) {
					System.out.println("check server' status... current time: " + new Date());
					try {
						//sleep 3 seconds since checking is too busy
						this.sleep(2000);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
/*
check server' status... current time: Nov 25, 2015 3:00:42 PM
check server' status... current time: Nov 25, 2015 3:00:44 PM
check server' status... current time: Nov 25, 2015 3:00:46 PM
check server' status... current time: Nov 25, 2015 3:00:48 PM
check server' status... current time: Nov 25, 2015 3:00:50 PM
check server' status... current time: Nov 25, 2015 3:00:52 PM
*/
