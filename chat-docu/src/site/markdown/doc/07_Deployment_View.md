### 7. Deployment View
simple-chat is designed to work in Docker container and it also includes the Dockerfiles needed to setup. However since this is a war file it
can also be used directly in an JavaEE7 compatible Application Server.

#### 7.1 Docker Deployment
simple-chat consists of two Docker containers. One which consists of the Wildfly server and the deployed war file and one with the MongoDB.
The containers are linked via Docker mechanism and expose there ports to the OS to allow access from the outer world.

|Port   | Description                                                                             |
|------:|-----------------------------------------------------------------------------------------|
| 8080  | Http Port of Wildfly to access the website                                              |
| 9990  | Wildfly admin port to manage the running instance                                       |
| 27017 | MongoDB Port to access the database. This is just for testing and will be removed later |

![Docker Deployment](../images/uml/dockerDeployment.png "Docker Deployment")

#### 7.2 Application Server Deployment
TBA