

package test_gdata;
import com.google.gdata.client.Query;
import com.google.gdata.client.Service;
import com.google.gdata.client.youtube.YouTubeQuery;
import com.google.gdata.client.youtube.YouTubeService;
import com.google.gdata.data.Category;
import com.google.gdata.data.Entry;
import com.google.gdata.data.Feed;
import com.google.gdata.data.TextContent;
import com.google.gdata.data.extensions.Comments;
import com.google.gdata.data.extensions.FeedLink;
import com.google.gdata.data.media.mediarss.MediaKeywords;
import com.google.gdata.data.media.mediarss.MediaPlayer;
import com.google.gdata.data.media.mediarss.MediaThumbnail;
import com.google.gdata.data.youtube.FeedLinkEntry;
import com.google.gdata.data.youtube.PlaylistEntry;
import com.google.gdata.data.youtube.PlaylistFeed;
import com.google.gdata.data.youtube.PlaylistLinkEntry;
import com.google.gdata.data.youtube.PlaylistLinkFeed;
import com.google.gdata.data.youtube.SubscriptionEntry;
import com.google.gdata.data.youtube.SubscriptionFeed;
import com.google.gdata.data.youtube.UserProfileEntry;
import com.google.gdata.data.youtube.VideoEntry;
import com.google.gdata.data.youtube.VideoFeed;
import com.google.gdata.data.youtube.YouTubeMediaContent;
import com.google.gdata.data.youtube.YouTubeMediaGroup;
import com.google.gdata.data.youtube.YouTubeNamespace;
import com.google.gdata.util.ServiceException;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class GetRecommendation {

  /**
   * Input stream for reading user input.
   */
  private static final  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 

  static ExtractKeyword keyword = new ExtractKeyword();
  public static ArrayList<String> getTitle = new ArrayList<String>();
  public static ArrayList<String> getSearchFeed = new ArrayList<String>();
  /**
   * Get YouTube GDATA feeds
   */
 public static final String YOUTUBE_GDATA_SERVER = "http://gdata.youtube.com";
 public static final String STANDARD_FEED_PREFIX = YOUTUBE_GDATA_SERVER + "/feeds/api/standardfeeds/";
 public static final String MOST_RECENT_FEED = STANDARD_FEED_PREFIX + "most_recent";
 public static final String TOP_RATED_FEED = STANDARD_FEED_PREFIX  + "top_rated";
 public static final String MOST_VIEWED_FEED = STANDARD_FEED_PREFIX + "most_viewed";
 public static final String RECENTLY_FEATURED_FEED = STANDARD_FEED_PREFIX + "recently_featured";
 public static final String VIDEOS_FEED = YOUTUBE_GDATA_SERVER + "/feeds/api/videos";
 public static final String USER_FEED_PREFIX = YOUTUBE_GDATA_SERVER + "/feeds/api/users/";
 public static final String FAVORITES_FEED_SUFFIX = "/favorites";
 private static String defaultTestUser = "YTdebates";
  static String r =null;


  /**
   * Function to align the output in a neat manner
   *
   */
  private static void printUnderlined(String feedTitle) {
    System.out.println(feedTitle);
    for (int i = 0; i < feedTitle.length(); ++i) {
      System.out.print("-");
    }
    System.out.println("\n");
  }
  /**
   * Prints a VideoEntry, optionally showing its responses and comment feeds.
   *
   * @param prefix                   a string to be shown before each entry
   * @param videoEntry               the VideoEntry to be printed
   * @param showCommentsAndResponses true if the comments and responses feeds
   *                                 should be printed
   * @throws ServiceException
   *                                 If the service is unable to handle the
   *                                 request.
   * @throws IOException             error sending request or reading the feed.
   */
  private static void printVideoEntry(String prefix, VideoEntry videoEntry,
      boolean showCommentsAndResponses) throws IOException, ServiceException {
    System.out.println(prefix);
    if (videoEntry.getTitle() != null) {
    	getTitle.add(videoEntry.getTitle().getPlainText());

      System.out.printf("Title : %s\n", videoEntry.getTitle().getPlainText());
          
    }
    
    if (videoEntry.getSummary() != null) {
      System.out.printf("Summary: %s\n",
          videoEntry.getSummary().getPlainText());
    }
    YouTubeMediaGroup mediaGroup = videoEntry.getMediaGroup();
    if(mediaGroup != null) {
      MediaKeywords keywords = mediaGroup.getKeywords();
      System.out.println();
      System.out.println();
    }
    if (showCommentsAndResponses) {
      System.out.println("");
      System.out.println("");
    }
  }

  /**
   * Prints a basic feed, such as the comments or responses feed, retrieved from
   * a feedUrl.
   *
   * @param service a YouTubeService object
   * @param feedUrl the url of the feed
   * @param prefix  a prefix string to be printed in front of each entry field
   * @throws ServiceException
   *                     If the service is unable to handle the request.
   * @throws IOException error sending request or reading the feed.
   */
  private static void printFeed(Service service, String feedUrl, String prefix)
      throws IOException, ServiceException {
    Feed feed = service.getFeed(new URL(feedUrl), Feed.class);

    for (Entry e : feed.getEntries()) {
      printEntry(e, prefix);
    }
  }

  /**
   * Prints a basic Entry, usually from a comments or responses feed.   *
   * @param entry      the entry to be printed
   * @param prefix a prefix to be printed before each entry attribute
   */
  private static void printEntry(Entry entry, String prefix) {
    System.out.println("\t\t" + prefix + " Title: " 
        + entry.getTitle().getPlainText());
    if (entry.getContent() != null) {
      TextContent content = (TextContent) entry.getContent();
      System.out.println("\t\t" + prefix + " Content: " 
          + content.getContent().getPlainText());
    }
    System.out.println("\t\tURL: " + entry.getHtmlLink().getHref());
  }

  /**
   * Prints a FeedLinkEntry as a Title and URL String.
   *
   * @param feedLinkEntry the FeedLinkEntry to be printed
   */
  
  
  private static void printFeedLinkEntry(FeedLinkEntry feedLinkEntry) {
	  
    if (feedLinkEntry.getTitle() != null) {
    	
      System.out.printf("Title: %s\n", feedLinkEntry.getTitle().getPlainText());
    }
    
    System.out.println("FeedLink: " + feedLinkEntry.getFeedUrl());
  }

  
  /**
   * Prints a SubscriptionEntry, which is a FeedLink entry.
   *
   * @param subEntry the SubscriptionEntry to be printed
   */
  private static void printSubscriptionEntry(SubscriptionEntry subEntry) {
    printFeedLinkEntry(subEntry);
  }

  /**
   * Reads a line of text from the standard input.
   * @throws IOException if unable to read a line from the standard input
   * @return a line of text read from the standard input
   */
  private static String readLine() throws IOException {
    return bufferedReader.readLine();
  }

  /**
   * Reads a line of text from the standard input, and returns the parsed
   * integer representation.
   * @throws IOException if unable to read a line from the standard input
   * @return an integer read from the standard input
   */
  private static int readInt() throws IOException {
    String input = readLine();
    return Integer.parseInt(input);
  }

  /**
   * Prints a user's favorites feed.
   *
   * @param service a YouTubeService object.
   * @throws ServiceException
   *                     If the service is unable to handle the request.
   * @throws IOException error sending request or reading the feed.
   */
  private static void getFavoriteVideo(YouTubeService service)
      throws IOException, ServiceException {
	  File f = new File("C:\\Users\\USER\\workspace\\test_gdata\\sample");
	  BufferedReader bf = new BufferedReader(new FileReader(f));
	  r = bf.readLine();
	  while(r!=null)
	  {
	  String[] r1 = r.split(" ");
	  System.out.println("Input= " + r);
	  printVideoFeed(service, USER_FEED_PREFIX + "timtwo12" + FAVORITES_FEED_SUFFIX, 
		        false);
	  keyword.extractWord(getTitle);
	  r = bf.readLine();
	 

	  }
   
      }
  
  
  private static void printVideoEntry1(String prefix, VideoEntry videoEntry,
	      boolean showCommentsAndResponses) throws IOException, ServiceException {
	    System.out.println(prefix);
	    if (videoEntry.getTitle() != null) {
	    	getSearchFeed.add(videoEntry.getTitle().getPlainText());

	      System.out.printf("Title: %s\n", videoEntry.getTitle().getPlainText());
	     
	      
	    }
	    
	    if (videoEntry.getSummary() != null) {
	      System.out.printf("Summary: %s\n",
	          videoEntry.getSummary().getPlainText());
	    }
	    YouTubeMediaGroup mediaGroup = videoEntry.getMediaGroup();
	    if(mediaGroup != null) {
	      MediaKeywords keywords = mediaGroup.getKeywords();
	      System.out.println();

	      System.out.println();
	    }
	    if (showCommentsAndResponses) {
//	      printResponsesFeed(videoEntry);
	      System.out.println("");
//	      printCommentsFeed(videoEntry);
	      System.out.println("");
	      System.out.println("");
	    }
	  }
  

  /**
   * Fetches a feed known to be a VideoFeed, printing each VideoEntry with in
   * a numbered list, optionally prompting the user for the number of a video
   * entry which should have its comments and responses printed.
   *
   * @param service a YouTubeService object
   * @param feedUrl the url of the video feed to print
   * @param showCommentsAndResponses true if the user should be prompted for
   *                                 a video whose comments and responses should
   *                                 printed
   * @throws ServiceException
   *                     If the service is unable to handle the request.
   * @throws IOException error sending request or reading the feed.
   */
  private static void printVideoFeed(YouTubeService service, String feedUrl, 
      boolean showCommentsAndResponses) throws IOException, ServiceException {
    VideoFeed videoFeed = service.getFeed(new URL(feedUrl), VideoFeed.class);
    String title = videoFeed.getTitle().getPlainText();
    if (showCommentsAndResponses) {
      title += " with comments and responses";
    }
    printUnderlined(title);
    List<VideoEntry> videoEntries = videoFeed.getEntries();
    if (videoEntries.size() == 0) {
      System.out.println("This feed contains no entries.");
      return;
    }
    int count = 1;
    for (VideoEntry ve : videoEntries) {
      printVideoEntry("(Video #" + String.valueOf(count) + ")", ve, false);
      count++;
    }

    if (showCommentsAndResponses) {
      System.out.printf(
          "\nWhich video to show comments and responses for? (1-%d): \n", 
          count - 1);
      int whichVideo = readInt();
      printVideoEntry("", videoEntries.get(whichVideo - 1), true);
    }
    System.out.println();
  }

  /**
   * Searches the VIDEOS_FEED for search terms and print each resulting
   * VideoEntry.
   *
   * @param service a YouTubeService object.
   * @throws ServiceException
   *                     If the service is unable to handle the request.
   * @throws IOException error sending request or reading the feed.
   */
  private static void searchWithKeyword(YouTubeService service)
      throws IOException, ServiceException {
    YouTubeQuery query = new YouTubeQuery(new URL(VIDEOS_FEED));
    // order results by the number of views (most viewed first)
    System.out.println("view Count: "+YouTubeQuery.OrderBy.VIEW_COUNT);
    query.setOrderBy(YouTubeQuery.OrderBy.VIEW_COUNT);

    // do not exclude restricted content from the search results 
    // (by default, it is excluded) 
    query.setSafeSearch(YouTubeQuery.SafeSearch.NONE);

    System.out.println("\nEnter search terms: ");
    
    for(String s: keyword.finalWords)
    {
     String searchTerms = s;
    
    query.setFullTextQuery(searchTerms);
    
    printUnderlined("Running Search for '" + searchTerms + "'");
    VideoFeed videoFeed = service.query(query, VideoFeed.class);
    for (VideoEntry ve : videoFeed.getEntries()) {
      printVideoEntry1("", ve, false);
    
    }
    for(String a: getSearchFeed)
    	    System.out.println();
    }
  }

  /**
   * YouTubeReadonlyClient is a sample command line application that
   * demonstrates many features of the YouTube data API using
   * the Java Client library.
   *
   * @param args not used
   */
  public static void main(String[] args) {
    YouTubeService myService = new YouTubeService("gdataSample-YouTube-1");
    try {
    	System.out.println("Getting Favorite feed of User "+r);
		getFavoriteVideo(myService);
		searchWithKeyword(myService);

	} catch (IOException | ServiceException e1) {
		// TODO Auto-generated catch block
		System.out.println("Something went wrong "+e1);
	}

    }
}
  