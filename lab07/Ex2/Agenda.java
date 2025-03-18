package lab07.Ex2;

import java.util.ArrayList;
import java.util.List;

public class Agenda implements ContactsInterface{
    private List<Contact> contactos;
    private ContactsStorageInterface storage;

    public Agenda(ContactsStorageInterface storage) {
        this.storage = storage;
        this.contactos=new ArrayList<>();
    }

    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        contactos.addAll(store.loadContacts());
        System.out.println("Contacts Loaded");
    }

    @Override
    public void saveAndClose() {
        storage.saveContacts(contactos);    
        System.out.println("Contacts Saved");
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        store.saveContacts(contactos);
        System.out.println("Contacts Saved");
    }

    @Override
    public boolean exist(Contact contact) {
        if (contactos.contains(contact)){
            return true;
        }
        return false;
    }

    @Override
    public Contact getByName(String name) {
        for (Contact contact : this.contactos) {
            if(contact.getName().equals(name)){
                return contact;
            }
        }
        return null;

    }

    @Override
    public boolean add(Contact contact) {
        contactos.add(contact);
        System.out.println("Contact Added");
        return true;
    }

    @Override
    public boolean remove(Contact contact) {
        contactos.remove(contact);
        System.out.println("Contact Removed");
        return true;
    }

    
    
}
