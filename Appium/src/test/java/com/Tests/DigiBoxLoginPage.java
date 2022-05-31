package com.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DigiBoxLoginPage {

    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability(MobileCapabilityType.APP, "C:/Users/S_Home/Downloads/app-3606-DevTest-debug (1).apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //for any test on browser app the chromedrive set property and browser caps
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
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
    public void upload_single_image() {
        //click on add button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //click on upload file
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/llUploadFileFolders")).click();
        //select image
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String s = driver.findElement(By.xpath("//*[@text='StatueofLiberty.jpg']")).getText();
        System.out.println(s);
        if (s.equalsIgnoreCase("StatueofLiberty.jpg")) {
            driver.findElement(By.xpath("//*[@text='StatueofLiberty.jpg']")).click();
        }

    }

    @Test(dependsOnMethods = "upload_single_image")
    public void upload_multiple_images() {
        //click on add button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //click on upload file
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/llUploadFileFolders")).click();
        //select image1
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String s1 = driver.findElement(By.xpath("//*[@text='StatueofLiberty.jpg']")).getText();
        //select image2
        String s2 = driver.findElement(By.xpath("//*[@text='disneyland.webp']")).getText();
        System.out.println(s1 + s2);
        //select 2 images
        if (s1.equalsIgnoreCase("StatueofLiberty.jpg") && s2.equalsIgnoreCase("disneyland.webp")) {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
            //click on open
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("com.android.documentsui:id/menu_sort")).click();
        }

    }

    @Test(dependsOnMethods = "upload_multiple_images")
    public void upload_multiple_videos() throws InterruptedException {
        //click on add button
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //click on upload file
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/llUploadFileFolders")).click();
        //select video1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String s1 = driver.findElement(By.xpath("//*[@text='video1.mp4']")).getText();
        //select image2
        String s2 = driver.findElement(By.xpath("//*[@text='video2.mp4']")).getText();
        System.out.println("videos" + s1 + s2);
        //select 2 images
        if (s1.equalsIgnoreCase("video1.mp4") && s2.equalsIgnoreCase("video2.mp4")) {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
            //click on open
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.findElement(By.id("com.android.documentsui:id/menu_sort")).click();
        }
    }

    @Test(dependsOnMethods = "upload_multiple_videos")
    public void create_folder() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView")).click();
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtCreateFolderName")).sendKeys("Swati");
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnCreateFolder")).click();
        //go to the search option
        driver.findElement(By.id("com.liqvd.digibox.test:id/search")).click();
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("Swati");
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSearchBtn")).click();
        driver.findElement(By.id("com.liqvd.digibox.test:id/shapeableImageView")).click();
        //click add
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //click upload file
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView")).click();
        //select gif
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.LinearLayout")).click();


    }

    @Test(dependsOnMethods = "create_folder")
    public void upload_file_folder() throws InterruptedException {
        //click on search
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //search "swati" folder
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("Swati");
        //click on search to confirm
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSearchBtn")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        driver.findElement(By.id("com.liqvd.digibox.test:id/tvName")).click();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView")).click();
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).click();
        //
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.FrameLayout/android.widget.ImageView")).click();

    }

    @Test(dependsOnMethods = "upload_file_folder")
    public void multiple_uploads_folder() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //search folder 'Swati'
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("Swati");
        //click on search button
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
        //select image1
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String s1 = driver.findElement(By.xpath("//*[@text='StatueofLiberty.jpg']")).getText();
        //select image2
        String s2 = driver.findElement(By.xpath("//*[@text='disneyland.webp']")).getText();
        System.out.println(s1 + s2);
        //select 2 images
        if (s1.equalsIgnoreCase("StatueofLiberty.jpg") && s2.equalsIgnoreCase("disneyland.webp")) {
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
            //click on open
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.id("com.android.documentsui:id/menu_sort")).click();
        }

    }

    @Test(dependsOnMethods = "multiple_uploads_folder")
    public void apply_filter() {
        //click on search icon in lower ribbon
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")).click();

        //type  folder name swati
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("Swati");
        //click on search icon
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSearchBtn")).click();
        //click on first element in the search results
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/tvName")).click();
        //click on filter icon
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivFilter")).click();
        //select filters (name)
        driver.findElement(By.id("com.liqvd.digibox.test:id/rbAtoZ")).click();
        //Select filters  (selected last 7 days)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/rbDateLast7Days")).click();
        //select filters (size)
        driver.findElement(By.id("com.liqvd.digibox.test:id/rgSizeAll")).click();
        //select filters (file type)
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.CheckBox")).click();

        //Apply filter
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnApply")).click();

    }

    @Test(dependsOnMethods = "apply_filter")
    public void folder_color_rename() {
        //go to search
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //enter the folder name (abc)u want to change the color
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("abc");
        //click on search
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSearchBtn")).click();
        //go to 3 dots of folder u want to change color
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivMenu")).click();
        //select change color
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/itemChangeFolderColor")).click();
        //choose color
        driver.findElement(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[8]/android.view.View")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button")).click();

        //FOR RENAMING FOLDER
        //go to 3 dots again of folder u want to rename
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivMenu")).click();
        //go to rename option
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/itemRenameFolder")).click();
        //clear the name of folder
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtReNameFolder")).clear();
        //Rename the folder with new name
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtReNameFolder")).sendKeys("Testing");
        //click on rename folder
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnReNameFolder")).click();
    }

    @Test(dependsOnMethods = "folder_color_rename")
    public void delete_folder() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //go to back
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")).click();
        //go to homepage
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //go to search option
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")).click();

        //type  folder name swati
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("Swati");
        //click on search icon
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSearchBtn")).click();
        //click on three dots
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivMenu")).click();
        //click on delete
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivDelete")).click();
        //click on delete (confirm)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/tvContinue")).click();

    }

    @Test(dependsOnMethods = "delete_folder")
    public void create_subfolder() {
        //go to back
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")).click();

        //go to search option
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //click search button
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtSearch")).sendKeys("Testing");
        //click search
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSearchBtn")).click();
        //click on folder icon
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView[1]")).click();
        //go to add button
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //go to create folder (subfolder)
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView")).click();
        //name the folder
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtCreateFolderName")).sendKeys("subfolder");
        //click create folder
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnCreateFolder")).click();

    }

    @Test(dependsOnMethods = "create_subfolder")
    public void selectall_checkbox() {
        //go to back
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/imgBack")).click();
        //go back 1 more time
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")).click();
        //select all (checkbox)
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSelectAll")).click();
        //deselect all
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSelectAll")).click();


    }

    @Test(dependsOnMethods = "selectall_checkbox")
    public void profile_picture() {
        //go to profile icon
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivProfile")).click();
        //go to profile picture
        driver.findElement(By.id("com.liqvd.digibox.test:id/imgProfileImage")).click();
        //remove profile picture
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivRemoveIcon")).click();
        //confirm yes
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnYes")).click();

        //go to back
        driver.findElement(By.id("com.liqvd.digibox.test:id/backFromUserProfile")).click();
        //to upload new, click on profile picture again
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivProfile")).click();
        //go to profile image
        driver.findElement(By.id("com.liqvd.digibox.test:id/imgProfileImage")).click();
        //go to gallery
        driver.findElement(By.id("com.liqvd.digibox.test:id/llGallery")).click();
        //select image
        driver.findElement(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.ImageView[1]")).click();
        //confirm and click on select
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ImageView")).click();
        //go to back
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.id("com.liqvd.digibox.test:id/ivBack")).click();

//        //for camera: click on profile pic
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.id("com.liqvd.digibox.test:id/imgProfileImage")).click();
//        //go to camera
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.findElement(By.id("com.liqvd.digibox.test:id/llCamera")).click();
//        //click on shutter button
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.findElement(By.id("com.android.camera2:id/shutter_button")).click();
//        //click on tick to confirm
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElement(By.id("com.android.camera2:id/done_button")).click();
//        //click on rotate
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ImageView")).click();
//        //click on select
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.ImageView")).click();

        //go to back
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivBack")).click();
        //go more back
        driver.findElement(By.id("com.liqvd.digibox.test:id/backFromUserProfile")).click();


    }

    @Test(dependsOnMethods = "profile_picture")
    public void delete_file() {
        //click kebab icon
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivTypeView")).click();
        //select "large file" to open
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView[1]")).click();
        //first upload : click add
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.FrameLayout[@content-desc=\"Add\"]/android.widget.FrameLayout/android.widget.ImageView")).click();
        //select upload file
        driver.findElement(By.id("com.liqvd.digibox.test:id/llUploadFileFolders")).click();
        //select ststue of liberty image
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@text='StatueofLiberty.jpg']")).click();
        //select 3 dots of file to delete
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"kabab menu\"])[1]")).click();
        //click on delete option
        driver.findElement(By.id("com.liqvd.digibox.test:id/itemDeleteFile")).click();
        //click on delete button to continue
        driver.findElement(By.id("com.liqvd.digibox.test:id/tvContinue")).click();
        //go to back
        driver.findElement(By.id("com.liqvd.digibox.test:id/imgBack")).click();

