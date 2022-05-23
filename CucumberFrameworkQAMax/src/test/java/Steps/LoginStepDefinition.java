package Steps;

import PageObjectsPackage.LoginPageObject;
import Utilities.ymlReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginStepDefinition extends LoginPageObject {

    ymlReader reader=new ymlReader();

    LoginPageObject loginpage=new LoginPageObject();


    @Given("Open Browser and Launch URL {string}")
    public void open_browser_and_launch_url(String string) {
        Assert.assertTrue(loginpage.openBrowserAndUrl(string));

        //loginpage.openBrowserAndUrl(string);

    }

    @When("User enters Username")
    public void user_enters_username_as_and_password_as() throws FileNotFoundException, InterruptedException {
        String username=reader.yamlReaderMethod("username");
        String password=reader.yamlReaderMethod("password");
        //System.out.println(password);
        Assert.assertTrue(loginpage.enterUserdetails(username,password));
    }

    @When("Click on Login button")
    public void click_on_login_button(){

    }

    @Then("Display the Dashboard")
    public void display_the_dashboard() throws InterruptedException {
       String actualAnswer = loginpage.displayDashboard();
        Assert.assertEquals("WELCOME TO MAX", actualAnswer);
    }

}
