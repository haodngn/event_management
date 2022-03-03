/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.EventDAO;
import dao.UserDAO;
import dto.EventDTO;
import dto.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author MSI
 */
public class AdminController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AdminController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<UserDTO> listUserInit = null;
        List<EventDTO> listEventInit = null;
        try {
            UserDAO userDAO = new UserDAO();
            EventDAO eventDAO = new EventDAO();
            HttpSession ses = request.getSession();
            String searchUser = request.getParameter("txtSearchUser");
            String searchEvent = request.getParameter("txtSearchEvent");
            if (searchUser != null) {

            } else {
                // Get firts 5 Users
                listUserInit = userDAO.get5FirstUser();
            }

            if (searchEvent != null) {
                eventDAO.getEventByName(searchEvent);
                listEventInit = eventDAO.getListEvent();
                System.out.println("List Event Count: " + listEventInit.size());
            } else {
                // Get first 5 Events
                eventDAO.get5FirstEvent();
                listEventInit = eventDAO.getListEvent();
            }

            ses.setAttribute("initEvent", listEventInit);
            ses.setAttribute("initUser", listUserInit);
        } catch (Exception e) {
            LOGGER.error("Error at AdminController: " + e);
        } finally {
            request.getRequestDispatcher("admin_home_page.jsp").forward(request, response);
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
