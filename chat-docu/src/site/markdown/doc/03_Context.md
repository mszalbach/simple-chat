### 3. Context

#### 3.1 Business Context
This shows the interfaces to neighbours. simple-chat did not use external services from third parties. So the interfaces are the webbrowser used
to access the website and the database connection.

![Business Context](../images/uml/businessContext.png "Business Context")

##### User
Will use the chat system and wants to chat with other Users.
##### Browser
A HTML5 compatible Browser which will render the website hosted by simple-chat.
##### messages
A storage for the chat messages so Users can view a history of old messages or even receive offline messages.

#### 3.2 Technical Context

![Technical Context](../images/uml/technicalContext.png "Technical Context")

#### Browser
simple-chat and the browser will communicate over http protocol and will exchange messages in plain text and JSON format.

#### Database
The database will be accessed via JPA to be easily replace the database and to avoid writing and own database layer.