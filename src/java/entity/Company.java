/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;

/**
 *
 * @author saleh
 */
@Entity
public class Company extends InfoEntity{
    private Integer id;
    private String name;
    private String description;
    private int cvr;
    private int numEmployees;
    private Float marketValue;

    public Company(Integer id, String name, String description, int cvr, int numEmployees, Float marketValue, String email) {
        super(email);
        this.id = id;
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public Float getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Float marketValue) {
        this.marketValue = marketValue;
    }
    
    
    
}
