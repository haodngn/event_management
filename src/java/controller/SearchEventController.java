/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventDAO;
import dto.EventDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SearchEventController", urlPatterns = {"/SearchEventController"})
public class SearchEventController extends HttpServlet {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(SearchEventController.class);

    private final String HOME_PAGE = "home_page.jsp";
    private final String STUDENT_HOME_PAGE = "student_home_page.jsp";
    private final String EVENT_DEV = "event_dev.jsp";

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
        PrintWriter out = response.getWriter();

        int pageIndex = 1;
        String index = request.getParameter("index");
        String searchName = request.getParameter("txtSearchValue");
        String eventDev = request.getParameter("btnEventDev");
        
        if (searchName == null) {
            searchName = "";
        }
        if (eventDev == null) {
            eventDev = "";
        }
        if ("".equals(index)) {
            index = null;
        }
        if (index != null) {
            pageIndex = Integer.parseInt(index);
        }
        int countPage = 1;

        String url = HOME_PAGE;

        try {
            HttpSession ses = request.getSession();
            EventDAO eventDAO = new EventDAO();
            List<EventDTO> listEvent = null;

            if (searchName.equals("") && eventDev.equals("")) {

                countPage = eventDAO.pagingGetAll();
                eventDAO.getAll(pageIndex);
                listEvent = eventDAO.getListEvent();
            } else if(eventDev.equals("eventDev")) {
                countPage = eventDAO.pagingGetAll();
                eventDAO.getAllForDep(pageIndex);
                listEvent = eventDAO.getListEvent();
            } else{
                countPage = eventDAO.pagingEventBySearch(searchName);
                eventDAO.getBySearch(searchName, pageIndex);
                listEvent = eventDAO.getListEvent();
            }
            UserDTO dto = (UserDTO) ses.getAttribute("USER");
            if (dto.getRoleID() == 1) {
                url = STUDENT_HOME_PAGE; //student home
            } else if (dto.getRoleID() == 2) {
                if (eventDev.equals("eventDev")) {
                    url = EVENT_DEV;
                } else {
                    url = HOME_PAGE;
                }
            }

            request.setAttribute("listEvent", listEvent);//list Event
            request.setAttribute("page", countPage);//number of page 
            request.setAttribute("index", pageIndex);//current page
            
            System.out.println("url: "+url);

        } catch (SQLException ex) {
            LOGGER.error("SQLException at SearchEventController: " + ex);
        } catch (ClassNotFoundException ex) {
            LOGGER.error("ClassNotFoundException at SearchEventController: " + ex);
        } catch (NamingException ex) {
            LOGGER.error("NamingException at SearchEventController: " + ex);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
