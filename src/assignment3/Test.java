package assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {



    public static void main(String args[]) throws IOException
    {

        //  PART 1
        ArrayList<Transaction> transactionArray = new ArrayList<Transaction>(3);
        //transaction 1
        Transaction transaction1 = new Transaction("16/08/2017", "Open Account",100);
        //transaction 2
        Transaction transaction2 = new Transaction("22/08/2017", "Withdraw",50);
        //transaction 3
        Transaction transaction3 = new Transaction("23/09/2017", "Deposit",100);
        //Add transactions to transactionArray
        transactionArray.add(transaction1);
        transactionArray.add(transaction2);
        transactionArray.add(transaction3);
        //OUTPUT
        try {
            FileOutputStream fos = new FileOutputStream("transactions.txt");
            ObjectOutputStream d = new ObjectOutputStream(fos);

            d.writeObject(transactionArray);
            d.close();

        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        FileInputStream fis = new FileInputStream("transactions.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //create new array to read in object
        ArrayList<Transaction> newArray = new ArrayList<Transaction>();

        try {
            newArray = (ArrayList<Transaction>)ois.readObject();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        for (int i = 0; i < newArray.size(); i++) {
            System.out.println(newArray.get(i).toString());
        }
        System.out.println("End of Part 1\n\n\n");


        //PART 2


        BankAccount testAccount = new BankAccount("John Smith",100,0,"16/08/2017");
        testAccount.withdraw("22/08/2017",200);
        testAccount.deposit("23/08/2017",100);
        testAccount.withdraw("01/09/2017", 50);

        //OUTPUT
        try {
            FileOutputStream fos2 = new FileOutputStream("accountdetails.txt");
            ObjectOutputStream d2 = new ObjectOutputStream(fos2);

            d2.writeObject(testAccount);
            d2.close();

        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        //input
        FileInputStream fis2 = new FileInputStream("accountdetails.txt");
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        BankAccount newBankAccount = null; //Had to initilize newBankAccount as it was in try catch.
        try {
            newBankAccount = (BankAccount)ois2.readObject();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        System.out.println(newBankAccount.toString());

        newBankAccount.getTransactionDetail();
        System.out.println("End of Part 2");

        // PART 3
        //write line to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("overdraftQuestion.txt"))) {
            bw.write("Would you like to increase your overdraft? Please type Yes/No at the end of the line");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ASk question to user
        System.out.println("Would you like to increase your overdraft? Please type Yes/No at the end of the line: ");

        //Get user input
        Scanner scan = new Scanner(System.in);
        String Userinput = scan.next();


        //Append File






    }
}
