package Business;

/**************************************************************************************************
Author: Aaron Lau
Course: CIST 2373 - Java Programming III
Lab - Lab #4 - Business Objects
Honor Statement - I promise that I wrote this code.
I did not copy this code from someone else or the Internet
And I did not use any AI Tools to Generate this code.
***************************************************************************************************/
import Business.AccountList;
import Business.Account;
import java.sql.*;

public class Customer {
    //properties
    private String custId;
    private String custPass;
    private String custFirst;
    private String custLast;
    private String custAddress;
    private String custEmail;
    private AccountList aList = new AccountList();
    
    //constructors
    public Customer() {
        custId = "";
        custPass = "";
        custFirst = "";
        custLast = "";
        custAddress = "";
        custEmail = "";
    }
    
    //constructor with parameters
    public Customer(String custId,
            String custPass,
            String custFirst,
            String custLast,
            String custAddress,
            String custEmail) {
        
        this.custId = custId;
        this.custPass = custPass;
        this.custFirst = custFirst;
        this.custLast = custLast;
        this.custAddress = custAddress; 
        this.custEmail = custEmail;
    }
    
    //set methods
    public void setCustId(String custId) {
        this.custId = custId;
    }
    
    public void setCustPass(String custPass) {
        this.custPass = custPass;
    }
    
    public void setCustFirst(String custFirst) {
        this.custFirst = custFirst;
    }
    
    public void setCustLast(String custLast) {
        this.custLast = custLast;
    }
    
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }
    
    //get methods
    public String getCustId() {
        return custId;
    }
    
    public String getCustPass() {
        return custPass;
    }
    
    public String getCustFirst() {
        return custFirst;
    }
    
    public String getCustLast() {
        return custLast;
    }
    
    public String getCustAddress() {
        return custAddress;
    }
    
    public String getCustEmail() {
        return custEmail;
    }
    
    public AccountList getAccounts() {
        AccountList accountList = new AccountList();

        try {
            
            Connection conn = DBConnection.getConnection();
            
            String sql = "SELECT * FROM Accounts WHERE Cid = ?";
            
            PreparedStatement prepared = conn.prepareStatement(sql);
            
            prepared.setString(1, this.custId);
            
            ResultSet rs = prepared.executeQuery();
            System.out.println("Query Executed.");
            
            while (rs.next()) {
                String acctNo = rs.getString("AcctNo");
                
                Account acct = new Account();
                acct.selectAcct(acctNo);
                
                accountList.addAcct(acct);
            }
            
            prepared.close();
            conn.close();
        }
        
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return accountList;
    }//end getAccounts
    
    public void selectDb(String custId) {
        try {
            Connection conn = DBConnection.getConnection();
            
            //sql statement
            String select = "SELECT * FROM Customers WHERE CustID = ?";
            
            //prepared statement
            PreparedStatement prepared = conn.prepareStatement(select);
            
            prepared.setString(1, custId);
            
            ResultSet rs = prepared.executeQuery();
            System.out.println("Query Executed.");
            
            if (rs.next()) {
                System.out.println("Customer found.");
                this.custId = rs.getString("CustID");
                this.custPass = rs.getString("CustPassword");
                this.custFirst = rs.getString("CustFirstName");
                this.custLast = rs.getString("CustLastName");
                this.custAddress = rs.getString("CustAddress");
                this.custEmail = rs.getString("CustEmail");
                
                this.aList = getAccounts();
            }
            
            else {
                System.out.println("Customer not found.");
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
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//end select
    
    public void insertDb(String custId,
            String custPass,
            String custFirst,
            String custLast,
            String custAddress,
            String custEmail) {
        
        try {
            Connection conn = DBConnection.getConnection();
           
            String insert = "INSERT INTO Customers (CustID, CustPassword, CustFirstName, CustLastName, CustAddress, CustEmail) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement prepared = conn.prepareStatement(insert);
            
            prepared.setString(1, custId);
            prepared.setString(2, custPass);
            prepared.setString(3, custFirst);
            prepared.setString(4, custLast);
            prepared.setString(5, custAddress);
            prepared.setString(6, custEmail);
            
            int rows = prepared.executeUpdate();
            
            if (rows > 0) {
                this.custId = custId;
                this.custPass = custPass;
                this.custFirst = custFirst;
                this.custLast = custLast;
                this.custAddress = custAddress;
                this.custEmail = custEmail;
                System.out.println("Insert Statement Executed.");
            }
            
            prepared.close();
            conn.close();
        }//end try
        
        catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        }
        
        catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception: " + ex.getMessage());
        }
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//end insert
    
    public void updateDb() {
        try {
            Connection conn = DBConnection.getConnection();
            
            String update = "UPDATE Customers "
                    + "SET CustPassword = ?, CustFirstName = ?, CustLastName = ?, CustAddress = ?, CustEmail = ? "
                    + "WHERE CustID = ?";
            
            PreparedStatement prepared = conn.prepareStatement(update);
            
            prepared.setString(1, this.custPass);
            prepared.setString(2, this.custFirst);
            prepared.setString(3, this.custLast);
            prepared.setString(4, this.custAddress);
            prepared.setString(5, this.custEmail);
            prepared.setString(6, this.custId);
            
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
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//end update
    
    public void deleteDb() {
        try {
            Connection conn = DBConnection.getConnection();
            
            String delete = "DELETE FROM Customers WHERE CustID = ?";
            
            PreparedStatement prepared = conn.prepareStatement(delete);
            
            prepared.setString(1, this.custId);
            
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
        
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//end delete
    
    public void display() {
        System.out.println("Customer ID:                " + getCustId());
        System.out.println("Customer Password:          " + getCustPass());
        System.out.println("Customer First Name:        " + getCustFirst());
        System.out.println("Customer Last Name:         " + getCustLast());
        System.out.println("Customer Address:           " + getCustAddress());
        System.out.println("Customer Email:             " + getCustEmail());
        aList.displayList();
    }
    
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.selectDb("3002");
        c1.display();
        
        Customer c2 = new Customer();
        c2.insertDb("7777", "3333", "Merab", "Dvalishvili", "Georgia", "merab@gmail.com");
        c2.display();
        
        c2.deleteDb();
        
    }//end main
}//end class
