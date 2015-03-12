package rest;

import entity.Phone;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonDTO implements Serializable {

    private String email;
    private String firstName;
    private String lastName;
    private String street;
    private String additionalInfo;
    private String zip;
    List<Phone> phones = new ArrayList();

    public PersonDTO(String email, String firstName, String lastName, String street, String additionalInfo, String zip) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.zip = zip;
    }

   

    public String getEmail() {
        return email;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getZip() {
        return zip;
    }

    public List<Phone> getPhones() {
        return phones;
    }
    
    
}
