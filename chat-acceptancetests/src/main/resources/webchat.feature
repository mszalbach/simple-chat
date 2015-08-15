@web
Feature: As a website user I want to chat with others

  Scenario: Send message to myself
    Given I visit the chat website
    When I change my nickname to "client1"
    When I send message "Hello"
    Then webchat contains message "client1 - Hello"

  Scenario: Send message to myself
    Given I visit the chat website
    When I change my nickname to "client2"
    When I send message "Hello"
    Then webchat contains message "client2 - Hello"