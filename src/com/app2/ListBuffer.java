package com.app2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ListBuffer implements Buffer{

	public static List<Integer> list=new ArrayList<Integer>();
	int count=0;
	private boolean occupied=false; //whether the buffer is occupied
	private final Lock lock = new ReentrantLock();
	private final Condition canWrite=lock.newCondition();
	private final Condition canRead=lock.newCondition();
	public synchronized void set(int value)throws InterruptedException{
		//while there are no empty location, place thread in the waiting state a blocked state
		this.lock.lock();
		try
		{
		while(occupied){
			System.out.println("Produce is putting data new ");
			displayState("List is full ");
			//wait();
			canWrite.await();
			
		}
		
		list.add(value);
		++count;
		   if (list.size() == 10) {
			this.occupied =true;
			System.out.println("\n-- --  \n"+list.toArray());
		}
		showList();
		canWrite.signal();
		//notifyAll(); //Tell the waiting Thread to releases the lock on synchronized buffer
		}finally
		{
			this.lock.unlock();
		}
	}
	
	
	public void displayState(String mg){
		System.out.printf("%-40s%d\t\t%b\n\n", mg, count, occupied);
	}
	
	public void showList(){
		System.out.println("\nthe Produced size of list: "+count+ "\n");
		for(int l : list)
			
			System.out.println("       Producing data: "+ l);
	}
	
	public synchronized List<Integer> get()throws InterruptedException{
		List<Integer> alist=new ArrayList<Integer>();
		//if the buffer is empty, no data to read then place the Thread into blocked state waiting to fill in
		this.lock.lock(); //lock this object
		try
		{
		while(list.size()==0) {
			System.out.println("Buffer is empty  ...  Consumer please waiting ... \n");
			//wait();
			canRead.await();
		}
		
		if (list.size() == 10) {
		  System.out.println("The Buffer is full and to cinsumering now\n");
		    //alist=list;
		}
			for(int i=0; i<list.size(); i++){
				alist.add(list.get(i));
				System.out.printf("\t%2s%3d\n", "The value has been addes:  ",list.get(i));
				list.remove(i);
				}
		  canRead.signal();
		//notifyAll();
		}finally{
			this.lock.unlock();
		}
		return alist;
	}
}
