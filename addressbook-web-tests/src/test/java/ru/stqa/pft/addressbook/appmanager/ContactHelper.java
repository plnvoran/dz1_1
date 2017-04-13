package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.List;

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
        type(By.name("home"), cantactData.getHomePhone());
        type(By.name("email"), cantactData.getEmail());

        type(By.name("email2"), cantactData.getEmail2());
        type(By.name("email3"), cantactData.getEmail3());
        type(By.name("mobile"), cantactData.getMobilePhone());
        type(By.name("work"), cantactData.getWorkPhone());
        type(By.name("phone2"), cantactData.getHome2Phone());
        attach(By.name("photo"), cantactData.getPhoto());
    }

    public void initAddNew() {
        click(By.linkText("add new"));
    }


    public void selectContactToDeleteById(int id) {

        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }
    public void selectContactToModifyById(int id) {

        //wd.findElement(By.xpath("//a[@href='edit.php?id="+id+"']")).click();
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
}
    public void selectDetailsById(int id) {

        wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
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
        contactCache=null;
        returnToHomePage();
    }

    public void modify(CantactData contact) {
        selectContactToModifyById(contact.getId());
        fillContactForm(contact);
        selectUpdateButton();
        contactCache=null;
        returnToHomePage();
        findSelects();
    }


    public void delete(CantactData contact) {
        selectContactToDeleteById(contact.getId());
        selectDeleteButton();
        closeAlert();
        findMsg();
        findMaintable();
        contactCache=null;
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

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache=null;

    public Contacts all() {
      if (contactCache!=null) {
          return new Contacts (contactCache);
      }

        contactCache  = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lname = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
            String fname = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
            String allPhones = element.findElement(By.cssSelector("td:nth-of-type(6)")).getText();

            String address=element.findElement(By.cssSelector("td:nth-of-type(4)")).getText();
            String allEmails=element.findElement(By.cssSelector("td:nth-of-type(5)")).getText();


            contactCache.add(new CantactData().withId(id).withtFirstname(fname).withLastname(lname)
                          .withAllPhones(allPhones).withAddress(address).withAllEmail(allEmails));


        }

        return new Contacts (contactCache);
    }


    public CantactData infoFormEditForm(CantactData contact) {
        selectContactToModifyById(contact.getId());

        String firstname=wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname=wd.findElement(By.name("lastname")).getAttribute("value");
        String home=wd.findElement(By.name("home")).getAttribute("value");
        String mobile=wd.findElement(By.name("mobile")).getAttribute("value");
        String work=wd.findElement(By.name("work")).getAttribute("value");
        String home2=wd.findElement(By.name("phone2")).getAttribute("value");

        String adress=wd.findElement(By.name("address")).getAttribute("value");
        String email=wd.findElement(By.name("email")).getAttribute("value");
        String email2=wd.findElement(By.name("email2")).getAttribute("value");
        String email3=wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();
        return new CantactData().withId(contact.getId()).withtFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withHome2Phone(home2)
                .withAddress(adress)
                .withEmail(email).withEmail2(email2).withEmail3(email3);

    }

    public CantactData infoFromDetailsForm(CantactData contact) {
        selectDetailsById(contact.getId());
        String allText  = wd.findElement(By.xpath("//*[@id='content']")).getText();
        return new CantactData().withAllText(allText);

    }
}
