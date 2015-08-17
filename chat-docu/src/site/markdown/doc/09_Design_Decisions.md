### 9. Design Decisions

Document all important design decisions and their reasons.

#### 9.1 Database
simple-chat needs a database to store the messages for later use. It could use a relational database with JPA which is the De facto standard for EE projects at the moment or use
a NoSQL database.

##### Mongo DB

* (+) robust database which can remove add or change attributes without problems
* (-) MongoDB does not support transaction
* (-) Only changes applied to the same document are done atomically. A change applied to more than one document will not be applied atomically.

###### Hibernate OGM
* (+) normal JPA function and classes can be used
* (-) Hibernate JPA implementation did not survive certain type changes int to String so a migration would be needed (https://github.com/mongobee/mongobee/wiki/How-to-use-mongobee)
* (-) JPA implementation did not support autoscan of entity classes so needed to be added manually

###### MongoClient
* (+) simple usage and setup
* (+) no additional framework layers
* (-) when this should be replaced its more work as a JPA conform connection method

##### Postgres
* (+) good relational database (ACID)
* (-) over sized
* (-) changes require a migration of the DB and Code changes

##### Decision
Since messages are not important and they will only be written but not updated the complex ACID properties are not needed. Also the developer wants to get some expirience with MongoDB and
this database will be used. As connction method JPA would be great but still has some flaws and a lot of things are hidden in the Hibernate and JPA stack.
By encapsulating the MongoDB connection and its Objects into more business driven classes it should be kinda easy to exchange this in later releases.


