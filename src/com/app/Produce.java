package com.app;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Produce implements Runnable{

	private final static Random generator =new Random();
	private final Buffer sharebuffer;
	public static Set<Integer> s =new HashSet<Integer>();
	
	public Produce(Buffer shared){
		sharebuffer=shared;
		//s=m;
	}
	public void run(){
	int sum=0;
	String name = Thread.currentThread().getName();
	System.out.println("Thread Name:  "+name);
	 System.out.printf("\t%2s%10s", "Sum", "     Input data\n");
	for(int count=1; count<=12; count++)
	{
		try
		{
			Thread.sleep(generator.nextInt(1*3000));
			int n=generator.nextInt(3000);
			sharebuffer.set(n);
			//s.add(n);
			//sum++;
			sum+=count;
			
			System.out.printf("\t%2d%10d\n",count, n);
		}catch(InterruptedException exception)
		{
			exception.printStackTrace();
		}
	}
	
	  System.out.println("\nProducer done producing!!");
	  System.out.println("\nProducetion created a list size: "+sum+"\n");
		
	}
}
