/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trader.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trader.Customer;

/**
 *
 * @author ariel
 */
public class CustomerDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
      try {
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerDetails at " + request.getContextPath() + "</h1>");
            
            Object rawCustomer = request.getAttribute("Customer");
            Customer customer;
            
            if (rawCustomer == null) {
                customer = new Customer("", "", "");
            } else {
                customer = (Customer) rawCustomer;
            }
            
            out.println("<table border='1' cellpadding='4'>");
            // out.println("<tbody><tr><td><a href='CustomerDetails'>Customer Details</a></td><td><a href='AllCustomers.jsp'>All Customers</a></td><td><a href='Stocks.jsp'>Stocks</a></td></tr>");
            out.println("<tbody><tr><td><a href='CustomerDetails'>Customer Details</a></td><td><a href='CustomerController?submit=AllCustomers'>All Customers</a></td><td><a href='Stocks.jsp'>Stocks</a></td></tr>");
            out.println("</tbody></table>");
            out.println("<br/>");
            // Define de servlet to handle the buttons
            // out.println("<form action='${pageContext.request.contextPath}/CustomerController' method='get'>");
            out.println("<form action='CustomerController' method='get'>");
            out.println("<table border='1' cellpadding='4'>");
            out.println("<tbody><tr><td>Customer Name</td><td><input name='customerName' value=\'" + customer.getName() + "\' type='text'></td></tr>");
            out.println("<tr><td>Customer Identity</td><td><input name='customerIdentity' value=\'" + customer.getId() + "\' type='text'></td></tr>");
            out.println("<tr><td>Customer Address</td><td><input name='customerAddress' value=\'" + customer.getAddr() + "\' type='text'></td></tr>");
            out.println("<tr><td><input name='submit' value='Get Customer' type='submit'></td><td><input name='submit' value='Update Customer' type='submit'></td></tr>");
            out.println("<tr><td><input name='submit' value='Add Customer' type='submit'></td><td><input name='submit' value='Delete Customer' type='submit'></td></tr>");
            out.println("</tbody></table>");
            out.println("</form>");
            out.println("<br/>");

            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            // No op
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
