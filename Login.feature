Feature: Check login  and main page functionality

  @smoke
  Scenario Outline: The user can log in with valid credentials


    Given user has been on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is redirected to main page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @sanity
  Scenario Outline: The user can successfully log out
    Given user has been on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is redirected to main page
    When user clicks on logout button
    Then user is redirected to login page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @smoke
  Scenario Outline:The user cannot log in with invalid credentials
    Given user has been on login page
    When user enters <username> and <password>
    And user clicks on login
    Then error message appears

    Examples:
      | username | password |
      | 1234     | wasd     |

  @sanity
    Scenario Outline:Successfully adding product in shopping basket

    Given user has been on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is redirected to main page
    When user clicks on button add to cart
    Then  user is redirected to shopping basket
    And user can see that product have been added to shopping basket

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

    @smoke
    Scenario Outline: The user cannot log in as a locked_out_user
      Given user has been on login page
      When user enters <username> and <password>
      And user clicks on login
      Then message "Sorry, this user has been locked out."appears

      Examples:
        | username        | password     |
        | locked_out_user | secret_sauce |

    @smoke
    Scenario Outline: Successfully load about page

    Given user has been on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is redirected to main page
    When user clicks on about button
    Then user is redirected to about page


    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
