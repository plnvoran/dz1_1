package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.File;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Denis on 19.03.2017.
 */
public class DeleteContactTests extends TestBase {
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
    public void testContactDelete() {

        Contacts before =  app.db().contacts();
        CantactData deletedContact=before.iterator().next();
        app.conact().delete(deletedContact);
        assertThat(app.conact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));


    }


}
