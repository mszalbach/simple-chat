### 7. Deployment View
simple-chat is designed to work in Docker container and it also includes the Dockerfiles needed to setup. However since this is a war file it
can also be used directly in an JavaEE7 compatible Application Server.

#### 7.1 Docker Deployment
simple-chat consists of two Docker containers. One which consists of the Wildfly server and the deployed war file and one with the MongoDB.
The containers are linked via Docker mechanism and expose there ports to the OS to allow access from the outer world.

|Port   | Description                                                                             |
|------:|-----------------------------------------------------------------------------------------|
| 8080  | Http Port of Wildfly to access the website                                              |

![Docker Deployment](../images/uml/dockerDeployment.png "Docker Deployment")

The module docker-installer builds an zip file containing all files to start the chat with docker-compose.

```
unzip docker-installer-${project.version}-distribution.zip
cd simple-chat-${project.versionId}
docker-compose up
```

#### 7.2 Application Server Deployment
simple-chat consists of a simple war file but requieres some other services currently implemented with Docker and linking.
There is no easy mechanism to configure this requirements. And so this is currently not supported.