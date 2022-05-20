package org.max.qa.TestCases;

import org.testng.annotations.*;

public class LoginPage {

    @Test
    public void test() {
        System.out.println("I am Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("I am BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("I am AfterSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("I am BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("I am AfterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("I am BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("I am AferClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I am AfterMethod");
    }
}
