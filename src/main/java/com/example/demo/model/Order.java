package com.example.demo.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String notes;
    private Integer unit;
    private String customer;
    private String address;
    private Date date;
    
    public Order(){
        
    }

    public Order(Long id, String name, String notes, Integer unit, String customer, String address, Date date){
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.unit = unit;
        this.customer = customer;
        this.address = address;
        this.date = date;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getNotes(){
        return notes;
    }
    public Integer getUnit(){
        return unit;
    }
    public void setUnit(Integer unit){
        this.unit = unit;
    }
    public String getCustomer(){
        return customer;
    }
    public void setCustomer(String customer){
        this.customer = customer;
    }
    public String getAddress(){
        return address;
    }
    public Date getDate(){
        return date;
    }
}