/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventDAO;
import dao.PaymentDAO;
import dto.UserDTO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import utils.JavaMailUtils;
import utils.MyUtils;

/**
 *
 * @author HAO
 */
public class CreatePaymentAccountController extends HttpServlet {

    private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(CreateEventController.class);
    private final String DETAIL_EVENT = "SearchEventController";
    private final String FAIL = "invalid.jsp";

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
        String url = FAIL;
        try {
            HttpSession ses = request.getSession();
            EventDAO eventDAO = new EventDAO();
            UserDTO dto = (UserDTO) ses.getAttribute("USER");
            int payment_Id = (int) ses.getAttribute("payment_Id");
            int currentEventID = (int) ses.getAttribute("currentEventID");
            String code = MyUtils.getRandomCode();// get random code 6 number
            JavaMailUtils.sendMail(dto.getEmail(), code);
            long millis = System.currentTimeMillis();
            Date currentDate = new Date(millis);
            PaymentDAO paymentd = new PaymentDAO();

            boolean check = paymentd.createPaymentAccount(payment_Id, dto.getUserID(), "Completed") && eventDAO.registerEvent(dto.getUserID(), currentEventID, currentDate, code) && eventDAO.updateStudentCount(currentEventID);

            if (check) {
                url = DETAIL_EVENT;
            }
        } catch (SQLException ex) {
            LOGGER.error("SQLException at CreateFeedbackController: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            LOGGER.error("ClassNotFoundException at CreateFeedbackController: " + ex.getMessage());
        } catch (NamingException ex) {
            LOGGER.error("NamingException at CreateFeedbackController: " + ex.getMessage());
        } catch (MessagingException ex) {
            LOGGER.error("MessagingException at CreateFeedbackController: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
