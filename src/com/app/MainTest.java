package com.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService application =Executors.newCachedThreadPool();
		
        Buffer sharebuffer=new ListBuffer();
        
        application.execute(new Produce(sharebuffer));
        application.execute(new Consumer(sharebuffer));
        
        application.shutdown();
        
	}

}
