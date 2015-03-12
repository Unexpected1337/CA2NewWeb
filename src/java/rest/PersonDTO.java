package rest;

import entity.Phone;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonDTO implements Serializable {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String zip;
    List<Phone> phones = new ArrayList();

    public PersonDTO(String email, String firstName, String lastName, String address1, String address2, String zip) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.zip = zip;
    }

   

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    
    
    
    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getZip() {
        return zip;
    }

    public List<Phone> getPhones() {
        return phones;
    }
    
    
}
