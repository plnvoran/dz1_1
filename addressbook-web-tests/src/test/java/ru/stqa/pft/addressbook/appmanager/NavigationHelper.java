package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Denis on 19.03.2017.
 */
public class NavigationHelper extends HelperBase {


    public NavigationHelper(FirefoxDriver wd) {

        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }


    public void gotoGroupPage() {

        click(By.linkText("groups"));
    }


    public void goToHomePage() {
        click(By.linkText("home"));
    }
}
