package assignment3;

import java.io.Serializable;

public class Transaction implements Serializable{

    private int transactionNum;
    private String date;
    private String type;
    private double amount;
    private static int transactionCount = 101;


    public Transaction(String transactionDate, String transactionType, double transactionAmmount) {

        this.transactionNum = ++transactionCount; //Generate Transaction Number\s
        this.date = transactionDate;
        this.type = transactionType;
        this.amount = transactionAmmount;


    }

    @Override
    public String toString() {
        return(date + "  " + type + " " + String.valueOf(amount));
    }
}
