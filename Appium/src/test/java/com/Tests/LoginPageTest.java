package com.Tests;

import com.TestSessionInitiator.TestSessionInitiator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest {
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


}
