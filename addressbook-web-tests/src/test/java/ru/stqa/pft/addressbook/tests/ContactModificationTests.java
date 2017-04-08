package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;

import java.util.Set;

/**
 * Created by Denis on 19.03.2017.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.conact().all().size() == 0) {
            app.conact().create(new CantactData().
                    withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withEmail("12345@mail.ru"));
        }
        app.conact().findSelects();
    }

    @Test
    public void testCntactModifacation() {

       Set<CantactData> before = app.conact().all();
        CantactData modifiedContact=before.iterator().next();

        CantactData contact = new CantactData()
                .withId(modifiedContact.getId()).withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withPhone("+ 74991234567").withEmail("12345@mail.ru");

        app.conact().modify(contact);

        Set<CantactData> after = app.conact().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifiedContact);
        before.add(contact);


        Assert.assertEquals(before, after);
    }


}
