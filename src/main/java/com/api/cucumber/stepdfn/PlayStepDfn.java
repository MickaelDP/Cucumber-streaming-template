package com.api.cucumber.stepdfn;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

// Les étapes peuvents être généré a partir d'outil comme dirty gherkin ou à l'aide d'ia comme chat gpt

public class PlayStepDfn {
    private boolean isLoggedIn;
    private boolean isOnHomePage;
    private boolean isStreamSelected;
    private boolean isReplaySelected;
    private boolean isPlaying;
    private boolean isPaywallPresent;
    private boolean isReplayAvailable;
    private String streamStatus;
    private String currentStream;
    private String currentReplay;

    @Given("The user is logged into the streaming service")
    public void the_user_is_logged_into_the_streaming_service() {
        isLoggedIn = true;
        System.out.println("User is logged into the streaming service.");
    }

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        if (isLoggedIn) {
            isOnHomePage = true;
            System.out.println("User is on the homepage.");
        } else {
            isOnHomePage = false;
            System.out.println("User is not logged in. Cannot go to homepage.");
        }
    }

    @When("the user selects the live stream {string}")
    public void the_user_selects_the_live_stream(String streamName) {
        if (isOnHomePage) {
            isStreamSelected = true;
            currentStream = streamName;  // Stocker le nom du stream sélectionné
            System.out.println("User has selected the live stream: " + streamName);
        } else {
            isStreamSelected = false;
            System.out.println("User is not on the homepage. Cannot select a stream.");
        }
    }

    @When("the user selects the replay of a previous stream {string}")
    public void the_user_selects_the_replay_of_a_previous_stream(String replayName) {
        if (isOnHomePage) {
            isReplaySelected = true;
            isReplayAvailable = true;
            currentReplay = replayName;
            System.out.println("User has selected the replay of a previous stream: " + currentReplay);
        } else {
            isReplaySelected = false;
            System.out.println("User is not on the homepage. Cannot select a replay.");
        }
    }

    @When("the user selects the replay of a previous stream {string} with a paywall")
    public void the_user_selects_the_replay_of_a_previous_stream_with_a_paywall(String replayName) {
        if (isOnHomePage) {
            isReplaySelected = true;
            isPaywallPresent = true;
            isReplayAvailable = true;
            currentReplay = replayName;
            System.out.println("User has selected the replay of a previous stream with a paywall: " + currentReplay);
        } else {
            isReplaySelected = false;
            System.out.println("User is not on the homepage. Cannot select a replay.");
        }
    }

    @When("the user selects the replay of a previous stream {string} that is unavailable")
    public void the_user_selects_the_replay_of_a_previous_stream_that_is_unavailable(String replayName) {
        if (isOnHomePage) {
            isReplaySelected = true;
            isReplayAvailable = false;
            streamStatus = "unavailable"; // Ajouter cette ligne pour définir l'état
            currentReplay = replayName;
            System.out.println("User has selected the replay of a previous stream that is unavailable: " +  currentReplay);
        } else {
            isReplaySelected = false;
            System.out.println("User is not on the homepage. Cannot select a replay.");
        }
    }

    @And("the user clicks on the play button")
    public void the_user_clicks_on_the_play_button() {
        // Vérifie si un flux ou une rediffusion est sélectionné
        if (isStreamSelected || isReplaySelected) {
            if (isPaywallPresent) {
                streamStatus = "paywall";
                System.out.println("The selected content is behind a paywall.");
            } else if (!isReplayAvailable && isReplaySelected) {
                streamStatus = "unavailable"; // Assurez-vous que l'état est bien défini
                System.out.println("The selected replay is unavailable.");
            } else {
                streamStatus = "playing";
                System.out.println("The selected content is now playing.");
            }
        } else {
            isPlaying = false;
            streamStatus = "not_selected";
            System.out.println("No stream or replay selected. Cannot play.");
        }
    }

    @Then("the stream {string} should start playing")
    public void the_stream_should_start_playing(String streamName) {
        if (streamName.equals(currentStream) && "playing".equals(streamStatus)) {
            System.out.println("Stream " + streamName + " is playing.");
        } else {
            System.out.println("Stream " + streamName + " is not playing.");
        }
        assert streamName.equals(currentStream) && "playing".equals(streamStatus) : "The stream " + streamName + " did not start playing.";
    }

    @Then("the replay {string} should start playing")
    public void the_replay_should_start_playing(String replayName) {
        if (replayName.equals(currentReplay) && "playing".equals(streamStatus)) {
            System.out.println("Replay " + replayName + " is playing.");
        } else {
            System.out.println("Replay " + replayName + " is not playing.");
        }
        assert replayName.equals(currentReplay) && "playing".equals(streamStatus) :
                "The replay '" + replayName + "' did not start playing. Expected status: 'playing', but was: '" + streamStatus + "'";
    }

    @Then("the video player should display the live stream")
    public void the_video_player_should_display_the_live_stream() {
        if ("playing".equals(streamStatus) && currentStream != null) {
            System.out.println("Video player is displaying the live stream.");
        } else {
            System.out.println("Video player is not displaying the stream.");
        }
        assert "playing".equals(streamStatus) && currentStream != null : "The video player is not displaying the stream.";
    }

    @Then("the video player should display the replay")
    public void the_video_player_should_display_the_replay() {
        if ("playing".equals(streamStatus)) {
            System.out.println("Video player is displaying the replay.");
        } else {
            System.out.println("Video player is not displaying the replay.");
        }
        assert "playing".equals(streamStatus) : "The video player is not displaying the replay.";
    }

    @Then("the user should be prompted to pay to access the replay {string}")
    public void the_user_should_be_prompted_to_pay_to_access_the_replay(String replayName) {
        if ("paywall".equals(streamStatus)) {
            System.out.println("User is prompted to pay to access the replay: " + replayName);
        } else {
            System.out.println("User is not prompted to pay.");
        }
        assert "paywall".equals(streamStatus) : "The user was not prompted to pay to access the replay " + replayName;
    }

    @Then("the user should be informed that the replay {string} is unavailable")
    public void the_user_should_be_informed_that_the_replay_is_unavailable(String replayName) {
        if (replayName.equals(currentReplay) && "unavailable".equals(streamStatus)) {
            System.out.println("User is informed that the replay " + replayName + " is unavailable.");
        } else {
            System.out.println("User is not informed of unavailability.");
        }
        assert replayName.equals(currentReplay) && "unavailable".equals(streamStatus) :
                "The user was not informed that the replay " + replayName + " is unavailable.";
    }
}
