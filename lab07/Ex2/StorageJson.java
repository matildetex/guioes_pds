package lab07.Ex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StorageJson implements ContactsStorageInterface{
    private String path;

    public StorageJson(String path){
        this.path=path;
    }

    @Override
public List<Contact> loadContacts() {
    List<Contact> contacts = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        StringBuilder jsonContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonContent.append(line);
        }
        String jsonString = jsonContent.toString().trim();

        jsonString = jsonString.replaceAll("\\s+", "");

        jsonString = jsonString.replaceAll("^\\[|\\]$", "");

        String[] contactStrings = jsonString.split("\\}\\s*,\\s*\\{");
        for (String contactString : contactStrings) {
            contactString = contactString.replaceAll("^\\{|\\}$", "");

            String[] fields = contactString.split(",");
            String name = null, email = null, phone = null;
            for (String field : fields) {
                String[] keyValue = field.split(":");
                String key = keyValue[0].replaceAll("\"", "").trim();
                String value = keyValue[1].replaceAll("\"", "").trim();

                if (key.equals("name")) {
                    name = value;
                } else if (key.equals("email")) {
                    email = value;
                } else if (key.equals("phone")) {
                    phone = value;
                }
            }
            if (name != null && email != null && phone != null) {
                contacts.add(new Contact(name, email, phone));
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading contacts from JSON file: " + e.getMessage());
        e.printStackTrace();
    }
    return contacts;
}

    


    @Override
    public boolean saveContacts(List<Contact> list) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write("[");
            for (int i = 0; i < list.size(); i++) {
                Contact contact = list.get(i);
                writer.write("{");
                writer.write("\"name\":\"" + contact.getName() + "\",");
                writer.write("\"email\":\"" + contact.getEmail() + "\"");
                writer.write("}");

                if (i < list.size() - 1) {
                    writer.write(",");
                }
            }

            writer.write("]");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
