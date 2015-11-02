package Partial;

//import Comparator;
//import Link;
//import PLinkList;
//import PartialCollections;


interface PartialCollections
{
	
	public void shuffle(PLinkList pl);
	public void sort(PLinkList pl);
	
}

/* A class that impl */
public class PartialCollectionsImpl implements Comparator,PartialCollections {

	public int compare(Object o1,Object o2)
	{
	   int i1=(Integer)o1;
	   int i2=(Integer)o2;
	   
	   return(i1<i2? -1 :(i1==i2)?0:1);
		
	}
	
	/* A sort method to sort the elements in a linked list*/
	public void sort(PLinkList pl)
	{
		pl.addLast(10);
		pl.addLast(50);
		pl.addLast(5);
		pl.addLast(20);
		pl.addLast(2);
		pl.addLast(200);
		pl.addLast(15);
		pl.addLast(25);
		pl.addLast(130);
		pl.addLast(30);
		pl.addLast(120);
		pl.addLast(60);
		//pl.display();
		pl.sort();
		//System.out.println("The sorted elements:");
		//pl.display();
				
		
	}
	/* A shuffle method to shuffle the elements */
	public void shuffle(PLinkList pl)
	{
		//System.out.println("Shuffle function;");
		pl.shuffle();
		System.out.println("The shuffled list is:");
		pl.display();
	}
	public void sort(PLinkList pl,PartialCollections pc)
	{
	  pl.sort();	
	}

	
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
/*Class for linked list*/
class Link
{

  int info;
  //private Link first;
  public Link nextNode;
  public Link prevNode;
  
  public Link()
  {
  	info=0;
  	nextNode=null;
  	prevNode=null;
  }
  
  public Link(int data)
  {

   info=data;

  }


}

/*class for Partial Linked List*/
class PLinkList
{
	private Link first;
    public int index;
	public PLinkList()
	  {
	    first = null;
	  	index=0;
	  }

	public void addLast(int data)
	  {
	    Link link=new Link(data);
	    if(first == null)
	    {
	  	
	  	  first=link;
	  	  first.nextNode=null;
	  	  first.prevNode=null;
	      index++;
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
	      cur.prevNode=prev;
	      
	    }
	      index++;
	  }
	
	void display()
	{
      Link cur=new Link();
      cur=first;
      while(cur!=null)
      {
    	  System.out.println(cur.info);
    	  cur=cur.nextNode;
      }
		
		
	}	
	
	void sort()
	{
		//Link prev=new Link();
		/*Link cur=new Link();
		Link tempNode=new Link();
		int temp;
		cur=first;
		prev=cur;
		cur=cur.nextNode;
		int i=0;
		for(;prev.nextNode!=null;prev=prev.nextNode)
		{
			 if(i>0)
			 {
				cur=prev.nextNode;
			    
			 }
				
			for(;cur.nextNode!=null;cur=cur.nextNode)
			{
				if(prev.info>cur.info)
				{
					temp=prev.info;
					prev.info=cur.info;
					cur.info=temp;
					
					
				}
					
			}
			i++;
			
		}*/
		
		int [] listArray = new int[100]; 		
		 Link cur=new Link();
		  cur = first;
		  for(int i=0;(i<index)&&(cur!=null);i++)
		  {
			  listArray[i]=cur.info;
			  cur=cur.nextNode;
		  }
		  /*for(int i=0;i<index;i++)
		  {
			  System.out.println("Array Data:"+listArray[i]);
		  }*/
		  int n=index;
		  int temp;
		  for(int i=n-2;i>=0;i--)
		  {
			  
			  for(int j=0;j<=i;j++)
			  {
				  
				  if(listArray[j]>listArray[j+1])
				  {
					  
					  temp=listArray[j];
					  listArray[j]=listArray[j+1];
					  listArray[j+1]=temp;
					  
					  
				  }
			  }
			  
			  
		  }
		  System.out.println("Sorted Data");
		  for(int i=1;i<n;i++)
			System.out.println(listArray[i]);
		  //PartialCollections pc = new PartialCollections();
		  //System.out.println("The compare method:"+pc.compare(listArray,new PartialCollections()));
	}
	
	public void shuffle()
	{
		Link cur=new Link();
		Link prev=new Link();
		int temp;
		
		cur=first;
		prev=cur;
		cur=cur.nextNode;
		
		while(cur!=null)
		{
			temp=cur.info;
			cur.info=prev.info;
			prev.info=temp;
			
			cur=cur.nextNode;
		}
	}
	
}