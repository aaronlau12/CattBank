package Business;

/**************************************************************************************************
Author: Aaron Lau
Course: CIST 2373 - Java Programming III
Lab - Lab #6 - More Servlets
Honor Statement - I promise that I wrote this code.
I did not copy this code from someone else or the Internet
And I did not use any AI Tools to Generate this code.
***************************************************************************************************/

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/AccountLookupServlet"})
public class AccountLookupServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String acctNo = request.getParameter("acctNoText");
        
        Account a1 = new Account();
        a1.selectAcct(acctNo);
        a1.display();
        
        HttpSession sess1 = request.getSession();
        sess1.setAttribute("Account", a1);
        System.out.println("Account added to session");
        
        RequestDispatcher rd1 = 
                request.getRequestDispatcher("DisplayAccount.jsp");
        
        rd1.forward(request,response);

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
