package lab07.Ex2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorageTxt implements ContactsStorageInterface{
    private String path;

    public StorageTxt(String path){
        this.path=path;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(path));
            while(sc.hasNextLine()){
                String[] lineSplinted = sc.nextLine().split("\t");
                contacts.add(new Contact(lineSplinted[0], lineSplinted[1], lineSplinted[2]));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found during contacts loading!");
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Contact contact : list) {
                writer.write(contact.toString());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
