package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Denis on 19.03.2017.
 */
public class NavigationHelper {


    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {

        this.wd = wd;
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }


    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }


}
