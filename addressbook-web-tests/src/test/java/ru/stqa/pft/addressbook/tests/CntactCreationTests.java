package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class CntactCreationTests extends TestBase {



    @Test (enabled=false)
    public void testCntactCreation() {
        app.getNavigationHelper().goToHomePage();
        List<CantactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initAddNew();
        CantactData contact = new CantactData("First name", "Last name", "Moscow, Arbat 5", null, "12345@mail.ru");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitNewConract();
        app.getContactHelper().returnToHomePage();

        List<CantactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() + 1);



        before.add(contact);

        Comparator<? super CantactData> byId=(g1, g2)->Integer.compare(g1.getId(),g2.getId()) ;
        before.sort(byId);
        after.sort(byId);


        Assert.assertEquals(before,after);


    }


}
