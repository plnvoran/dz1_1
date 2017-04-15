package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CntactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new CantactData().withtFirstname(split[0]).withLastname(split[1]).withAddress(split[2])
                    .withEmail(split[3]).withHomePhone(split[4])
                    });
            line = reader.readLine();
        }

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
