The Pub Sub System has been implemented in Java.
It covers the basic and advanced pub/sub system.
The following are the classes associated with them.

SimpleClient.java

This is where the Pub-Sub System Initiates.
It basically displays a menu for the basic set of operations.
Each number signifies a specific operation
1 to publish
2 to subscribe
3 to advertise
4 to subscribe to a content
5 to unsubscribe

Publisher.java

This class is meant to invoke the publisher thread.
It receives the input from SimpleClient.java.
Once the control is transferred to the Publisher it executes the block of code depending on the option
That is decided by the string parameter sent by SimpleClient.
Since the publisher class implements the run method the advertise and event publishing logic is present here.
I have given options for taking input from standard input and also a constructor with hard coded values.
The one with receiving input from command line worked fine until a couple of hours so had to keep the option of hard coded values.

Subscriber.java

This class is meant to invoke the publisher thread.
It receives the input from SimpleClient.java.
Once the control is transferred to the Subscriber it executes the block of code depending on the option
That is decided by the string parameter sent by SimpleClient.
Since the subscriberclass implements the run method the subscription to a content and subscription to a topic's logic is present here.
I have given options for taking input from standard input and also a constructor with hard coded values.
The one with receiving input from command line worked fine until a couple of hours so had to keep the option of hard coded values.

EventManager.java

This is the Server/EventManager class.
This acts as a multi-threaded server which accepts multiple client connections.
It gets the object sent by Publisher/Subscriber
It maintains a repository for Events,Topics,Subscribers.
It also notifies the subscribers of Events or Topics Published.
It maintains a data structure for storing the above information.
The logic is documented in the source code.

Event.java

This is the class which consists of all Event attributes

Topic.java

This is the class which consists of all Topic attributes


