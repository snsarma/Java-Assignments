/*
 * Prime.java
 * Versions
 *  $ Id $
 * Revisions 
 *  $ Log $
 * 
 * 
 */
/*
 * Prime.java
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
/*Java class to implement the feature to find out whether a number is prime or not which receives input as command line arguments where in large numbers such as
 * BigIntegers are used to verfify whether they are prime or not For  example the program works fine for numbers like 980000 and numbers in that range but for numbers like 1000000000000187 it takes a lot of time
 * Tried following the square root of a number procedure does not work for BigIntegers*/
import java.lang.*;
import java.math.*;

public class Prime extends Thread {
	 BigInteger inputNumber;
	 int index;
		
		public Prime(BigInteger number,int i)
		{
			inputNumber=number;					/*Constructor defined to initialize the inputnumber and the index of command-line argument*/
            this.index=i;
		}
		
		private synchronized void calcPrime()
		{
			boolean flag=false;					/*Inorder to detect whether the number is prime or not*/
			BigInteger i=BigInteger.valueOf(2);
			
			while(i.compareTo(inputNumber)<0) /*Loop it until the previous number*/
			{
				
				  if((inputNumber.mod(i))==(BigInteger.valueOf(0))) /*check if it has any divisors other than itself*/
				 {
			         
					  flag=true;
					  break;
					  
				 }
				  i = i.add(BigInteger.ONE); /*Keep increementing by 1*/
			}
			
			
			if(flag == true)
			System.out.println("index"+"="+index+" "+"is not prime"); /*Based on the flag value display whether it is prime or not */
			else
				System.out.println("index"+"="+index+" "+"is prime");
		}
		
		public void run()
		{
			calcPrime(); /*Invokes the run method*/
		}
	
	public static void main(String[] args) {
		
		
		for(int i=0;i<args.length;i++)        /*Loop through all of the command line arguments*/         
		{	
		   new Prime(new BigInteger(args[i]),i).start();/*Invoke the start method on each thread*/
		}

		
	}

}