package test_gdata;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.util.AuthenticationException;

public class TestDocumentList {
	public static void main(String []arg) throws AuthenticationException, MalformedURLException
	{
		try {
		DocsService service = new DocsService("Document list Demo");
		System.out.println(service.toString());
		service.setUserCredentials("njanani437@gmail.com", "janu_aneesh1991");
		URL documentListFeedUrl = new URL("http://docs.google.com/feeds/documents/private/full");
		//System.out.println(documentListFeedUrl.);
			DocumentListFeed feed = service.getFeed(documentListFeedUrl, DocumentListFeed.class );
			for(DocumentListEntry entry: feed.getEntries())
			{

				System.out.println(entry.getTitle().getPlainText());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
System.out.println(e.getMessage());
}
		
		
	}
 
}
