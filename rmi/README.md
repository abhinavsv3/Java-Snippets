Step to run the RMI Program : 
 
Step 1 : Genterate class files
 javac TestInterface.java
 javac TestImpl.java
 javac TestAddServer.java
 javac TestClient.java

Step 2 : Generate stub files
 rmic TestImpl

Step 3 : rmi registry
  In Linux :
	rmiregistry &
  In Windows :
	start rmiregistry 
Step 4 : deploy
  run the server and client programs seperately in 2 different terminals
    
  Terminal 1 : 
     java TestAddServer
  Terminal 2 :
     java TestClient

Expected Solution : 
  Computer value will be returned to the Client.

