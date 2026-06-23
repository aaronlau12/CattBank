<%-- 
    Document   : Loops
    Created on : Jun 22, 2026, 1:30:59 PM
    Author     : Aaron Lau
    Lab - Lab #7 - Simple JSPs
    Honor Statement - I promise that I wrote this code.
    I did not copy this code from someone else or the Internet
    And I did not use any AI Tools to Generate this code.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business.Account"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Account</title>
        
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%
            Account a1 = (Account)session.getAttribute("Account");
        %>
        
        <form action="AccountLookupServlet" method="post">
            
            
            <div class="imgcontainer">
                <img src="img.jpg" alt="Bank" width="400" class="avatar">
            </div>
            
            <div class="container">
                
                <div>
                    <label><b>Account Number</b></label>
                    <input type="text"
                           placeholder="Enter Account Number"
                           name="acctNoText"
                           value="<%=a1.getAcctNo() %>">
                </div>
                
                <div>
                    <label><b>Customer ID</b></label>
                    <input type="text"
                           placeholder="Enter Customer ID"
                           name="custIdText"
                           value="<%=a1.getCustId() %>">
                </div>
                
                <div>
                    <label><b>Type</b></label>
                    <input type="text"
                           placeholder="Enter Type"
                           name="typeText"
                           value="<%=a1.getType() %>">
                </div>
                
                <div>
                    <label><b>Balance</b></label>
                    <input type="text"
                           placeholder="Enter Balance"
                           name="balanceText"
                           value="<%=a1.getBalance() %>">
                </div>
                
                
            </div>
        </form>
    </body>
</html>
