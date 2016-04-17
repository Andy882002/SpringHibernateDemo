package com.test;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int t=99;
         System.out.println("input data is  "+t);
         testif(t);
	    
	}
	
	public static void testif(int c){
		int t=99;
		if ( c==t ) {
       	 System.out.println("Final resulr: "+ t);
          t++;
		}
        
        if (c >102 ) {
       	 System.out.println("This is in level 102"+t);
          t++;
        }
        
        if (c<102 || c ==99 ) {
       	 for(int i=0; i<103; i++)
       	 c++;
       	 System.out.println("level 102 -- 99\n"+t);
       	 if (c==202) {
       	 t=c; 
       	 
       	 }
        }
        
	    System.out.println("Last level resulr: "+t);
	}

}
