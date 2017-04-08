package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class CntactCreationTests extends TestBase {



    @Test
    public void testCntactCreation() {
        app.getNavigationHelper().goToHomePage();
        List<CantactData> before = app.getContactHelper().getContactList();
        CantactData contact = new CantactData("First name", "Last name", "Moscow, Arbat 5", null, "12345@mail.ru");
        app.getContactHelper().createContact (contact);
        List<CantactData> after = app.getContactHelper().getContactList();
        int index=before.size() + 1;
        Assert.assertEquals(after.size(), index);



        before.add(contact);

        Comparator<? super CantactData> byId=(g1, g2)->Integer.compare(g1.getId(),g2.getId()) ;
        before.sort(byId);
        after.sort(byId);


        Assert.assertEquals(before,after);


    }


}
