import java.io.*;
import java.net.*;
import java.util.HashMap;
/*
 *  @ Shravya Narayan Sarma
 *  Meant for handling multiple Client Connections or Requests
 */

class EventManager{
	
	public void startService(){
		try{
			ServerSocket ss = new ServerSocket(2002);
			while(true){
			    System.out.print("Listening for connections on port 2002... ");
			    Socket client = ss.accept();
			    Thread t = new Thread(new EchoClientHandlerClass(client));
			    t.start();
			    System.out.println("Connected - "+client.getInetAddress());
			   }
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args){
		EventManager server = new EventManager();
		server.startService();
		
	}
}

class EchoClientHandlerClass implements Runnable{
	 
	private Socket socket;
	 
	 public EchoClientHandlerClass(Socket incomingSocket) throws IOException{
	  socket = incomingSocket;
	 
	 }
	 
	 public void run(){
	  try{
	 
		  InputStream is = socket.getInputStream();  
		  ObjectInputStream ois = new ObjectInputStream(is);  
		  Object object = ois.readObject();
		  Event event;
		  HashMap <String,String> eventObjects = new HashMap <String,String>();
		  HashMap <String,String> topicObjects = new HashMap <String,String>();
		  HashMap <String,Integer> subscribers = new HashMap <String,Integer>();
		  int i=0;
		  if (object instanceof Event){
			  event = (Event)object;
		        System.out.println(event.getEventId());
		        System.out.println(event.getTitle());
		        System.out.println(event.getContent());          //Once the event is published the Event Manager is Notified.
		                                                         // Events are stored in a repository
		        String Title = event.getTitle();
		        String keywords = event.getTopicKeywords();
		        eventObjects.put(Title,keywords);
		        for(String key : eventObjects.keySet()){
		        	System.out.println("Title: " + key );
		        	System.out.println(" Content: " + eventObjects.get(key));
		        } 	
		  	}
		  else if(object instanceof Topic)
		  {
		  	Topic topic = (Topic)object;
		  	String clientType=topic.getTopicClientType();
		  	String subscriptionType =topic.getsubscriptionType();
		  	if(clientType.equals("pub")){                               //Publsiher advertises the topic and maintains the 
		  	                                                            // repository and this could act as Notify method too
		  	System.out.println(topic.getTopicId());
		  	System.out.println(topic.getTopicName());
		  	String Title = topic.getTopicName();
		  	String keywords = topic.getTopicKeywords();
		  	topicObjects.put(Title,keywords);
		  	for(String key : topicObjects.keySet()){
	        	System.out.println("Title: " + key );
	        	System.out.println(" Content: " + topicObjects.get(key));
	        }
		  	}
		  	
		  	if(clientType.equals("sub") && subscriptionType.equals("topic") ){
		  		
		  		subscribers.put(topic.getTopicName(),new Integer(i+1));          //Subscription to a topic
		  	}
		  	
            if(clientType.equals("sub") && subscriptionType.equals("content") ){
		  		
		  		for(String eventKeywords:eventObjects.values()){
		  			
		  			for(String topicKeywords:topicObjects.values()){              // Subscription to a content 
		  				
		  				subscribers.put(topic.getTopicName(),new Integer(i+1));
		  			}
		  		}
		  	}
            
            if(clientType.equals("unsub")){
            	subscribers.remove(topic.getTopicName());                        //Unsubscribing to a topic
            }
		  	
		  
		  	
		  }

		  else if(object == null){
		  	System.exit(0);
		  }
		  
	  }catch(Exception e){
	   System.err.println("Exception Occurs "+e.getMessage());
	  }finally{
	   try{socket.close();}catch(Exception ee){}
	  }
	 }
	}

