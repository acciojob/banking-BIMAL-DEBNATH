package com.driver;

public class BankAccount {

    private String name;
    double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
       this.name=name;
       this.balance=balance;
       this.minBalance=minBalance;
    }

    public BankAccount() {

    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(sum < 0 || sum > 9 * digits){
            throw new Exception("Account Number can not be generated");
        }

        StringBuilder sb = new StringBuilder();

        //Loop from the most significant digit to the least significant digit
        for(int i = digits; i > 0; i--){
            //Find the maximum possible value for the current digit
            int max = Math.min(sum, 9);

            //Append a random value between 0 and max to the account number
            int val = (int)(Math.random() * (max + 1));
            sb.append(val);

            //Update the remaining sum
            sum -= val;
        }
        String team=sb.toString();
        return team;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        //double curr=this.balance;
        if(this.balance-amount<this.minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.balance-=amount;
    }


}