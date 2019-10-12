Problem - To develop a Token management system
The Use case is to design Java based application for an Application submission Center. Applicant must visit one of the 1st set of counters for Document verification, where the token Number will be assigned, and same token number will be used for further process.

Please consider the following requirements:

Multiple token generation counter (1st set of counters).
Token will be assigned to multiple service counter (2nd set of counters)
Token can be categorized to NORMAL, PREMIUM
Dedicated counters to serve PREMIUM Token.
If someone can come up with of event sinks using Kafka, that is definitely a plus.
Note: Concurrency, transaction, Queue are the gist of the problem solution.

The application is developed using Springboot Moicroservices and Kafka as a message queue. Thymeleaf is used for a basic UI.

Prerequisite:
1: Java 8
2: A running kafka at localhost:9092 (If different address, Please update in application.properties)
3: A topic named registration should be created before the application is tested.
4: Build the application using mvn clean package from the root directory
5: Run the application using command java -jar target/<generated_jar> for example If you use default then java -jar target/counterapp-0.0.1-SNAPSHOT.jar
6: The application starts and pushes some messages in queue (USed for testing) you can comment in CounterAppApplication.java
7: Access the server using http://localhost:8080
9: Click on the button for New Registration
10: Enter the name, Registration counter and a flag for priority or not
11:On clicking submit you can see the message had been pushed to Kafka and consumed and directed to appropriate counter for processing
12: The processing server is implemented using ExecutorService (RegistrationProcessor). 
13: Two ExecutorService (1 for normal and 1 for priority) has been created.
14: For testing NormalProcessing counter has a wait of 3 seconds and priority processing counter has a wait time of 1 seconds.


Pending Tasks:
1: Writing testcases (No time for that at this moment)
2: Using Maven shade plugin for creating a standalone fat jar which can be deployed independantly (You can do this easily)

