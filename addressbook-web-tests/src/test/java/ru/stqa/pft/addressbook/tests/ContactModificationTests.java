package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Denis on 19.03.2017.
 */
public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {

        if (app.db().contacts().size()==0) {
            app.goTo().homePage();
            app.conact().create(new CantactData()
                    .withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withEmail("12345@mail.ru")
                    .withPhoto(new File("src/test/resources/ring.gif"))
                    .withHomePhone("1234567890")
                    .withMobilePhone("111222333")
                    .withWorkPhone("444555777")
                    .withHome2Phone("888777444")
                    .withEmail2("2@mail.ru")
                    .withEmail3("3@mail.ru")

            );


        }
        app.conact().findSelects();
    }

    @Test
    public void testCntactModifacation() {

        Contacts before =  app.db().contacts();
        CantactData modifiedContact = before.iterator().next();


        CantactData contact = new CantactData()
                .withId(modifiedContact.getId())
                .withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withEmail("12345@mail.ru")
                .withPhoto(new File("src/test/resources/ring.gif"))
                .withHomePhone("1234567890")
                .withMobilePhone("111222333")
                .withWorkPhone("444555777")
                .withHome2Phone("888777444")
                .withEmail2("2@mail.ru")
                .withEmail3("3@mail.ru")
                ;



        app.goTo().homePage();
        app.conact().modify(contact);
        assertThat(app.conact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