//        //From Preview page: click on image to open
//        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView[1]")).click();
//        //click delete on top
//        driver.findElement(By.id("com.liqvd.digibox.test:id/cardDeleteFile")).click();
//        //click delete to continue
//        driver.findElement(By.id("com.liqvd.digibox.test:id/tvContinue")).click();

        //delete from Recycle bin
        // click on left top icon to get recycle option
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")).click();
        //click on recycle bin
        driver.findElement(By.id("com.liqvd.digibox.test:id/llRecycleBin")).click();
        //click on select all
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivSelectAll")).click();
        //click on delete
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivDelete")).click();
        //click delete to continue
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/tvContinue")).click();
//        //click on home button
//        driver.findElement(By.id("com.liqvd.digibox.test:id/home")).click();
    }

    @Test(dependsOnMethods = "delete_file")
    public void restore_file() {
        //click on 3 dots of file u want to restore
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"kabab menu\"])[1]")).click();
        //click on restore
        driver.findElement(By.id("com.liqvd.digibox.test:id/itemRestore")).click();

    }

    @Test(dependsOnMethods = "restore_file")
    public void add_to_favorite() {
        //go to home page
        driver.findElement(By.id("com.liqvd.digibox.test:id/navigation_bar_item_large_label_view")).click();
        //click on the star button for folder
        driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"star\"])[1]")).click();
        //click on the star for file
        driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"star\"])[3]")).click();

    }

    //    String fileToCheck = "C:/Users/Bla/Desktop/Test";
