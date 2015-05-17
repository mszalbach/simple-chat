Feature: As developer I want to receive and send messages via websocket.

  Scenario: Send message to other users
    Given a websocket connection client1
    And a websocket connection client2
    When client1 sends message "Hello"
    Then client2 received message "Hello"
    
  Scenario: websocket client goes offline
    Given a websocket connection client1
    And a websocket connection client2
    When client2 goes offline
    And client1 sends message "Hello"
    Then client2 did not receive message "Hello"