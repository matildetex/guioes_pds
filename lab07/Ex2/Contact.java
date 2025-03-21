package lab07.Ex2;

import java.io.Serializable;

public class Contact implements Serializable{
    private String name;
    private String email;
    private String telemovel;
    
    public Contact(String name, String email, String telemovel) {
        this.name = name;
        this.email = email;
        this.telemovel = telemovel;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelemovel() {
        return telemovel;
    }
    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((telemovel == null) ? 0 : telemovel.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (!telemovel.equals(other.telemovel))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Contact [name=" + name + ", email=" + email + ", telemovel=" + telemovel + "]";
    }
}
