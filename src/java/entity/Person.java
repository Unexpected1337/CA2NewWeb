/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Afrooz
 */
@Entity
public class Person extends InfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
//    private String street;
//    private String additionalInfo;
//    private String zip;

    @ManyToMany
    List<Hobby> hobbies = new ArrayList();

    public void addHobby(Hobby h) {
        hobbies.add(h);
    }

    public Person(String email, String firstName, String lastName) {
        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
//        this.street = street;
//        this.additionalInfo = additionalInfo;
//        this.zip = zip;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
    
    //SLET SLET SLET SLET SLET SLET SLET SLET

//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getAdditionalInfo() {
//        return additionalInfo;
//    }
//
//    public void setAdditionalInfo(String additionalInfo) {
//        this.additionalInfo = additionalInfo;
//    }
//
//    public String getZip() {
//        return zip;
//    }
//
//    public void setZip(String zip) {
//        this.zip = zip;
//    }
    
    

}
