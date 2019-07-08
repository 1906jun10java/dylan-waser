package com.revature.threadz;

public class ThreadDemo {
	public static void main(String[] args)
	{
		Thread extendThread = new ExtendThread(); //of type Thread
		Thread implementThread = new Thread(new ImplementRunnable()); //a new thread of object Runnable
		
		implementThread.setPriority(10);
		extendThread.start();
		implementThread.start();
		for(int i = 0; i < 100; i++)
		{
			System.out.println("ello-Driver");
		}
	}
}
