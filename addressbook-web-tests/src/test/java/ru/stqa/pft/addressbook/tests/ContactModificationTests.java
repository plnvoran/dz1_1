package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Denis on 19.03.2017.
 */
public class ContactModificationTests extends TestBase {
     @Test
     public void testCntactModifacation() {
         app.getNavigationHelper().goToHomePage();
         if (!app.getContactHelper().isThereAContact()) {
             app.getContactHelper().createContact(new CantactData("First name", "Last name", "Moscow, Arbat 5", null, "12345@mail.ru"));
         }
         List<CantactData> before = app.getContactHelper().getContactList();
         app.getContactHelper().findSelect();
         app.getContactHelper().selectContact(before.size() - 1);
         app.getContactHelper().selectEditButton();

         CantactData contact=new CantactData(before.get(before.size()-1).getId(),"First name", "Last name", "Moscow, Arbat 5", "+ 74991234567", "12345@mail.ru");
         app.getContactHelper().fillContactForm(contact);
         app.getContactHelper().selectUpdateButton();
         app.getContactHelper().returnToHomePage();
         List<CantactData> after = app.getContactHelper().getContactList();
         Assert.assertEquals(after.size(), before.size());
         before.remove(before.size()-1);
         before.add(contact);

         Comparator<? super   CantactData> byId=(g1,g2)->Integer.compare(g1.getId(),g2.getId()) ;
         before.sort(byId);
         after.sort(byId);
         Assert.assertEquals(before,after);
     }






}
