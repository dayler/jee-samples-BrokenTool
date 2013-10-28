/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trader.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trader.BrokerDelegate;
import trader.Customer;

/**
 *
 * @author ariel
 */
public class CustomerController extends HttpServlet {

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
                BrokerDelegate delegate = BrokerDelegate.getInstance();
                String customerIdIdentity = request.getParameter("customerIdentity");
                String customerName = request.getParameter("customerName");
                String customerAddress = request.getParameter("customerAddress");
                String submit = request.getParameter("submit");
                Customer customer = null;
                String destination = "/CustomerDetails";

                if (submit.equalsIgnoreCase("Get Customer")) {
                    customer = BrokerDelegate.getInstance().getCustomer(customerIdIdentity);
                } else if (submit.equalsIgnoreCase("Update Customer")) {
                    BrokerDelegate.getInstance().updateCustomer(customerIdIdentity, customerName, customerAddress);
                    customer = BrokerDelegate.getInstance().getCustomer(customerIdIdentity);
                } else if (submit.equalsIgnoreCase("Add Customer")) {
                    BrokerDelegate.getInstance().addCustomer(customerIdIdentity, customerName, customerAddress);
                    customer = BrokerDelegate.getInstance().getCustomer(customerIdIdentity);
                } else if (submit.equalsIgnoreCase("Delete Customer")) {
                    BrokerDelegate.getInstance().deleteCustomer(customerIdIdentity);
                } else if (submit.equalsIgnoreCase("AllCustomers")) {
                    destination = "/AllCustomers.jsp";
                    Customer[] customers = BrokerDelegate.getInstance().getAllCustomers();
                    request.setAttribute("customers", customers);
                } else {
                    // No op
                }

                // request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
                request.setAttribute("Customer", customer);
                request.getRequestDispatcher(destination).forward(request, response);
        }
        catch (Throwable ex) {
          // No op  
        } finally {
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
