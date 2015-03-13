/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Address;
import entity.Person;
import facade.EntityFacade;
import javax.persistence.Persistence;
import rest.PersonDTO;

public class Tester {

    public static void main(String[] args) {
        EntityFacade facade = new EntityFacade(Persistence.createEntityManagerFactory("CA2WebPU"));
        PersonDTO p = new PersonDTO("andersand@live.dk","anders","and","rolighedsvej","cover","1300");
        PersonDTO p2 = new PersonDTO("snake@live.dk","Professor","Snape","Slytherin","Hogwards","Perron 3/4");
        
        Person pout = facade.createPerson2(p);
        Person pout2 = facade.createPerson2(p2);

        System.out.println(pout.getId());
        System.out.println(pout2.getId());
//
//        Hobby h1 = new Hobby("Tennis", "Smashing a ball");
//        p = facade.addHobby(p, h1);
//
//        System.out.println(p.getHobbies().get(0).getName());
//
//        Hobby h2 = new Hobby("Gaming", "Going crazy");
//        p = facade.addHobbyFromId(1, h2);
//
//        System.out.println(p.getHobbies().get(1).getName());
//
//        Person person = facade.findPerson(1);        
//        System.out.println(person.getFirstName());
//        
//        
//        
//        
//        List<Person> persons = facade.getPersons();
//        System.out.println(persons.size());
//        System.out.println(persons.get(0).getFirstName());
//        System.out.println(persons.get(0).getLastName());
//        
//   
//
    }

}
