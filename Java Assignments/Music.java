/*
 * Music.java
 * Versions
 *  $ Id $
 * Revisions 
 *  $ Log $
 * 
 * 
 */
/*
 * Music.java
 * Versions
 *  $ Id $
 * Revisions 
 *  $ Log $
 * 
 * 
 */
/*
 * @ author Shravya Narayan Sarma
 *          sxn8837
 *          
 * 
 */
 
/* Java class to implement the concept of Musical Chairs with the utilization of threads * */
import java.lang.*;
 
 public class Music extends Thread{
 
  static int noOfSeats,noOfKids,seatCounter=1,countKids=1;         /* Instance variables to define the no of chairs,the no of kids and the counter as an index for chair array */
  
 
  
  static final Object o = "Object";  /*Object to be synchronized on*/
  String [] seat = new String[100]; /* Chair array to store the chairs*/
  Object [] Kids = new Object[100];
  
  Music(int numberOfKids)
  {
  
     noOfKids=numberOfKids;
     noOfSeats=numberOfKids-1;  /* Number of chairs is always one less than the number of kids*/
     
     for(int i=1;i<=noOfSeats;i++)
     {
    	 seat[i]="Nothing";       /*Initialize the chair to nothing since no one will be seated there*/
     }
    
     for(int i=1;i<=noOfKids;i++)
      {  
    	  Kids[i]=i;     /*Initialize the Kids array with the values*/
    	                 /*Increement the no of Kids in the array*/
      }	  
  }
  
  public void run()
  {
      
       
       Thread currentThread=Thread.currentThread();
       String threadName=currentThread.getName();
       
       synchronized(o){
       
    	      
    		   if(noOfKids == 1)
    		   {
    			   System.out.println(Kids[countKids]+"is winner:");  /*if just one kid is remaining */
    			   System.exit(0);           /*Winner is declared and exits the program*/
    		   }
    		   
    		   if(seat[seatCounter]=="Nothing")
    		    {
    			        seat[seatCounter]=Kids[countKids].toString();/*If the seats are empty*/
    			        //++countKids;                             /*Kids are assigned a seat*/
    			    	System.out.println(Kids[countKids]+"\t"); /*Kids are displayed*/
    			    	
    		    }
    		    else
    		    {
    			    	System.out.println(Kids[countKids]+"is out"); /*If it is already occupied*/
    			    	
    		    }
    		   
    		   ++seatCounter;	                       /*increase the seatCounter*/
    		   ++countKids;                            /*increase the kids counter*/
    		   --noOfKids;                             /* decrease the number of kids*/
    	   
       }

       
  
  }
  public static void main(String[] args) {
	
		int noOfKids=Integer.parseInt(args[0]);/*Number of Kids is passed as command-line argument*/
 
		System.out.println(noOfKids+"are playing:"); /*Display the number of kids that are playing*/
	   try
	   { 
		for(int i=0;i<noOfKids;i++)
	    { 
	     Music music = new Music(noOfKids);   /*Start the new music thread*/
	     music.start();
	     music.join();
	    }
	   }
	   catch(Exception e)
	   {
		e.printStackTrace();   
	   }

	}
  
 }
 
	

