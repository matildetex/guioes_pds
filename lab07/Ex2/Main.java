package lab07.Ex2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        File f = new File("contacts.txt");
        f.createNewFile();
        FileWriter writer = new FileWriter(f);
        String baseContacts = "Matilde\tmatilde@ua.pt\t926263879\n" +
                              "Carolina\tcarolina@ua.pt\t98643456789\n" +
                              "Tiago\ttiago@ua.pt\t9456789087\n" +
                              "Roberto\troberto@ua.pt\t9876467876\n";
        writer.write(baseContacts);
        writer.close();

        System.out.println("\n>>>>>>>>>>>>>>>>>Testing Storage Contacts TXT:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        StorageTxt contactsStore = new StorageTxt("contacts.txt");
        Agenda contactsList = new Agenda(contactsStore);
        contactsList.openAndLoad(contactsStore);
        testingStorage(contactsList);

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Matilde", "matilde@ua.pt", "926263879"));
        contacts.add(new Contact("Carolina", "carolina@ua.pt", "98643456789"));
        contacts.add(new Contact("Tiago", "tiago@ua.pt", "9456789087"));
        contacts.add(new Contact("Roberto", "roberto@ua.pt", "9876467876"));


        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>Testing Binary Storage:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        String fileName = "contacts.bin";
        saveContactsToBinaryFile(contacts, fileName);
        StorageBinary contactsStoreBinary = new StorageBinary("contacts.bin");
        Agenda contactsListBinary = new Agenda(contactsStoreBinary);
        contactsListBinary.openAndLoad(contactsStoreBinary);
        testingStorage(contactsListBinary);

        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Testing Json Storage:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        String fileNamejson = "contacts.json";
        saveContactsToJsonFile(contacts, fileNamejson);
        StorageJson contactsStoreJSON = new StorageJson("contacts.json");
        Agenda contactsListJson = new Agenda(contactsStoreJSON);
        contactsListJson.openAndLoad(contactsStoreJSON);
        testingStorage(contactsListJson);

        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Testing CSV Storage:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        String fileNamecsv = "contacts.csv";
        saveContactsToCsvFile(contacts, fileNamecsv);
        StorageCSV contactsStoreCsv = new StorageCSV("contacts.csv");
        Agenda contactsListCsv = new Agenda(contactsStoreCsv);
        contactsListCsv.openAndLoad(contactsStoreCsv);
        testingStorage(contactsListCsv);

    }

    public static void saveContactsToCsvFile(List<Contact> contacts, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Nome,Email,Telemóvel");
            writer.newLine();
            for (Contact contact : contacts) {
                writer.write(String.format("%s,%s,%s",
                        contact.getName(), contact.getEmail(), contact.getTelemovel()));
                writer.newLine();
            }
            System.out.println("Contacts saved successfully in CSV format.");
        } catch (IOException e) {
            System.out.println("Error saving contacts in CSV format:" + e.getMessage());
            e.printStackTrace();
        }
    }
    
    

    public static void saveContactsToBinaryFile(List<Contact> contacts, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contacts);
            System.out.println("Contatos salvos com sucesso em formato binário.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos em formato binário: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void saveContactsToJsonFile(List<Contact> contacts, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            StringBuilder json = new StringBuilder();
            json.append("[\n");
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                json.append("  {\n");
                json.append("    \"name\": \"" + contact.getName() + "\",\n");
                json.append("    \"email\": \"" + contact.getEmail() + "\",\n");
                json.append("    \"phone\": \"" + contact.getTelemovel() + "\"\n");
                json.append("  }");
                if (i < contacts.size() - 1) {
                    json.append(",");
                }
                json.append("\n");
            }
            json.append("]\n");
            writer.write(json.toString());
            System.out.println("Contacts saved successfully in JSON format.");
        } catch (IOException e) {
            System.out.println("Error saving contacts in JSON format:" + e.getMessage());
            e.printStackTrace();
        }
    }
    
        

        public static void testingStorage(Agenda contactsList){
            System.out.println("\nTesting if contact added IS on the list:");
            Contact t1 = new Contact("Matilde", "matilde@ua.pt", "926263879");
            if (contactsList.exist(t1)) {
                System.out.println(t1.toString() + " belongs to the list!");
            } else {
                System.out.println(t1.toString() + " doesn't belong to the list!");
            }

            Contact t2 = new Contact("Juliana", "juliana@gmail.com", "987654321");
            System.out.println("\nTesting adding contact to list:");
            if (contactsList.add(t2)) {
                System.out.println( t2.toString() + " added to the list!");
            } else {
                System.out.println("Something went wrong adding " + t2.toString());
            }

            System.out.println("\nTesting if contact added before is in the list:");
            if (contactsList.exist(t2)) {
                System.out.println(t2.toString() + " belongs to the list!");
            } else {
                System.out.println(t2.toString() + " doesn't belong to the list!");
            }

            Contact t3 = new Contact("Sofia", "sofia@ua.pt", "914567784");
            System.out.println("\nTesting if contact that ISN'T in the list IS in the list:");
            if (contactsList.exist(t3)) {
                System.out.println(t3.toString() + " belongs to the list!");
            } else {
                System.out.println(t3.toString() + " doesn't belong to the list!");
            }

            System.out.println("\nTesting removing contact that is in the list:");
            if (contactsList.remove(t2)) {
                System.out.println(t2.toString() + " removed from the list!");
            } else {
                System.out.println("Something went wrong removing " + t2.toString());
            }

            System.out.println("\nTesting if contact removed before IS STILL the list:");
            if (contactsList.exist(t2)) {
                System.out.println(t2.toString() + " belongs to the list!");
            } else {
                System.out.println(t2.toString() + " doesn't belong to the list!");
            }


            System.out.println("\nTesting search in the list:");
            System.out.println("Searching for 'Carolina' in the list!");
            Contact searchResult = contactsList.getByName("Carolina");
            if (searchResult != null) {
                System.out.println("Found this contact for 'Carolina': " + searchResult.toString() + "\n");
            }else {
                System.out.println("Name is not on the list ");
            }

            contactsList.saveAndClose();
        }
        
     
    }