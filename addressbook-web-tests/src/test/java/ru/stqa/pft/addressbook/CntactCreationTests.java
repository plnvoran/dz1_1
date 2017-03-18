package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class CntactCreationTests extends TestBase {



    @Test
    public void testCntactCreation() {

        initAddNew();
        fillContactForm(new CantactData("First name", "Last name", "Moscow, Arbat 5", "+ 74991234567", "12345@mail.ru"));
        submitNewConract();
        returnToHomePage();
    }


}
