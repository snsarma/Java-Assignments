import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
/*
 *  @ Shravya Narayan Sarma
 *  Meant for Subscribing to a topic/Content
 */

public class Subscriber extends Thread{
	private int id;
	private String methodType;
	private String clientType ;
	private String subType;
	
	public Subscriber(int id,String methodType,String clientType,String subType){
		this.id = id;
		this.methodType = methodType;
		this.clientType = clientType;
		this.subType = subType;
	}
	public void run(){
		try{  
			Socket s = new Socket("localhost",2002);  
			OutputStream os = s.getOutputStream();  
			ObjectOutputStream oos = new ObjectOutputStream(os);  
			System.out.println("In Subscriber Class");
			if(this.methodType.equals("subscribe") && (this.subType.equals("topic"))){
				InputStreamReader stdin = new InputStreamReader(System.in);
		        BufferedReader console = new BufferedReader(stdin);
		        int number = 0;
		        System.out.print("Enter first number ");
	            String firstString = console.readLine();                    //Logic for subsricption to a Topic 
	            number = Integer.parseInt(firstString);
	            System.out.print("Enter title ");                                
	            String title = console.readLine();
	            System.out.print("Enter content ");
	            String content = console.readLine();
	            System.out.print("Enter keywords ");
	            String keywords = console.readLine();
	            Topic topic = new Topic(title,keywords,"sub","topic");
	            //Topic topic = new ("International Sports","NFL","sub","topic");
			    oos.writeObject(topic);
			}
			
			else if(this.methodType.equals("subscribe") && (this.subType.equals("content"))){
				InputStreamReader stdin = new InputStreamReader(System.in);
		        BufferedReader console = new BufferedReader(stdin);
		        int number;
		        System.out.print("Enter first number ");
	            String firstString = console.readLine();
	            number = Integer.parseInt(firstString);
	            System.out.print("Enter title ");
	            String title = console.readLine();                              ////Logic for subsricption to a Topic
	            System.out.print("Enter content ");
	            String content = console.readLine();
	            System.out.print("Enter keywords ");
	            String keywords = console.readLine();
	            Topic topic = new Topic(title,keywords,"sub","content");
	          //Topic topic = new ("International Sports","NFL","sub","topic");
			    oos.writeObject(topic);
			}
			
			else {
				   InputStreamReader stdin = new InputStreamReader(System.in);
		           BufferedReader console = new BufferedReader(stdin);
				   System.out.println("unsubscribe");
				   System.out.print("Enter title ");
		           String title = console.readLine();
		           System.out.print("Enter keywords ");                      //Logic for unsubscribing from a Topic
		           String keywords = console.readLine();
		           Topic topic = new Topic(title,keywords,"unsub","topic");
		         //Topic topic = new ("International Sports","NFL","unsub","topic");
				   oos.writeObject(topic);
			}
			 
			oos.close();  
			os.close();  
			s.close();  
			}catch(Exception e){System.out.println(e);}  
			
	}

}
