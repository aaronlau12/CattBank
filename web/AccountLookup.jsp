<%-- 
Author: Aaron Lau
Course: CIST 2373 - Java Programming III
Lab - Lab #6 - More Servlets
Honor Statement - I promise that I wrote this code.
I did not copy this code from someone else or the Internet
And I did not use any AI Tools to Generate this code.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Look Up</title>
        <meta name="viewport" contents="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <form action="AccountLookupServlet" method="post">
            
            <div class="imgcontainer">
                <img src="img.jpg" alt="Bank" width="400" class="avatar">
            </div>
            
            <div class="container">
                
                <div>
                    <label><b>Account Number</b></label>
                    <input type="text"
                           placeholder="Enter Account Number"
                           name="acctNoText">
                </div>
                
                <div>
                    <label><b>Customer ID</b></label>
                    <input type="text"
                           placeholder="Enter Customer ID"
                           name="custIdText">
                </div>
                
                <div>
                    <label><b>Type</b></label>
                    <input type="text"
                           placeholder="Enter Type"
                           name="typeText">
                </div>
                
                <div>
                    <label><b>Balance</b></label>
                    <input type="text"
                           placeholder="Enter Balance"
                           name="balanceText">
                </div>
                
                <div>
                    <button type="submit">Look Up</button>
                    <button type="reset">Clear</button>
                </div>
                
            </div>
        </form>
    </body>
</html>
