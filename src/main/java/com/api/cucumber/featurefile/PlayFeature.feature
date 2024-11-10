Feature: Gibberish Streaming service interaction

  Background: Common step
    Given The user is logged into the streaming service
    And the user is on the homepage

  Scenario Outline: User wants to watch a live stream
    When the user selects the live stream "<streamName>"
    And the user clicks on the play button
    Then the stream "<streamName>" should start playing
    And the video player should display the live stream

    Examples:
      | streamName     |
      | Live Stream 1  |
      | Live Stream 2  |

  Scenario Outline: User wants to watch a replay of a previous stream
    When the user selects the replay of a previous stream "<replayName>"
    And the user clicks on the play button
    Then the replay "<replayName>" should start playing
    And the video player should display the replay

    Examples:
      | replayName     |
      | Replay 1       |
      | Replay 2       |

  Scenario Outline: User tries to watch a replay that is limited by a paywall
    When the user selects the replay of a previous stream "<replayName>" with a paywall
    And the user clicks on the play button
    Then the user should be prompted to pay to access the replay "<replayName>"

    Examples:
      | replayName       |
      | Premium Replay 1 |
      | Premium Replay 2 |

  Scenario Outline: User tries to watch a replay that is unavailable
    When the user selects the replay of a previous stream "<replayName>" that is unavailable
    And the user clicks on the play button
    Then the user should be informed that the replay "<replayName>" is unavailable

    Examples:
      | replayName           |
      | Unavailable Replay 1 |
      | Unavailable Replay 2 |
