Software Requirements:

Eclipse - Kepler
Java - 1.7
Jar files for communicating with Youtube API : 
gdata-client1.0.jar
gdata-client-core1.0.jar
servlet.jar
gdata-youtube-meta-2.0.jar

The remaining jar files can be found in the lib file of the project code.

Server : Apache Tomcat 7.0

Other files : BagOfWords.txt - list of commonly searched keywords
input.txt - List of usernames
output.txt - list of keywords for each user

Instructions to run the project :

1. Import the project to Eclipse
2. Add the necessary jar files as external library files.
3. Run the file named GetRecommendation.java
4. The output can be seen in Console of the eclipse.

Contribution of each member:

Janani Neelamekam:

She extracted the usernames from the dataset and removed any duplicates that was present in the dataset. Apart from this, she worked on GetRecommendation.java file along with Shravya to extract the favorite feeds of the user that was extracted from the dataset.

Shravya Narayan Sharma:

She worked on the part where the list of keywords was compared with the user's favorite feeds. She and Janani later worked on the GetRecommendation.java to extract the top viewed videos for that keyword in order to suggest them to the user. She also cleaned the initial dataset.

Janani and Shravya equally contributed while working on the report for all the phases

