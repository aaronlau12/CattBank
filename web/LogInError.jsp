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
    <%@page import="Business.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In Error</title>
        
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <%
            Customer c1 = (Customer)session.getAttribute("Customer");
            
            if (c1 != null) {
                c1.display();
                
                out.println("<h1>Error Logging in for User "
                        + c1.getCustId()
                        + " </h1>");
            }
            else {
                out.println("<h1>Error Logging In</h1>");
            }
        %>
        
    </body>
</html>
