package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Denis on 19.03.2017.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.conact().list().size() == 0) {
            app.conact().create(new CantactData().
                    withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withEmail("12345@mail.ru"));
        }
        app.conact().findSelects();
    }

    @Test
    public void testCntactModifacation() {

        List<CantactData> before = app.conact().list();
        int index = before.size() - 1;
        CantactData contact = new CantactData()
                .withId(before.get(index).getId()).withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withPhone("+ 74991234567").withEmail("12345@mail.ru");

        app.conact().modify(index, contact);

        List<CantactData> after = app.conact().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);

        Comparator<? super CantactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
