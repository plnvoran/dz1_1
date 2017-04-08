package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;


import java.util.Set;

public class CntactCreationTests extends TestBase {


    @Test
    public void testCntactCreation() {
        app.goTo().homePage();
        Set<CantactData> before = app.conact().all();
        CantactData contact = new CantactData().
                withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withEmail("12345@mail.ru");
        app.conact().create(contact);
        Set<CantactData> after = app.conact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);


    }


}
