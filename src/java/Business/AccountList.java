package Business;

/**************************************************************************************************
Author: Aaron Lau
Course: CIST 2373 - Java Programming III
Lab - Lab #4 - Business Objects
Honor Statement - I promise that I wrote this code.
I did not copy this code from someone else or the Internet
And I did not use any AI Tools to Generate this code.
***************************************************************************************************/
import java.sql.*;
import java.util.ArrayList;

public class AccountList {
    //properties
   public ArrayList<Account> acctList = new ArrayList<Account>();
   
   //methods
   public void addAcct(Account acct1) {
       acctList.add(acct1);
   }//end addAccount
   
   public int getCount() {
       return acctList.size();
   }
   
   public void displayList() {
       
       for (int i = 0; i < acctList.size(); i++) {
           acctList.get(i).display();
           System.out.println();
       }
   }
   
   public static void main(String[] args) {
       
       AccountList acctList1 = new AccountList();
       
       Account a1 = new Account("7777", "3001", "SAV", 500.00);
       Account a2 = new Account("8888", "3002", "CHK", 700.00);
       
       acctList1.addAcct(a1);
       acctList1.addAcct(a2);
       
       acctList1.displayList();
   }
}
