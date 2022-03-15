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
import javax.servlet.RequestDispatcher;
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
    private static final String ADMINDASHBOARD = "admin_home_page.jsp";
    private static final String ADMINSTUDENT = "adminStudent.jsp";
    private static final String ADMINEVENT = "adminEvent.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<UserDTO> listUserInit = null;
        List<EventDTO> listEventInit = null;
        String url = ADMINDASHBOARD;
        try {
            UserDAO userDAO = new UserDAO();
            EventDAO eventDAO = new EventDAO();
            HttpSession ses = request.getSession();
            String searchUser = request.getParameter("txtSearchUser");
            String searchEvent = request.getParameter("txtSearchEvent");

            //paging for user
            int pageIndexStudent = 1;
            String indexStudent = request.getParameter("indexStudent");
            if ("".equals(indexStudent)) {
                indexStudent = null;
            }

            if (indexStudent == null) {
                indexStudent = "1";
            } else {
                pageIndexStudent = Integer.parseInt(indexStudent);
            }
            int countPageStudent = 0;

            //paging for event
            int pageIndexEvent = 1;
            String indexEvent = request.getParameter("indexEvent");
            if ("".equals(indexEvent)) {
                indexEvent = null;
            }

            if (indexEvent == null) {
                indexEvent = "1";
            } else {
                pageIndexEvent = Integer.parseInt(indexEvent);
            }

            int countPageEvent = 0;

            if (searchUser == null) {
                listUserInit = userDAO.getAllUser(pageIndexStudent);
                countPageStudent = userDAO.pagingUser();
            } else if (searchUser.equals("")) {
                url = ADMINSTUDENT;
                listUserInit = userDAO.getAllUser(pageIndexStudent);
                countPageStudent = userDAO.pagingUser();
            } else {
                url = ADMINSTUDENT;
                countPageStudent = userDAO.pagingUserBySearch(searchUser);
                listUserInit = userDAO.getUserByName(searchUser, pageIndexStudent);
            }

            if (searchEvent == null) {
                countPageEvent = eventDAO.pagingEvent();
                eventDAO.getAllEventForAdmin(pageIndexEvent);
                listEventInit = eventDAO.getListEvent();
            } else if (searchEvent.equals("")) {
                url = ADMINEVENT;
                countPageEvent = eventDAO.pagingEvent();
                eventDAO.getAllEventForAdmin(pageIndexEvent);
                listEventInit = eventDAO.getListEvent();
            } else {
                url = ADMINEVENT;
                countPageEvent = eventDAO.pagingEventBySearch(searchEvent);
                listEventInit = eventDAO.getEventByName(searchEvent, pageIndexEvent);
            }

            ses.setAttribute("currentPage", indexEvent);
            ses.setAttribute("currentStudent", indexStudent);

            System.out.println("pages std: " + countPageStudent);
            System.out.println("curr std: " + pageIndexStudent);

            ses.setAttribute("totalEvent", eventDAO.countTotalEvent());
            ses.setAttribute("totalUser", userDAO.countTotalUser());
            ses.setAttribute("initEvent", listEventInit);
            ses.setAttribute("initUser", listUserInit);

            //paing user
            ses.setAttribute("STUDENT_INDEX", pageIndexStudent);// current page
            ses.setAttribute("STUDENT_PAGE", countPageStudent);// number of page

            //paing event
            ses.setAttribute("EVENT_INDEX", pageIndexEvent);// current page
            ses.setAttribute("EVENT_PAGE", countPageEvent);// number of page

        } catch (Exception e) {
            LOGGER.error("Error at AdminController: " + e);
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
