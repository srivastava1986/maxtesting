package Keywords;

import com.PageObjects.GetPage;
import io.appium.java_client.android.AndroidDriver;

public class LoginPageActions extends GetPage {

    public LoginPageActions(AndroidDriver driver){
        super(driver,"LoginPageTest");

    }

    public void skippresentation(){
        element("skipbutton").click();
    }

    public void enterLoginCredentials(){
        element("digispace").sendKeys("Freeuse");
        element("email").sendKeys("freeuser251093@gmail.com");
        element("password").sendKeys("Gaurav@123");
        element("loginbutton").click();
    }



}
