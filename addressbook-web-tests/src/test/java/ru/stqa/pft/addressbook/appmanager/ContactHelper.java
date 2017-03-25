package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.CantactData;

import java.util.concurrent.TimeUnit;

/**
 * Created by Denis on 19.03.2017.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void submitNewConract() {

        click(By.xpath("//div[@id='content']/form/input[21]"));

    }

    public void fillContactForm(CantactData cantactData) {
        type(By.name("firstname"), cantactData.getFirstname());
        type(By.name("lastname"), cantactData.getLastname());
        type(By.name("address"), cantactData.getAddress());
        type(By.name("home"), cantactData.getPhone());
        type(By.name("email"), cantactData.getEmail());

    }

    public void initAddNew() {
        click(By.linkText("add new"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void selectEditButton() {

        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

    }

    public void selectUpdateButton() {

        click(By.name("update"));
    }


    public void selectDeleteButton() {

        click(By.xpath(" //div[@id='content']/form[2]/div[2]/input"));

    }

    public void closeAlert() {
        wd.switchTo().alert().accept();

    }

    public void findMsg ()
    {
        find (By.cssSelector("div.msgbox"));
    }
}
