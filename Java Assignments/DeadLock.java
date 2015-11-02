/*
 * DeadLock.java
 * Versions
 *  $ Id $
 * Revisions 
 *  $ Log $
 * 
 * 
 */
/*
 * DeadLock.java
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
import java.lang.*;
/*A Simple Java class to implement Deadlock where in two threads are waiting for each other's lock to be released unaware of the fact
 * that they are holding each other's lock which results in them waiting forever resulting in deadlock*/
public class DeadLock{

	
	public static void main(String[] args) {
		
    final Object firstResource="First Resource";       /*  Two objects with First and Second Resource as values are used as instances
                                                           for synchronization  */
    final Object secondResource="Second Resource";     
    
    Thread firstThread = new Thread() {
    
    	public void run()                              /* run method for the firstThread */
    	{
    		synchronized(firstResource)
    		{
    			System.out.println("First Thread:Locked First Resource");
    			
    		
    		try{
    			Thread.sleep(100);				     /*Holds the lock for the firstResource and goes to sleep*/
    		}catch(InterruptedException e)
    		{}
    		synchronized(secondResource)
    		{
    			System.out.println("First Thread:Locked second Resource");
    		}
    		
    		}	
    		
    	}
    	
    };       /* Anonymous class used to synchronize two objects with just a single thread */
    
    Thread secondThread = new Thread() {
        
    	public void run()                     /*Run method for the second thread*/
    	{
    		synchronized(secondResource)
    		{
    			System.out.println("Second Thread:Locked First Resource");
    			
    		
    		try{
    			Thread.sleep(100);             /*Holds the lock for the secondResource and goes to sleep*/
    		}catch(InterruptedException e)
    		{}
    		synchronized(firstResource)
    		{
    			System.out.println("Second Thread:Locked second Resource");
    		}
    		
    		}	
    		
    	}
    	
    };  /* Anonymous class used to synchronize two objects with just a single(that is the second thread) thread */
    
    
    firstThread.start(); 
    secondThread.start();
	}

}       
