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

        //Check if the amount exceeds the maximum withdrawal limit
        if(amount > maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }

        super.withdraw(amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        //Calculate the simple interest using the formula: A = P * (1 + r * t)
        //where A is the final amount, P is the principal amount, r is the rate and t is the time in years
        double simpleInterest = balance * (1 + rate * years);

        //Return the final amount
        return simpleInterest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year

        //Calculate the compound interest using the formula: A = P * (1 + r / n) ^ (n * t)
        //where A is the final amount, P is the principal amount, r is the rate, n is the number of times per year and t is the time in years
        double compoundInterest = balance * Math.pow(1 + rate / times, times * years);

        //Return the final amount
        return compoundInterest;
    }

}
