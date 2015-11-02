import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/*
 *  @ Shravya Narayan Sarma
 *  Meant for publishing or advertising a topic/Event
 */

public class Publisher extends Thread {
   
	private int id;
	private String methodType;
	private String clientType ;
	
	public Publisher(int id,String methodType,String clientType){
		this.id = id;
		this.methodType = methodType;
		this.clientType = clientType;
	}
	public void run(){
		try{  
			Socket s = new Socket("localhost",2002);  
			OutputStream os = s.getOutputStream();  
			ObjectOutputStream oos = new ObjectOutputStream(os);  
			System.out.println("In Publisher Class");
			if(this.methodType.equals("publish")){
				System.out.println("Enter the Event Id Name and Keywords:");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String temp[] = br.readLine().split(" ");
				int number = Integer.parseInt(temp[0]);
				String title = temp[1];
				String content = temp[2];                                    // Logic for Publishing the Event
				String keywords = temp[3];                                   // Receive input from standard input
				/*InputStreamReader stdin = new InputStreamReader(System.in);
		        BufferedReader console = new BufferedReader(stdin);
		        int number = 0;
		        System.out.print("Enter first number ");
	            String firstString = console.readLine();
	            number = Integer.parseInt(firstString);
	            System.out.print("Enter title ");
	            String title = console.readLine();
	            System.out.print("Enter content ");
	            String content = console.readLine();
	            System.out.print("Enter keywords ");
	            String keywords = console.readLine();*/
	            
				Event event = new Event(number,title,content,keywords);
			    // Event event = new Event(23,"International Sports","Superbowl","NFL");
				oos.writeObject(event); //Sending the object to Event Manager
			}
			
			else {
				System.out.println("Advertise");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String temp[] = br.readLine().split(" ");
				int n = Integer.parseInt(temp[0]);                               //Logic for advertising a topic
				String title = temp[0];                                          //Receiving input from the standard input 
				String keywords = temp[1];
				Topic topic = new Topic(n,title,keywords,"pub");
				//Topic topic = new Topic(234,"Sports","NFL","pub");
			    oos.writeObject(topic);                                          //Sending Object to Event Manager 
			}
			oos.close();  
			os.close();  
			s.close();  
			}catch(Exception e){System.out.println(e);}  
			
	}
	
}
