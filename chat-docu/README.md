#How to build the documentation

##Requierements
Graphviz must be installed and the dot command must be in the path.
In the settings.xml the github credentials must be specified:

```
<server>
     <id>github</id>
    <username>USER</username>
    <password>PASSWORD</password>
</server>
```

See https://maven.apache.org/guides/mini/guide-encryption.html how to enrypt your password in the settings.xml.

##Upload new Documentation

```
cd chat-docu
mvn clean site
```

Visit http://mszalbach.github.io/simple-chat

