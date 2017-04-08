package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;

import java.util.Comparator;
import java.util.List;

public class CntactCreationTests extends TestBase {



    @Test
    public void testCntactCreation() {
        app.goTo().homePage();
        List<CantactData> before = app.conact().list();
        CantactData contact = new CantactData().
                withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withEmail("12345@mail.ru");
        app.conact().create(contact);
        List<CantactData> after = app.conact().list();
        int index=before.size() + 1;
        Assert.assertEquals(after.size(), index);



        before.add(contact);

        Comparator<? super CantactData> byId=(g1, g2)->Integer.compare(g1.getId(),g2.getId()) ;
        before.sort(byId);
        after.sort(byId);


        Assert.assertEquals(before,after);


    }


}
