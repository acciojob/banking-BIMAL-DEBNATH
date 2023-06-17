package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name, balance, 0); //call the constructor of the parent class
        this.institutionName = institutionName; //initialize the institutionName field
    }

}
