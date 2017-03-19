package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.CantactData;

/**
 * Created by Denis on 19.03.2017.
 */
public class ContactModificationTests extends TestBase {
     @Test
     public void testCntactModifacation() {
         app.getNavigationHelper().goToHomePage();
         app.getContactHelper().selectContact();
         app.getContactHelper().selectEditButton();
         app.getContactHelper().fillContactForm(new CantactData("First name2", "Last name2", "Moscow, Arbat 52", "+ 749912345672", "2222@mail.ru"));
         app.getContactHelper().selectUpdateButton();
         app.getNavigationHelper().returnToHomePage();


     }

}
