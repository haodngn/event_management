/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HAO
 */
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String LOGIN = "LoginController";
    private static final String CREATE = "CreateController";
    private static final String ERROR = "invalid.jsp";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH = "NotiController";
    private static final String DETAIL = "DetailController";
    private static final String LIKE = "LikeController";
    private static final String DISLIKE = "DislikeController";
    private static final String DELETE = "DeleteController";
    private static final String COMMENT = "CommentController";
    private static final String DEL_CMT = "DelCommentController";
    private static final String POST = "PostController";
    private static final String NOTI_DETAIL = "NotiDetailController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("btnAction");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Logout")) {
                url = LOGOUT;
            } else if (action.equals("Create")) {
                url = CREATE;
            } else if (action.equals("Search article")) {
                url = SEARCH;
            } else if (action.equals("Detail")) {
                url = DETAIL;
            } else if (action.equals("Like")) {
                url = LIKE;
            } else if (action.equals("Dislike")) {
                url = DISLIKE;
            } else if (action.equals("Delete")) {
                url = DELETE;
            } else if (action.equals("Comment")) {
                url = COMMENT;
            } else if (action.equals("Delete cmt")) {
                url = DEL_CMT;
            } else if (action.equals("Post")) {
                url = POST;
            } else if (action.equals("Noti detail")) {
                url = NOTI_DETAIL;
            }
        } catch (Exception e) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, e);
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
