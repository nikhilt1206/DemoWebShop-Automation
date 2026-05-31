package com.nikhil.automation.tests;

import com.nikhil.automation.base.BaseTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoads(){
        System.out.println(driver.getTitle());
    }

}
