package ru.stqa.pft.addressbook.tests;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.CantactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Denis on 09.04.2017.
 */
public class ContactPhoneTests extends TestBase {
    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        CantactData contact = app.conact().all().iterator().next();
        CantactData contactInfoFormEditForm = app.conact().infoFormEditForm(contact);

        assertThat (contact.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));

    }

    private String mergePhones(CantactData contact) {
       return  Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(), contact.getWorkPhone() ,contact.getHome2Phone())
                .stream().filter((s)->!s.equals(""))
               .map (ContactPhoneTests::cleaned)
               .collect(Collectors.joining("\n"));


    }


    public static String cleaned (String phone)
    {
        return phone.replaceAll("\\s", "" ).replaceAll("[-()]", "");
    }
}
