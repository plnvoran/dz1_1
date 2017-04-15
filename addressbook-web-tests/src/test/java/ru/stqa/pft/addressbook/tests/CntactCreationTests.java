package ru.stqa.pft.addressbook.tests;


import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CntactCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml="";
        String line = reader.readLine();
        while (line != null) {
            xml+=line;
            line = reader.readLine();
        }

        XStream xstream = new XStream();
        xstream.processAnnotations(CantactData.class);
        List <CantactData> contacts =(List <CantactData>) xstream.fromXML(xml);
        return contacts.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();
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
