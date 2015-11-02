import java.net.*;  
import java.io.*;  
/*
 *  @ Shravya Narayan Sarma
 *  Meant for Receiving input to perform appropriate operation
 */

public class SimpleClient {  
public static void main(String args[]) throws IOException{  

	while ( true ) {
		DataOutputStream os = null;
		
		System.out.println( "Enter an integer (0 to stop connection, 1 to publish an,2 to subscribe to a topic,"
				          + "3 to advertise,4 to subscribe by content,5 to unsubscribe):");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String keyboardInput = br.readLine();
		

		int n = Integer.parseInt( keyboardInput );
		switch(n){
		
		case 1 :  Publisher pub = new Publisher(1,"publish","pub");
			      pub.start();
			      break;
			     
		case 2 :  
			      Subscriber sub = new Subscriber(2,"subscribe","sub","topic");
		          sub.start();
		          break;
		          
		case 3 :   
			      Publisher publisher = new Publisher(1,"publish","advertise");
		          publisher.start();
		          break;
		
		case 4 :   
		          Publisher publisherAdvertise = new Publisher(1,"publish","advertise");
		          publisherAdvertise.start();
	              break;
		case 5 :  
		          Subscriber unsub = new Subscriber(2,"subscribe","unsub","topic");
	              unsub.start();
	              break;
	
		case 0 :  System.exit(0);
                  break;
          
		}
		
		}

	
}  
}