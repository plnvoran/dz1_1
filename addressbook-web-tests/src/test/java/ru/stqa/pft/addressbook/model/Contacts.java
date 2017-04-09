package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Denis on 08.04.2017.
 */
public class Contacts extends ForwardingSet <CantactData> {
    private Set<CantactData> delegate;

    public Contacts (Contacts  contacts) {
        this.delegate=new HashSet<CantactData>(contacts.delegate);
    }
    public Contacts() {
        this.delegate=new HashSet<CantactData>();
    }

    @Override
    protected Set<CantactData> delegate() {
        return delegate;
    }

    public Contacts withAdded(CantactData contact)
    {
        Contacts contacts=new Contacts (this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(CantactData contact)
    {
        Contacts contacts=new Contacts (this);
        contacts.remove(contact);
        return contacts;
    }

}
