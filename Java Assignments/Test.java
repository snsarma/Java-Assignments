/*
 * Test.java
 * Versions
 *  $ Id $
 * Revisions 
 *  $ Log $
 * 
 * 
 */
/*
 * Test.java
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


public class Test {

	public static void main(String [] args)
	{
      /*Creates a hashset object */		
		HashSet t=new HashSet();
		boolean flag;/*Flag is a boolean variable*/
		Object o=1;
		/*Time is recorded before any of the operations are performed*/
		double Time=System.currentTimeMillis();
		System.out.println("Time:"+Time);
		for(int i=2;i<100;i++)
		{
		   /*Add each individual element to the array*/	
			t.add(i);
			
		}
		
		System.out.println("System current Time:"+System.currentTimeMillis());
		//System.out.println("Time:"+(System.currentTimeMillis()-Time)+"milliseconds");
		flag=t.add(o);
		if(flag == true)/*Verification of addition of element*/
		System.out.println(o+"Successfully added");
		else
		System.out.println(o+"Already exists");
		o=1;
		flag=t.add(o);
		if(flag == true)/*Successfully added */
		System.out.println(o+"Successfully added");
		else
		System.out.println(o+"Already exists");
		t.add(1.2);
		t.add("Java");
		t.add("Collections");
		flag=t.contains("Collections");
		if(flag == true)/*Verification of whether the above element is present*/
		 System.out.println("It contains the above element");	
		flag=t.remove("Collections");
		if(flag== true)/*Verification of removal*/
			System.out.println("The above element is removed");
		flag=t.contains("Collections");
		if(flag == true)
			 System.out.println("It contains the above element");
		else
			 System.out.println("It does not contain the above element");
		System.out.println("The size of Hashset is:"+t.size());
		flag=t.contains("Java");
		if(flag == true)
			System.out.println("It contains the above element");
		else
			System.out.println("It does not contain the above element");
		flag=t.isEmpty();
		if(flag == true)
			System.out.println("It is Empty");
		else
			System.out.println("It is not empty");
		/* prints the time required to perform the operations*/
		System.out.println("Time:"+(System.currentTimeMillis()-Time)+"milliseconds");
		
	}
}
