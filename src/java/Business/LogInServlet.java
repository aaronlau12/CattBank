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

@WebServlet(urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            response.setContentType("text/html;charset=UTF-8");
        
            String user = request.getParameter("usernameText");
            String pass = request.getParameter("passwordText");
            
            String dbPass;
            
            Customer c1 = new Customer();
            c1.selectDb(user);
            
            dbPass = c1.getCustPass();
            
            HttpSession sesh1 = request.getSession();
            sesh1.setAttribute("Customer", c1);
            System.out.println("Customer added to Session");

            if (!c1.getCustId().isEmpty() && dbPass.equals(pass)) {
                
                RequestDispatcher rd1 = 
                        request.getRequestDispatcher("AccountLookup.jsp");
                
                rd1.forward(request, response);
            }//end if

            else {
                
                RequestDispatcher rd2 =
                        request.getRequestDispatcher("LogInError.jsp");
                
                rd2.forward(request, response);
            }//end else
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
