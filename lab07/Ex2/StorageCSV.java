package lab07.Ex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StorageCSV implements ContactsStorageInterface{
    private String path;

    public StorageCSV(String path){
        this.path = path;
    }
    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String email = parts[1].trim();
                    String phone = parts[2].trim();
                    contacts.add(new Contact(name, email, phone));
                } else {
                    System.out.println("Invalid line in CSV: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts from CSV file: " + e.getMessage());
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (FileWriter writer = new FileWriter(path)) {
            for (Contact contact : list) {
                writer.write(contact.getName() + "," + contact.getEmail() + "," + contact.getTelemovel() + "\n");
            }
            System.out.println("Contacts saved successfully in CSV format.");
            return true;
        } catch (IOException e) {
            System.out.println("Error saving contacts in CSV format: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
