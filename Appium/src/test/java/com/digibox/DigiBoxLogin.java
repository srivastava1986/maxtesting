package com.digibox;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DigiBoxLogin {

    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability(MobileCapabilityType.APP,"C:/Users/S_Home/Downloads/app-3606-DevTest-debug (1).apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //for any test on browser app the chromedrive sex property and browser caps
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
    }

    @Test
    public void open_the_App() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnSkipIntroSlideOne")).click();

    }

    @Test(dependsOnMethods = "open_the_App")
    public void enter_login_credentials() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtDigiSpaceName")).sendKeys("Freeuse");
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtEmail")).sendKeys("freeuser251093@gmail.com");
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtPassword")).sendKeys("Gaurav@123");
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnSignIn")).click();


    }
    @Test(dependsOnMethods = "enter_login_credentials")
    public void create_folder() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView")).click();
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtCreateFolderName")).sendKeys("Swati");
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnCreateFolder")).click();
    }


}
