package com.app2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
public class Consumer implements Runnable{

	private final static Random generator =new Random();
	private final Buffer sharebuffer;
	public static List<Integer> s =new ArrayList<Integer>();
	public Consumer(Buffer buffer){
		sharebuffer=buffer;
	}
	
	public void run(){
		int sum=0;
		String name = Thread.currentThread().getName();
		System.out.println("Thread Name:  "+name);
		List<Integer> s =new ArrayList<Integer>();		
		for(int count=1; count<=12; count++)
		{
			try
			{
				Thread.sleep(generator.nextInt(3*3000));	
				s=sharebuffer.get();
				//Thread.sleep(generator.nextInt(3000));
				System.out.printf("\n\t%12s%18d\n","The consumerd size of the list: ",s.size());
				sum=s.size();
				for(int j=0; j<sum; j++) {
				 System.out.printf("\t%2d%6s%8d\n", j," The Thread consumering data ", s.get(j));
				
				}
			}catch(InterruptedException exception)
			{
				exception.printStackTrace();
			}
		}	
		
		 System.out.println("Consumer read a list : "+s.toString());
		 
		System.out.println("HashSet has been created : ");
	    
			 
		 
		  
		  
			
	}
}
