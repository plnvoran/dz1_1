package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

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

        Contacts before = app.conact().all();
        CantactData modifiedContact = before.iterator().next();
        CantactData contact = new CantactData()
                .withId(modifiedContact.getId()).withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withPhone("+ 74991234567").withEmail("12345@mail.ru");
        app.conact().modify(contact);
        assertThat(app.conact().count(), equalTo(before.size()));
        Contacts after = app.conact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
