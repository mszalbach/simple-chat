### 8. Concepts
The following chapters cover examples of frequent cross-cutting concerns (a.k.a. aspects in some programming languages)
Fill in these chapters if there is NO building block that covers this aspect. If some of the concepts are not relevant for your project mention this fact instead of removing the section.

Some concept cannot be “factored” into a separate building block of the architecture (e.g. the topic “security”).
This section of the template is the location where you can describe all decision for such a cross cutting topic in one central place.
Nevertheless, you have to make sure that all your building blocks conform to such decisions.

#### 8.1 Domain Models

#### 8.2 Recurring or Generic Structures and Patterns

#### 8.3 Persistence

#### 8.4 User Interface

#### 8.5 Ergonomics

#### 8.6 Flow of Control

#### 8.7 Transaction Processing

#### 8.8 Session Handling

#### 8.9 Security

#### 8.10 Safety

#### 8.11 Communication and Integration

#### 8.12 Distribution

#### 8.13 Plausibility and Validity Checks

#### 8.14 Exception/Error Handling

#### 8.15 System Management and Administration

#### 8.16 Logging, Tracing

#### 8.17 Business Rules

#### 8.18 Configurability

#### 8.19 Parallelization and Threading

#### 8.20 Internationalization
simple-chat is completely written in English and will not support Internationalization. However the user can chat in every language he likes.

#### 8.21 Migration

#### 8.22 Testability
UnitTests are done via JUnit 4 and Mockito and are stored in the modules in *src/test/java*. A UnitTest is in the same package as the Class he tests. For testing purpose it is OK
to increase the visibility of a Class or Method to protected. A Test class is named after the Class it is testing and ends with *Test*.

To test the complete System there is the chat-acceptancetests module which uses Cucumber and Selenium to test the software like a User via the Web GUI. To be able to automate this tests
Docker container are used which did not expose there ports and so did not colide with program's running on the system.
All BDD tests can be executed locally and will then run against localhost:8080. All BDD Tests file have the suffix *.feature*.

#### 8.23 Scaling, Clustering

#### 8.24 High Availability

#### 8.25 Code Generation

#### 8.26 Build Management
As build system Maven 3 is used and the source code is stored in [github](${project.parent.scm.url}). To build and run the acceptance test locally just run

```
mvn clean verify
```
Ensure you have docker installed and listening on ${docker.host}.



