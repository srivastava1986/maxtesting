package PageObjectsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageObject {
    String key = "webdriver.chrome.driver";
    String value = "C:/Users/S_Home/workspace/selenium/driver/chromedriver/chromedriver.exe";
    WebDriver driver;

    public LoginPageObject(){

    }

    public void setUp() {

        System.setProperty(key,value);
        driver = new ChromeDriver();
    }

    public Boolean openBrowserAndUrl(String url){
        setUp();
        driver.get(url);
        return true;

    }

    public Boolean enterUserdetails(String username, String password) throws InterruptedException {
        driver.findElement(By.id("myusername")).sendKeys(username);
        driver.findElement(By.id("mypassword")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@type='checkbox' and @id='agree_tc_user']")).click();
        return true;
    }

    public String displayDashboard() {
        String actualAnswer=driver.findElement(By.xpath("//*[@data-nav='WELCOME TO MAX' and @class='nav-link dropdown-toggle nav-view reloader-alert']")).getText();
        return actualAnswer;
    }
}
