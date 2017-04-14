package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.CantactData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 14.04.2017.
 */
public class ContactDataGenerator {


    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

       List<CantactData> contacts = generateGroups(count);
       save(contacts, file);

    }

    private static void save(List<CantactData> contacts, File file) throws IOException {
       // System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (CantactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s\n",
                    contact.getFirstname(), contact.getLastname(), contact.getAddress(),
                    contact.getEmail(), contact.getHomePhone()));

        }
        writer.close();
    }

    private static List<CantactData> generateGroups(int count) {
        List<CantactData> contacts = new ArrayList<CantactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new CantactData()
                    .withtFirstname(String.format("Firstname %s", i))
                    .withLastname(String.format("Lastname %s", i))
                    .withAddress(String.format("Address %s", i))
                    .withEmail(String.format("Email%s@test.ru", i))
                    .withHomePhone(String.format("495-777-55-0%s", i))
            )

            ;


        }
        return contacts;
    }

}

