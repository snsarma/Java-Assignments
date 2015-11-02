/*
 * HashSet.java
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
/* HashSet Implements AnotherHashSet class */
import java.lang.*;
public class HashSet implements AnotherHashSet {

	   /*Creates an object array*/
		  Object [] HashSetArray = new Object[10000];
		  int count,startTime;
		  
		/*Constructor to initialize all the elements to null*/ 
		 public HashSet()
		 {
			
			for(int i=0;i<10000;i++) 
			  HashSetArray[i]=null;
			 
		 }
		 /*Adds elements to the hashset*/ 
		 public boolean add(Object o)
		 {
			int hashValue=0;
			int i=0;
			hashValue=Math.abs(o.hashCode()%10000);
	       /*Calculates the hashcode to insert elements*/					
			if(HashSetArray[hashValue]== null)
			{		
			  /*If there are no elements with that hashCode present */	
				HashSetArray[hashValue]=o;
				count++;
				return(true);
			    
			}		
			else if(HashSetArray[hashValue]!= null)
			{	
				 if(o.equals(HashSetArray[hashValue]))
				 {
					/*Incase the element already exists*/ 
					return(false);
				 }	 
				 else
				 {		 
				   /*Incase of collision chain them with a linked list*/	 
				   LinkList linklist = new LinkList();
				   Object temp=HashSetArray[hashValue];
				   linklist.insert(temp);
				   count++;
			      return(true);
				 } 
			}
							
			else
				return false ;
			 
		 }
		 
		 public void clear()
		 {
			for(int i=0;i<10000;i++)
				HashSetArray[i]=null;
			 /*Remove all of the elements from the hashtable*/
		 }
		 
		 public int size()
		 {
			 return(count);
			 /*Returns the actual size of hashTable*/
		 }
		 
		 public boolean contains(Object o)
		 {
			 boolean flag =false;
			 for(int i=0;i<10000;i++)
			 {	 
				 if(o.equals(HashSetArray[i]))
				 {	 
					 flag=true;
				 }
			 }
			/*If it contains an element already with that value*/ 		 
			 return(flag); 
		 }
		 
		 public boolean remove(Object o)
		 {
			 boolean flag=false;
			 for(int i=0;i<10000;i++)
			 {
				 if(o.equals(HashSetArray[i]))
				 {
					 HashSetArray[i]=null;
					 flag=true;
				 }
				 
			 }
			 /* Removes elements from the HashSet*/
			 return(flag);
		 }

		 public boolean isEmpty()
		 {
			boolean flag=false;
			 
			 if(count == 0)
			 {
				 flag=true;
			 }
			 
			 return(flag);
			 /*To check if it is empty*/
		 }
		 

	}
/* Contains the datastructure for linked list */
	class Link
	{

	  Object info;
	  public Link nextNode;
	  
	  public Link()
	  {
	  	
	  	info=null;
	  }
	  
	  public Link(Object info)
	  {

	   this.info=info;

	  }


	}
/* In order to operate on the linked list */
	class LinkList
	{

	  private Link first;
	  
	  
	  public LinkList()
	  {
	    first = null;
	     
	  }

	  public void insert(Object info)
	  {
	    Link link=new Link(info);
	    if(first == null)
	    {
	  	
	  	  first=link;
	  	  first.nextNode=null;
	  	    
	    
	    }
	    else
	    {	  
	  	 Link cur=new Link();
	  	 Link prev=new Link();
	       cur = first;
	      while(cur != null )
	      {
	      	prev=cur;
	      	cur=cur.nextNode;
	      }
	      cur=link;
	      cur.nextNode=null;
	      prev.nextNode=cur;
	     
	    }
	  
	  }
	  
	  public void display()
	  {
	     
	  	Link cur=new Link();
	  	Link prev=new Link(); 
	  	cur=first;
	     while(cur!=null){
	       cur=cur.nextNode;
	     }
	  }
	}

