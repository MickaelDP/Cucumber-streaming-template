package com.api.cucumber.stepdfn;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import java.util.Map;

public class LoginStepDfn {
    private String currentUsername;
    private String currentPassword;
    private boolean isLoggedIn;

    @Given("The user is at the login page")
    public void the_user_is_at_the_login_page() {
        System.out.println("User is at the login page.");
        // Vous pouvez ajouter une logique supplémentaire ici si nécessaire
    }

    @When("the user with the following username and password")
    public void the_user_with_the_following_username_and_password(DataTable credentials) {
        // Parcourt le tableau des identifiants et des mots de passe
        for (Map<String, String> row : credentials.asMaps(String.class, String.class)) {
            currentUsername = row.get("UserName1");
            currentPassword = row.get("Password1");

            System.out.println("Attempting login with username: " + currentUsername + " and password: " + currentPassword);

            // Simulez le processus de login ici, par exemple :
            if (currentUsername.equals("correctUsername") && currentPassword.equals("correctPassword")) {
                isLoggedIn = true;
                System.out.println("User " + currentUsername + " successfully logged in.");
            } else {
                isLoggedIn = false;
                System.out.println("Login failed for user " + currentUsername);
            }
        }
    }

    @Then("User should be able to login with correct username and password")
    public void user_should_be_able_to_login_with_correct_username_and_password() {
        if (isLoggedIn) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login unsuccessful.");
        }

        // Assertion to verify login success
        assert isLoggedIn : "The user was not able to login with the correct username and password.";
    }
}
