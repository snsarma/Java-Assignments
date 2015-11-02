

import java.util.List;
import java.io.*;

public class Topic implements Serializable {
	private int id;
	private String keywords;
	private String name;
	private String clientType;
	private String subscriptionType;
	
	public Topic(int id,String name,String keywords,String clientType){
		this.id = id;
		this.name = name;
		this.keywords = keywords;
		this.clientType = clientType;
	}
	
	public Topic(String name,String keywords,String clientType,String subscriptionType){
		this.name = name;
		this.keywords = keywords;
		this.clientType = clientType;
		this.subscriptionType = subscriptionType;
	}
	
	public int getTopicId(){
		  return(id);
	  }

	  	  
	  public String getTopicName()
	  {
		  return(name);
	  }
	  
	  public String getTopicKeywords(){
		  return(keywords);
	  }

	  public String getTopicClientType(){
		  return(clientType);
	  }
	  
	  public String getsubscriptionType(){
		  return(subscriptionType);
	  }
}
