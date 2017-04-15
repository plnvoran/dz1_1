package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CntactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
       // File photo = new File("src/test/resources/ring.gif");
        list.add(new Object[]{new CantactData().withtFirstname("First name1").withLastname("Last name1").withAddress("Moscow, Arbat 1").withHomePhone("111 222 333 1").withEmail("12345@mail1.ru")});
        list.add(new Object[]{new CantactData().withtFirstname("First name2").withLastname("Last name2").withAddress("Moscow, Arbat 2").withHomePhone("111 222 333 2").withEmail("12345@mail2.ru")});
        list.add(new Object[]{new CantactData().withtFirstname("First name3").withLastname("Last name3").withAddress("Moscow, Arbat 3").withHomePhone("111 222 333 3").withEmail("12345@mail3.ru")});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testCntactCreation(CantactData contact) {
        app.goTo().homePage();
        Contacts before = app.conact().all();
        app.conact().create(contact);
        assertThat(app.conact().count(), equalTo(before.size() + 1));
        Contacts after = app.conact().all();
        assertThat(after, equalTo
                (before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


    }


}
