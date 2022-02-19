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
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
@WebServlet(name = "GetDetailEventController", urlPatterns = {"/GetDetailEventController"})
public class GetDetailEventController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(GetDetailEventController.class);

    private final String UPDATE_PAGE = "update_event.jsp";
    private final String STUDENT_EVENT_DETAIL = "detail_event.jsp";

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

        String url = UPDATE_PAGE;

        try {
            HttpSession ses = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));

            EventDAO dao = new EventDAO();
            EventDTO dto = dao.getEventByID(id);
            if (dto != null) {
                UserDTO user = (UserDTO) ses.getAttribute("USER");
                if (user.getRoleID() == 1) {
                    url = STUDENT_EVENT_DETAIL; //student home
                } else if (user.getRoleID() == 2) {
                    url = UPDATE_PAGE; //dep event
                }
                request.setAttribute("EVENT", dto);// Detai Event
                request.setAttribute("EVENT_ID", id);
            }

        } catch (SQLException ex) {
            LOGGER.error("SQLException at GetDetailEventController: " + ex);
        } catch (ClassNotFoundException ex) {
            LOGGER.error("ClassNotFoundException at GetDetailEventController: " + ex);
        } catch (NamingException ex) {
            LOGGER.error("NamingException at GetDetailEventController: " + ex);
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
