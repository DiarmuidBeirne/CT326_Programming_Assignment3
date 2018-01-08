package assignment3;

import java.io.Serializable;
import java.util.ArrayList;

public class BankAccount implements Serializable {
    private String nameOnAccount;
    private int accountNum;
    private double accBalance;
    private ArrayList<Transaction> transactions;
    private double overdraft;
    private String joinDate; // "create  a BankAccount object with date “16/08/2017” " Was unsure about date in bank Account so called it joinDate

    private static int numOfAccounts = 101;

    public BankAccount(String nameOnAccount, double accBalance, double overdraft, String joinDate) {
        this.nameOnAccount = nameOnAccount;
        this.accBalance = accBalance;
        this.overdraft = overdraft;
        this.accountNum = ++numOfAccounts;
        this.joinDate = joinDate;
        transactions = new ArrayList<Transaction>();

    }

        public void deposit(String date, double amount){
            accBalance += amount;
            transactions.add(new Transaction(date, "Deposit", amount));
        }

        public void withdraw(String date, double amount){
            if(accBalance - amount < 0){
                System.out.println("Insufficient funds");
                return;
            }
            else {
                accBalance -= amount;
                transactions.add(new Transaction(date, "Withdraw", amount));
            }
        }

        public void getTransactionDetail() //Was not sure if this was supposed to print out all transactions or a single transaction. seeing as nothing is passed to the function i presumed it was all transactions.
        {
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println(transactions.get(i).toString());
            }

        }

        public String toString(){
            return "Account Number: " + accountNum + "\tName: " + nameOnAccount + "\tBalance: " + accBalance + "\tOverdraft" + overdraft;
        }


}