//
//    File f = new File(fileToCheck);
//        if(f.exists())
//                {
//                System.out.println("File or folder : " + fileToCheck + " already exists");
//                }
//                else
//                {
//                System.out.println("File or folder : " + fileToCheck + " does not exists");
//                }
    @Test(dependsOnMethods = "restore_file")
    public void change_password() {
        //go to profile
        driver.findElement(By.id("com.liqvd.digibox.test:id/ivProfile")).click();
        //click logout
        driver.findElement(By.id("com.liqvd.digibox.test:id/textView18")).click();
        //click on yes
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/tvYes")).click();
        //enter credentials with another password
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtDigiSpaceName")).sendKeys("Freeuse");
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtEmail")).sendKeys("freeuser251093@gmail.com");
        //click on show password icon
        driver.findElement(By.id("com.liqvd.digibox.test:id/text_input_end_icon")).click();
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtPassword")).sendKeys("Swati@123");
        //clear it
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtPassword")).clear();
        //put same password again
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtPassword")).sendKeys("Gaurav@123");
        //click login
        driver.findElement(By.id("com.liqvd.digibox.test:id/btnSignIn")).click();

    }

    @Test(dependsOnMethods = "change_password")
    public void post_comments() {
        //go to "large file" folder
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/androidx.cardview.widget.CardView[1]")).click();
        //go to image
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView")).click();
        //go to comments
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[5]/android.widget.TextView")).click();
        //write comment in comment box
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtWriteText")).sendKeys("Beautiful");
        //post it
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView")).click();

        //attach file with comment:
        //driver.findElement(By.id("com.liqvd.digibox.test:id/rlComments")).click();
        //write comment
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtWriteText")).sendKeys("WOW");
        //click on attach file
        driver.findElement(By.id("com.liqvd.digibox.test:id/imgAttach")).click();
        //choose gif file
        driver.findElement(By.id("com.android.documentsui:id/icon_mime")).click();
        //click open on top
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"More options\"]")).click();
        //click on post
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/cardSend")).click();


        //Attach Large file only
        //click on comment
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.id("com.liqvd.digibox.test:id/edtWriteText")).click();
        //Write comment in comment box
        driver.findElement(By.id("com.liqvd.digibox.test:id/edtWriteText")).sendKeys("A");
        //click on attach file icon
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/imgAttach")).click();
        //choose large video file
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
        //click open on top
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"More options\"]")).click();
        //click on post
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.liqvd.digibox.test:id/cardSend")).click();
        //go back
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")).click();


    }
        @Test(dependsOnMethods = "post_comments")
        public void file_preview(){
            //go back
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")).click();
            //go more back
            driver.findElement(By.id("com.liqvd.digibox.test:id/imgBack")).click();
            //click on video 2
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/androidx.cardview.widget.CardView[1]")).click();
            //play video
            driver.findElement(By.id("com.liqvd.digibox.test:id/imgPlayVideo")).click();


    }
}
