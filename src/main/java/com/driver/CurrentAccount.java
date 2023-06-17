package com.driver;
// #3
import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    //BankAccount bankAccount=new BankAccount();
    String tradeLicenseId; //consists of Uppercase English characters only

//    public CurrentAccount(String name, double balance, double minBalance) {
//        super(name, balance, minBalance);
//    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        //super();
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);   //call the constructor of the parent class
        this.tradeLicenseId = tradeLicenseId; //initialize the tradeLicenseId field
        //validateLicenseId(); //check if the license Id is valid
             };



    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        int[] freq = new int[26];

        //Loop through the license Id and update the frequency array
        for(int i = 0; i < tradeLicenseId.length(); i++){
            char c = tradeLicenseId.charAt(i);
            freq[c - 'A']++; //increment the frequency of the current character
        }

        //Create a priority queue to store the characters in descending order of their frequency
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq[b - 'A'] - freq[a - 'A']);

        //Add all the characters to the priority queue
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                pq.add((char)(i + 'A'));
            }
        }

        //Create a StringBuilder to store the new license Id
        StringBuilder sb = new StringBuilder();

        //Loop until the priority queue is empty or there is only one character left
        while(pq.size() > 1){
            //Poll two characters with highest frequency from the queue
            char c1 = pq.poll();
            char c2 = pq.poll();

            //Append them to the new license Id alternatively
            sb.append(c1);
            sb.append(c2);

            //Decrement their frequency by one
            freq[c1 - 'A']--;
            freq[c2 - 'A']--;

            //If their frequency is still positive, add them back to the queue
            if(freq[c1 - 'A'] > 0){
                pq.add(c1);
            }
            if(freq[c2 - 'A'] > 0){
                pq.add(c2);
            }
        }

        //If there is one character left in the queue, append it to the new license Id
        if(!pq.isEmpty()){
            char c = pq.poll();
            sb.append(c);
        }

        //Check if the new license Id is valid or not
        boolean valid = true;
        for(int i = 0; i < sb.length() - 1; i++){
            if(sb.charAt(i) == sb.charAt(i + 1)){
                valid = false;
                break;
            }
        }

        //If the new license Id is valid, assign it to the tradeLicenseId field
        if(valid){
            tradeLicenseId = sb.toString();

        }
        else{
            //Otherwise, throw an exception
            throw new Exception("Valid License can not be generated");
        }
    }

    //  ***********
    public CurrentAccount(String name, double balance, double minBalance, String tradeLicenseId) {
        super(name, balance, minBalance);
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }


}


