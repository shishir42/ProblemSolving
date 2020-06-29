package com.program.Sample;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerSchedule {
	public static void main(String[] args) {
		Timer timeObj = new Timer();
		System.out.println("Current Time " + new Date());

		Calendar calendar = Calendar.getInstance();	    
		//calendar.add(Calendar.DATE, 1);	    
		// now get "tomorrow"
		Date tomorrow = calendar.getTime();
		calendar.set(calendar.DATE, 24);
		System.out.println("tomorrow " + tomorrow);

		// now get "yesterday"	    
		Calendar yesterdayCal = Calendar.getInstance();
		yesterdayCal.add(Calendar.DATE, -1);
		Date yesterday = yesterdayCal.getTime();
		System.out.println("yesterday " + yesterday);

		timeObj.schedule(new MyTimerTask("Current " + new Date().toString()), 5000);
		timeObj.schedule(new MyTimerTask("yesterday " + yesterday.toString()), yesterday); //yesterday
		timeObj.schedule(new MyTimerTask("tomorrow" + tomorrow.toString()), tomorrow); //Tomorrow

		MyDaemonThread t1 = new MyDaemonThread();
		t1.setName("DaemonThread");
		t1.setDaemon(true);
		t1.start();

		MyDaemonThread t2 = new MyDaemonThread();
		t2.setName("UserThread");
		t2.setDaemon(false);
		t2.start();
	}
}

class MyDaemonThread extends Thread{
	public void run() {
		while (true) {
			if(Thread.currentThread().isDaemon()){  				
				try {
					System.out.println("daemon thread work");
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}  
			else{  
				///System.out.println("user thread work");  
			} 
		}
	}
}

class MyTimerTask extends TimerTask {
	String param;
	public MyTimerTask(String param) {
		this.param = param;
	}

	@Override
	public void run() {		
		System.out.println("My Timer task started at " + this.param);
	}	
}
