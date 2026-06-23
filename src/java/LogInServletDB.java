/**************************************************************************************************
Author: Aaron Lau
Course: CIST 2373 - Java Programming III
Lab - Lab #3 - Servlets
Honor Statement - I promise that I wrote this code.
I did not copy this code from someone else or the Internet
And I did not use any AI Tools to Generate this code.
***************************************************************************************************/

import Business.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LogInServletDB"})
public class LogInServletDB extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            String userId, pass;
            String dbPass;
            
            userId = request.getParameter("usernameText");
            pass = request.getParameter("passwordText");
            
            Customer c1 = new Customer();
            c1.selectDb(userId);
            
            dbPass = c1.getCustPass();
            
            if (!c1.getCustId().equals("") && pass.equals(dbPass)) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Log In Servlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Welcome " + c1.getCustFirst() + " " + c1.getCustLast() +  "!" + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }//end if
            
            else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Log In Servlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Sorry. Wrong username or password.</h1>");
                out.println("</body>");
                out.println("</html>"); 
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
