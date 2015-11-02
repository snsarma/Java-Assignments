/*
 * Matrix.java
 * Versions
 *  $ Id $
 * Revisions 
 *  $ Log $
 * 
 * 
 */
/*
 * Matrix.java
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
/* A Simple Class that displays the multiplication of two matrices with the assistance of threads */
/* According to the requirement one is suppose to have a thread to compute the each resultant element in the matrix.I could not
 * do so Tried doing so with join() but could not so have implemented it with creating a single thread which basically does the whole
 * operation*/

public class Matrix extends Thread {

	int [][] firstMatrix={
			               {1,2,5},          /* First Matrix with 2*3 row column combination  */
			               {6,8,9}
	                    	
	                     };
	int [][] secondMatrix={
			
			                {1},           /* Second Matrix with 3*1 row column combination*/
			                {2},
			                {5}
	                                       
	                      };
	
	int[][] resultMatrix=new int[2][1];   /* Resultant Matrix with 2*1 row column combination */
	
	
	private synchronized void matrixMultiply()
	{
		for(int i=0;i<2;i++)			/*Method used to multiply two matrices */	
		{
			for(int j=0;j<1;j++)       /*Traversing through each row and column of the matrix*/
			{
				for(int k=0;k<3;k++)
				{
					resultMatrix[i][j]+=firstMatrix[i][k]*secondMatrix[k][j];/*Actual Computation occurs here*/
				}
			}
		}
		System.out.println("Multiplication of Matrices:");
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<1;j++)
			{
				System.out.println(resultMatrix[i][j]);  /*Displays the resultant matrix*/
			}
		}
	}
	
	public void run()
	{
		matrixMultiply(); /*Invokes the matrixMultiply()*/
	}
	public static void main(String[] args) {
		
		new Matrix().start();/*Creates a new thread and invokes the run method*/

	}

}
