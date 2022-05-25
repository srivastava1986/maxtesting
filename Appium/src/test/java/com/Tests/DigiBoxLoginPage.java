package com.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DigiBoxLoginPage {

    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability(MobileCapabilityType.APP,"C:/Users/S_Home/Downloads/app-3606-DevTest-debug (1).apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //for any test on browser app the chromedrive set property and browser caps
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
    }

    @Test
    public void open_the_App() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnSkipIntroSlideOne")).click();

    }

    @Test(dependsOnMethods = "open_the_App")
    public void enter_login_credentials() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtDigiSpaceName")).sendKeys("Freeuse");
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtEmail")).sendKeys("freeuser251093@gmail.com");
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtPassword")).sendKeys("Gaurav@123");
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnSignIn")).click();


    }
    @Test(dependsOnMethods = "enter_login_credentials")
    public void create_folder() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView")).click();
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtCreateFolderName")).sendKeys("Swati");
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnCreateFolder")).click();
    }

    @Test(dependsOnMethods = "create_folder")
    public void upload_file() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("Swati");
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSearchBtn")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/tvName")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.FrameLayout/android.widget.ImageView")).click();

    }

    @Test(dependsOnMethods = "upload_file")
    public void multiple_uploads(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("Swati");
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSearchBtn")).click();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/tvName")).click();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView")).click();

        //
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).click();
        //

        //click on first image icon
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click on three dots
        driver.findElement(By.xpath("\t\n" +
                "(//android.widget.ImageButton[@content-desc=\"More options\"])[1]")).click();
        //click on select all
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("android:id/title")).click();
        //click on open
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.android.documentsui:id/menu_sort")).click();
        //wait for the all the images to load

    }

    @Test(dependsOnMethods = "multiple_uploads")
    public void apply_filter(){
        //click on search icon in lower ribbon
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")).click();

        //type  folder name swati
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("Swati");
        //click on search icon
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSearchBtn")).click();
        //click on first element in the search results
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/tvName")).click();
        //click on filter icon
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivFilter")).click();
        //Select filters  (selected last 7 days)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/rbDateLast7Days")).click();
        //Apply filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnApply")).click();
        //


    }


}
