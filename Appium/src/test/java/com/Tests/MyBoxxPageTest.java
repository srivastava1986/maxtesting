package com.Tests;

import com.TestSessionInitiator.TestSessionInitiator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyBoxxPageTest {
    TestSessionInitiator test;

    @BeforeClass
    public void startsession(){
        test=new TestSessionInitiator();
    }

    @Test
    public void step01_LaunchApplication_and_skip_presentation(){
        test.loginPage.skippresentation();
    }

    @Test
    public void step02_enter_your_credentials(){
        test.loginPage.enterLoginCredentials();
    }

    @Test
    public void step03_Upload_Single_image_file(){
        test.myboxpageactions.upload_single_image_file();
    }

    @Test
    public void step04_check_addbutton_is_enabled_in_myboxxPage(){
        //test.myboxpageactions.check_add_button_isclickable();
        Assert.assertTrue(test.myboxpageactions.check_add_button_isclickable());
    }

    @Test
    public void step05_check_addbutton_isdisabled_when_notin_myboxxPage(){
        test.myboxpageactions.kebab_icon();
        test.myboxpageactions.recycle();
        Assert.assertFalse(test.myboxpageactions.check_add_button_isclickable());
    }

}
