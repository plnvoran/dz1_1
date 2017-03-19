package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.CantactData;

/**
 * Created by Denis on 19.03.2017.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(FirefoxDriver wd) {

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
}
