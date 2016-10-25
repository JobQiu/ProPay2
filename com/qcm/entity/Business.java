package com.qcm.entity;

import java.sql.Timestamp;


/**
 * Business entity. @author MyEclipse Persistence Tools
 */

public class Business  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Counter counter;
     private Integer money;
     private String type;
     private Timestamp time;
     private Integer otherCounter;


    // Constructors

    /** default constructor */
    public Business() {
    }

    
    /** full constructor */
    public Business(Counter counter, Integer money, String type, Timestamp time, Integer otherCounter) {
        this.counter = counter;
        this.money = money;
        this.type = type;
        this.time = time;
        this.otherCounter = otherCounter;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Counter getCounter() {
        return this.counter;
    }
    
    public void setCounter(Counter counter) {
        this.counter = counter;
    }

    public Integer getMoney() {
        return this.money;
    }
    
    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getTime() {
        return this.time;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getOtherCounter() {
        return this.otherCounter;
    }
    
    public void setOtherCounter(Integer otherCounter) {
        this.otherCounter = otherCounter;
    }
   








}