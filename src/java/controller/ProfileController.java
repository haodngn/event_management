/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventDAO;
import dao.UserDAO;
import dto.EventDTO;
import dto.UserDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thúy Bắc
 */
public class ProfileController extends HttpServlet {

    private static final String PROFILE_PAGE = "profile_page.jsp";
    private static final String PROFILE_DEV = "profile_dev.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = PROFILE_PAGE;
        try {
            HttpSession ses = request.getSession();
            String email = request.getParameter("email");
            String status = request.getParameter("status");
            System.out.println(email);
            UserDAO dao = new UserDAO();
            UserDTO dto = dao.getUserByEmail(email);
            System.out.println("user: " + dto.getUserID());
            EventDAO edao = new EventDAO();
            List<EventDTO> history = null;
            edao.getEventByStudentID(dto.getUserID());
            history = edao.getListEvent();
            
            if (status != null) {
                System.out.println("Status: " + status);
                ses.setAttribute("status", status);
            }
            if(ses.getAttribute("roleID") == "2") {
                url = PROFILE_DEV;
            }
            ses.setAttribute("userInfo", dto);
            ses.setAttribute("history", history);
            
            UserDTO u = (UserDTO) ses.getAttribute("USER");
            
            System.out.println("user: "+u.getRoleID());
            
        } catch (ClassNotFoundException | SQLException | NamingException e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
