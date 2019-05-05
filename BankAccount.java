/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountsimulator;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 *
 * @author Tabish
 */
public class BankAccount {
    double balance; 
    String alias;
    String type; 
    int accountID; 
    
     
    
    
    
    public BankAccount(double acntAmount, String acntOwner, String acntTyp, int acntNum){
        balance = acntAmount;
        alias = acntOwner;
        type = acntTyp;
        accountID = acntNum;
        
        try { 
      
            // Step 1: Load the JDBC ODBC driver 
            Class.forName("org.apache.derby.jdbc.ClientDriver"); 

            // Step 2: Establish the connection to the database 
            String url = "jdbc:derby://localhost:1527/BankAccountsServer"; 
            Connection conn = DriverManager.getConnection(url,"tabish","rashidi1");  
      
            //Create a statement 
            Statement statement = conn.createStatement();

            // insert the data
            statement.executeUpdate("INSERT INTO TABISH.BANKACCOUNTS2 " + "VALUES (" + balance + "," + "'" + alias + "'" + "," + "'" + type + "'" + "," + accountID + ")");
        }
        
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            
            System.err.println(e.getMessage()); 
        } 
    }
    
    
    
    public double withdraw(int amount, int id){
        balance = balance - amount; 
        int custid = id;
        try { 
      
            // Step 1: Load the JDBC ODBC driver 
            Class.forName("org.apache.derby.jdbc.ClientDriver"); 

            // Step 2: Establish the connection to the database 
            String url = "jdbc:derby://localhost:1527/BankAccountsServer"; 
            Connection conn = DriverManager.getConnection(url,"tabish","rashidi1");  
      
            //Create a statement 
            Statement statement = conn.createStatement();

            // insert the data
            statement.executeUpdate("UPDATE TABISH.BANKACCOUNTS2 " + "SET BALANCE = " + balance + " WHERE ACCOUNTID = " + custid);
        }
        
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            
            System.err.println(e.getMessage()); 
        } 
        System.out.println("You have just withdrawn " + amount + " " + alias + "'s balance is now " + balance);
        return balance; 
    }
    
    public double deposit(int amount, int id){
        balance = balance + amount;
        int custid =id;
        
        try { 
      
            // Step 1: Load the JDBC ODBC driver 
            Class.forName("org.apache.derby.jdbc.ClientDriver"); 

            // Step 2: Establish the connection to the database 
            String url = "jdbc:derby://localhost:1527/BankAccountsServer"; 
            Connection conn = DriverManager.getConnection(url,"tabish","rashidi1");  
      
            //Create a statement 
            Statement statement = conn.createStatement();

            // insert the data
            statement.executeUpdate("UPDATE TABISH.BANKACCOUNTS2 " + "SET BALANCE = " + balance + " WHERE ACCOUNTID = " + custid);
        }
        
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            
            System.err.println(e.getMessage()); 
        } 
        System.out.println("You have just deposited " + amount + " " + alias + "'s balance is now " + balance);
        return balance; 
    }
    
    
    
    
    /*public double etransfer(double amount, String payee, int acntId, String question, String password){
        balance = balance - amount; 
        System.out.println("E-transfer complete to " + payee + " Account ID: " + acntId);
        System.out.println("Your Security Question is " + question + " With password " + password);
        System.out.println("Your balance is now " + balance);
        return amount; 
    }*/
    
    
    public double etransfer(double amount, BankAccount foo, int reciever, int sender, String question){
        balance = balance - amount; 
        foo.balance = foo.balance + amount;
        System.out.println("E-transfer complete to " + foo.alias + " Account ID: " + foo.accountID);
        System.out.println("Your Security Question is " + question);
        System.out.println("Current Balance (Sender): " + balance);
        System.out.println("Current Balance (Reciever): " + foo.balance);
        
        try { 
      
            // Step 1: Load the JDBC ODBC driver 
            Class.forName("org.apache.derby.jdbc.ClientDriver"); 

            // Step 2: Establish the connection to the database 
            String url = "jdbc:derby://localhost:1527/BankAccountsServer"; 
            Connection conn = DriverManager.getConnection(url,"tabish","rashidi1");  
      
            //Create a statement 
            Statement statement = conn.createStatement();

            // insert the data
            statement.executeUpdate("UPDATE TABISH.BANKACCOUNTS2 " + "SET BALANCE = " + foo.balance + " WHERE ACCOUNTID = " + reciever);
            statement.executeUpdate("UPDATE TABISH.BANKACCOUNTS2 " + "SET BALANCE = " + balance + " WHERE ACCOUNTID = " + sender);
        }
        
        catch (Exception e) { 
            System.err.println("Got an exception! "); 
            
            System.err.println(e.getMessage()); 
        } 
        
        return balance; 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BankAccount Jim = new BankAccount(1300.75, "Jim", "Savings", 122325);
        BankAccount Jeff = new BankAccount(13400.76, "Jeff", "Chequings", 122326);
        BankAccount Sally = new BankAccount(2000000, "Sally", "Line of Credit", 122327);
        Jim.etransfer(1300.75, Sally, 122327, 122325, "What is your middle name?");
    }
    
    
}


