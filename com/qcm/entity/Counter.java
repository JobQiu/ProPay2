package com.qcm.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Counter entity. @author MyEclipse Persistence Tools
 */

public class Counter  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer userCounter;
     private String cardName;
     private String sex;
     private String address;
     private String cardNumber;
     private Double balance;
     private Integer state;
     private String userName;
     private String userPassword;
     private String userQuestion;
     private String userAnswer;
     private String userEmail;
     private String userPhone;
     private Set businesses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Counter() {
    }

	/** minimal constructor */
    public Counter(Integer id, Integer userCounter, String cardName, String sex, String address, String cardNumber, Double balance, Integer state, String userName, String userPassword, String userQuestion, String userAnswer, String userPhone) {
        this.id = id;
        this.userCounter = userCounter;
        this.cardName = cardName;
        this.sex = sex;
        this.address = address;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.state = state;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userQuestion = userQuestion;
        this.userAnswer = userAnswer;
        this.userPhone = userPhone;
    }
    
    /** full constructor */
    public Counter(Integer id, Integer userCounter, String cardName, String sex, String address, String cardNumber, Double balance, Integer state, String userName, String userPassword, String userQuestion, String userAnswer, String userEmail, String userPhone, Set businesses) {
        this.id = id;
        this.userCounter = userCounter;
        this.cardName = cardName;
        this.sex = sex;
        this.address = address;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.state = state;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userQuestion = userQuestion;
        this.userAnswer = userAnswer;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.businesses = businesses;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserCounter() {
        return this.userCounter;
    }
    
    public void setUserCounter(Integer userCounter) {
        this.userCounter = userCounter;
    }

    public String getCardName() {
        return this.cardName;
    }
    
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getBalance() {
        return this.balance;
    }
    
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserQuestion() {
        return this.userQuestion;
    }
    
    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion;
    }

    public String getUserAnswer() {
        return this.userAnswer;
    }
    
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return this.userPhone;
    }
    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Set getBusinesses() {
        return this.businesses;
    }
    
    public void setBusinesses(Set businesses) {
        this.businesses = businesses;
    }
   








}