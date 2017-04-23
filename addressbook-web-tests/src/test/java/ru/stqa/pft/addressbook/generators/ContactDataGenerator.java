package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
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

    @Parameter(names = "-d", description = "Date format")
    public String format;

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
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else {
            System.out.println("Unknown format"+format);
        }


    }

    private void saveAsXml(List<CantactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(CantactData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private void saveAsCsv(List<CantactData> contacts, File file) throws IOException {
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
                    .withMobilePhone(String.format("495-777-55-0%s", i))
                    .withWorkPhone(String.format("495-777-55-0%s", i))
                    .withEmail2(String.format("Email%s@test.ru", i))
                    .withEmail3(String.format("Email%s@test.ru", i))
                    .withHome2Phone(String.format("495-777-55-0%s", i))


                    .withPhoto(new File("src/test/resources/ring.gif"))

            );

        }
        return contacts;
    }

}

