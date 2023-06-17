package com.driver;
//#5
public class StudentAccount extends BankAccount{

    String  institutionName;



    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name, balance, 0); //call the constructor of the parent class
        this.institutionName = institutionName; //initialize the institutionName field
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public StudentAccount(String name, double balance, double minBalance, String institutionName) {
        super(name, balance, minBalance);
        this.institutionName = institutionName;
    }

    public StudentAccount(String institutionName) {
        this.institutionName = institutionName;
    }
}
