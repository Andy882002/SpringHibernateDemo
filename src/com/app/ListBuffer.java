package com.app;

import java.util.ArrayList;
import java.util.List;

public class ListBuffer implements Buffer{

	public static List<Integer> list=new ArrayList<Integer>();
	int count=0;
	private boolean occupied=false; //whether the buffer is occupied
	
	public synchronized void set(int value)throws InterruptedException{
		//while there are no empty location, place thread in the waiting state a blocked state
		while(occupied){
			System.out.println("Produce is putting data new ");
			displayState("List is full ");
			this.wait();  
			
		}
		
		list.add(value);
		++count;
		//this.occupied =true;
		   if (list.size() == 3) {
			this.occupied =true;
			System.out.println("\n-- --  \n"+list.toString());
		}
		showList();
		this.notifyAll(); //Tell the waiting Thread to releases the lock on synchronized buffer 
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
		while(list.size()==0) {
			System.out.println("Buffer is empty  ...  Consumer please waiting ... \n");
			this.wait();
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
		
		this.notifyAll();
		return alist;
	}
}
