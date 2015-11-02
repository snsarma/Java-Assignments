

import java.util.List;
import java.net.*;
import java.io.*;


public class Event implements Serializable {
	private int id;
//	private Topic topic;
	private String title;
	private String content;
	private String keywords;
	
	 
	public	Event(int id,String title,String content,String Keywords)
	{
	 
		this.id=id;
		this.title = title;
		this.content = content;
		this.keywords = Keywords;
		
	}

  public int getEventId(){
	  return(id);
  }

  
  public String getTitle()
  {
	  return(title);
  }
  
  public String getContent()
  {
	  return(content);
  }
  
  public String getTopicKeywords(){
	  return(keywords);
  }
  
}

