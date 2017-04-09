package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CntactCreationTests extends TestBase {


    @Test
    public void testCntactCreation() {
        app.goTo().homePage();
        Contacts before = app.conact().all();
        CantactData contact = new CantactData().
                withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5").withEmail("12345@mail.ru");
        app.conact().create(contact);
        assertThat(app.conact().count(), equalTo(before.size() + 1));
        Contacts after = app.conact().all();
        assertThat(after, equalTo
                (before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


    }


}
