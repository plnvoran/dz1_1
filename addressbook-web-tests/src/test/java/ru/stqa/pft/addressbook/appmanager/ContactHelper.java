package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    public void selectContactToDeleteById(int id) {

        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }
    public void selectContactToModifyById(int id) {

        wd.findElement(By.xpath("//a[@href='edit.php?id="+id+"']")).click();
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


    public void findMsg() {
        isElementPresent(By.cssSelector("div.msgbox"));
    }


    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {

            return;
        }
        click(By.linkText("home page"));
    }

    public void create(CantactData cantact) {
        initAddNew();
        fillContactForm(cantact);
        submitNewConract();
        returnToHomePage();
    }

    public void modify(CantactData contact) {
        selectContactToModifyById(contact.getId());
        fillContactForm(contact);
        selectUpdateButton();
        returnToHomePage();
        findSelects();
    }


    public void delete(CantactData contact) {
        selectContactToDeleteById(contact.getId());
        selectDeleteButton();
        closeAlert();
        findMsg();
        findMaintable();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));

    }

    public void findSelects() {
        isElementPresent(By.name("selected[]"));
    }

    public void findMaintable() {
        isElementPresent(By.xpath("//*[@id='maintable']"));
    }

    public int getGroupCouunt() {
        return wd.findElements(By.name("selected[]")).size();
    }



    public Contacts all() {
       Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lname = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
            String fname = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
            contacts.add(new CantactData().withId(id).withtFirstname(fname).withLastname(lname));


        }

        return contacts;
    }


}
