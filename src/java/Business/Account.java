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

public class Account {
    //properties
    private String acctNo;
    private String custId;
    private String type;
    private double balance;
    
    //constructors
    public Account() {
        acctNo = "";
        custId = "";
        type = "";
        balance = 0.0;
    }//end
    
    public Account(String acctNo,
            String custId,
            String type,
            double balance) {
        
        this.acctNo = acctNo;
        this.custId = custId;
        this.type = type;
        this.balance = balance;
    }//end 
    
    //set methods
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }
    
    public void setCustId(String custId) {
        this.custId = custId;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    //get methods
    public String getAcctNo() {
        return acctNo;
    }
    
    public String getCustId() {
        return custId;
    }
    
    public String getType() {
        return type;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void selectAcct(String acctNo) {
        try {
            //load driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver loaded.");
            
            //get connection
            Connection conn = 
                    DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\aaron\\Desktop\\Summer 2026\\Java III\\ChattBankMDB.mdb");
            
            //sql statement
            String select = "SELECT * FROM Accounts WHERE AcctNo = ?";
            
            PreparedStatement prepared = conn.prepareStatement(select);
            
            prepared.setString(1,acctNo);
            
            ResultSet rs = prepared.executeQuery();
            System.out.println("Query Executed.");
            
            if (rs.next()) {
                System.out.println("Account found.");
                this.acctNo = rs.getString("AcctNo");
                this.custId = rs.getString("Cid");
                this.type = rs.getString("Type");
                this.balance = rs.getDouble("Balance");
            }
            
            else {
                System.out.println("Account not found.");
            }
            
            rs.close();
            prepared.close();
            conn.close();
        }
        
        catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        
        catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception: " + ex.getMessage());
        }
    }//end select
    
    public void insertAcct(String acctNo,
            String custId,
            String type,
            double balance) {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver loaded.");
            
            Connection conn =
                    DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\aaron\\Desktop\\Summer 2026\\Java III\\ChattBankMDB.mdb");
            
            String insert = "INSERT INTO Accounts (AcctNo, Cid, Type, Balance) "
                    + "VALUES (?, ?, ?, ?)";
            
            PreparedStatement prepared = conn.prepareStatement(insert);
            
            prepared.setString(1, acctNo);
            prepared.setString(2, custId);
            prepared.setString(3, type);
            prepared.setDouble(4, balance);
            
            int rows = prepared.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Insert executed.");
                this.acctNo = acctNo;
                this.custId = custId;
                this.type = type;
                this.balance = balance;
            }
            else {
                System.out.println("Insert failed.");
            }
            
            prepared.close();
            conn.close();
        }
        
        catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        
        catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception: " + ex.getMessage());
        }
    }//end insert
    
    public void updateAcct() {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver loaded.");
            
            Connection conn =
                    DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\aaron\\Desktop\\Summer 2026\\Java III\\ChattBankMDB.mdb");
            
            String update = "UPDATE Accounts " 
                    + "SET Cid = ?, Type = ?, Balance = ? "
                    + "WHERE AcctNo = ?";
                    
            PreparedStatement prepared = conn.prepareStatement(update);
            
            prepared.setString(1, this.custId);
            prepared.setString(2, this.type);
            prepared.setDouble(3, this.balance);
            prepared.setString(4, this.acctNo);
            
            int rows = prepared.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Update executed.");
            }
            else {
                System.out.println("Update failed.");
            }
            
            prepared.close();
            conn.close();
        }
  
        catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        
        catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception: " + ex.getMessage());
        }
    }//end update
    
    public void deleteAcct() {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            System.out.println("Driver loaded.");
            
            Connection conn =
                    DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\aaron\\Desktop\\Summer 2026\\Java III\\ChattBankMDB.mdb");
            
            String delete = ("DELETE FROM Accounts WHERE AcctNo = ?");
            
            PreparedStatement prepared = conn.prepareStatement(delete);
            
            prepared.setString(1, this.acctNo);
            
            int rows = prepared.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Delete executed.");
            }
            
            else {
                System.out.println("Delete failed.");
            }
            
            prepared.close();
            conn.close();
        }
        
        catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        
        catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception: " + ex.getMessage());
        }
    }//end delete
    
    public void display() {
        System.out.println("Account Number:             " + getAcctNo());
        System.out.println("Customer ID:                " + getCustId());
        System.out.println("Account Type:               " + getType());
        System.out.println("Balance:                    " + getBalance());
    }
    
    public static void main(String[] args) {
        Account a1 = new Account();
        a1.selectAcct("90000");
        a1.display();
    }//end main
}//end class
