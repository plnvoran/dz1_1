package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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

    @Parameter(names = "-c", description = "Contact count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }

        generator.run();
    }

    private void run() throws IOException {
        List<CantactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private void save(List<CantactData> contacts, File file) throws IOException {
        // System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (CantactData contact : contacts) {
            writer.write(String.format("%s;%s;%s;%s;%s\n",
                    contact.getFirstname(), contact.getLastname(), contact.getAddress(),
                    contact.getEmail(), contact.getHomePhone()));

        }
        writer.close();
    }

    private static List<CantactData> generateContacts(int count) {
        List<CantactData> contacts = new ArrayList<CantactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new CantactData()
                    .withtFirstname(String.format("Firstname %s", i))
                    .withLastname(String.format("Lastname %s", i))
                    .withAddress(String.format("Address %s", i))
                    .withEmail(String.format("Email%s@test.ru", i))
                    .withHomePhone(String.format("495-777-55-0%s", i))
            );

        }
        return contacts;
    }

}

