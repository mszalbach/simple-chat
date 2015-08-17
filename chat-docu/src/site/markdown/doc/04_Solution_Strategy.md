### 4. Solution Strategy
simple-chat is designed as  Web Application Archive which can be deployed to a JavaEE 7 compatible container. It consists of the following blocks:

* Server Implementation to receive and send messages from Users
* Web GUI to allow Users to send interact with the Server
* Database connection to store Messages

The block are connected via Dependency Injection and it should be possible to easily exchange one of the three parts without changing the others.
The comunication between the parts will be done by business driven Objects to improve the understandability instead of boosting the performance.
The correct working of the blocks is ensured by automatic UnitTests. To ensure the working of the complete program automatic Acceptance Tests are used.

#### 4.1 Chatting
A user can send and receive messages via Web GUI. The chat is based on a single chat room and all users can see all messages. There is no login and the server ensures a unique name
for each user. Messages are stored on server site and can be retrived by the client to show as history.