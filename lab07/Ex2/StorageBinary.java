package lab07.Ex2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StorageBinary implements ContactsStorageInterface {
    private String path;

    public StorageBinary(String path) {
        this.path=path;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            contacts = (List<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading contacts from binary file: " + e.getMessage());
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(list);
            return true;
        } catch (IOException e) {
            System.out.println("Error saving contacts to binary file: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
}
