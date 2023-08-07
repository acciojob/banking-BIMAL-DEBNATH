package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default

        super(name, balance, 0); //call the constructor of the parent class
        this.maxWithdrawalLimit = maxWithdrawalLimit; //initialize the maxWithdrawalLimit field
        this.rate = rate; //initialize the rate field

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        if(amount > this.maxWithdrawalLimit ){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }

        super.withdraw(amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double TotalSimpleInterest = super.getBalance() * (1 + (rate * years)/100);

        //Return the final amount
        return TotalSimpleInterest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year

        double A = super.getBalance() * Math.pow((1 + rate / (times*100)), times * years);

        //Return the final amount
        return A;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }
}
