/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.EventDAO;
import java.io.IOException;
import java.sql.Date;
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
 * @author MSI
 */
public class RegisterEventController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(RegisterEventController.class);
    private final String DETAIL_CONTROLLER = "GetDetailEventController";
    private final String ERROR = "error.jsp";

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
        
        String url = DETAIL_CONTROLLER;
        
        try {
            int userID = Integer.parseInt(request.getParameter("txtUserID"));
            int eventID = Integer.parseInt(request.getParameter("txtEventID"));
            String email = request.getParameter("txtEmail");
            String code = MyUtils.getRandomCode();// get random code 6 number
            long millis = System.currentTimeMillis();
            String message = null;
            Date date = new Date(millis);
            EventDAO eventDAO = new EventDAO();
            if (!eventDAO.checkRegistedEvent(userID, eventID)) {
                if (eventDAO.registerEvent(userID, eventID, date, code)) {
                    eventDAO.updateStudentCount(eventID);
                    JavaMailUtils.sendMail(email, code);
                    message = "Register successfully! Check your mail to get checkin code";

                    url = "GetDetailEventController?txtId="+eventID;
                }
            }
            request.setAttribute("EVENT_ID", eventID);
            request.setAttribute("message", message);
        } catch (Exception e) {
            LOGGER.error("Error at RegisterEventController: " + e);
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
