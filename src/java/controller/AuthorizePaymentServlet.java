/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.paypal.base.rest.PayPalRESTException;
import common.PaymentServices;
import dao.PaymentDAO;
import dto.OrderDetail;
import dto.PaymentDTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HAO
 */
public class AuthorizePaymentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AuthorizePaymentServlet() {
    }

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        // paypal bug
        int id = Integer.parseInt(request.getParameter("EventID"));
        PaymentDAO paymentd = new PaymentDAO();
        PaymentDTO payment = paymentd.getPaymentByEventID(id);

        HttpSession ses = request.getSession();
        ses.setAttribute("payment_Id", payment.getPaymentID());
        ses.setAttribute("price", payment.getPrice());
        ses.setAttribute("currentEventID", id);

        float pricef = payment.getPrice();
        String prices = String.valueOf(pricef);
        String product = String.valueOf(id);
        String subtotal = prices;
        String shipping = "0";
        String tax = "0";

        float shippingf = Float.valueOf(shipping);
        float taxf = Float.valueOf(tax);
        float totalf = shippingf + taxf + pricef;

        String totals = String.valueOf(totalf);

        OrderDetail orderDetail = new OrderDetail(product, subtotal, shipping, tax, totals);
        try {

            PaymentServices paymentServices = new PaymentServices();
            String approvalLink = paymentServices.authorizePayment(orderDetail);
            response.sendRedirect(approvalLink);

        } catch (PayPalRESTException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("invalid.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AuthorizePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AuthorizePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AuthorizePaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
