package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
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
    @BeforeMethod
    public void ensurePreconditions (){
        app.goTo().homePage();
        if (app.conact().all().size()==0) {
            app.conact().create(new CantactData().
                    withtFirstname("First name").withLastname("Last name").withAddress("Moscow, Arbat 5")
                    .withHomePhone("+12345678890").withMobilePhone("11 22").withWorkPhone("11-22").withHome2Phone("12345")
                    .withEmail("12345@mail.ru").withEmail2("12345@mail.ru").withEmail3("12345@mail.ru")

            );

        }
        app.conact().findSelects();
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        CantactData contact = app.conact().all().iterator().next();
        CantactData contactInfoFormEditForm = app.conact().infoFormEditForm(contact);



        assertThat (contact.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));
        assertThat (contact.getAddress(), equalTo(contactInfoFormEditForm.getAddress()));
        assertThat (contact.getAllEmail(), equalTo(mergeEmails(contactInfoFormEditForm)));

    }

    private String mergePhones(CantactData contact) {
       return  Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(), contact.getWorkPhone() ,contact.getHome2Phone())
                .stream().filter((s)->!s.equals(""))
               .map (ContactPhoneTests::cleaned)
               .collect(Collectors.joining("\n"));


    }

    private String mergeEmails(CantactData contact) {
        return  Arrays.asList(contact.getEmail(),contact.getEmail2(), contact.getEmail3())
                .stream().filter((s)->!s.equals(""))
                .collect(Collectors.joining("\n"));

    }


    public static String cleaned (String phone)
    {
        return phone.replaceAll("\\s", "" ).replaceAll("[-()]", "");
    }
}
