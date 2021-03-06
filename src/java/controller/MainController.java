/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HAO
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
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
    private static final String LOGOUT = "LogoutController";
    private static final String CREATE_FEEDBACK = "CreateFeedbackController";
    private static final String ERROR = "invalid.jsp";
    private static final String PAYMENT = "AuthorizePaymentServlet";
    private static final String PAYMENT_ACCOUNT = "CreatePaymentAccountController";

    private static final String PROFILE = "ProfileController";
    private static final String ENTER_EDIT_PROFILE = "edit_profile.jsp";
    private static final String EDIT_PROFILE = "EditProfileController";
    private static final String DEATIL_EVENT = "GetDetailEventController";

    private static final String SEARCH_EVENT = "SearchEventController";
    private static final String CREATE_EVENT = "CreateEventController";
    private static final String DETAIL_EVENT = "GetDetailEventController";
    private static final String UPDATE_EVENT = "UpdateEventController";
    private static final String DELETE_EVENT = "DeleteEventController";

    private static final String REGISTER_EVENT = "RegisterEventController";
    private static final String CANCEL_EDIT_PROFILE = "profile_page.jsp";
    private static final String ADMIN = "AdminController";
    private static final String USERSTATUS = "UserStatusController";
    private static final String DELETECOMMENT = "DeleteCommentController";
    private static final String TAKEATTEND = "TakeAttendanceController";
    private static final String CREATEADMINACCOUNT = "createAdminAccount.jsp";

    private static final String CREATEMANAGERACCOUNT = "CreateAccountController";

    private static final String CLOSEEVENT = "CloseEventController";
    private static final String LIST_STUDENT = "GetListStudentController";


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
                url = CREATE_EVENT;
            } else if (action.equals("Search event") || action.equals("Search") || action.equals("Back to home") || action.equals("manage")) {
                url = SEARCH_EVENT;
            } else if (action.equals("detail event") || action.equals("Edit") || action.equals("EDIT")) {
                url = DETAIL_EVENT;
            } else if (action.equals("Edit Event")) {
                url = UPDATE_EVENT;
            } else if (action.equals("Delete")) {
                url = DELETE_EVENT;
            } else if (action.equals("Feedback")) {
                url = CREATE_FEEDBACK;
            } else if (action.equals("Profile")) {
                url = PROFILE;
            } else if (action.equals("Edit Profile")) {
                url = ENTER_EDIT_PROFILE;
            } else if (action.equals("Save Profile")) {
                url = EDIT_PROFILE;
            } else if (action.equals("Checkout")) {
                url = PAYMENT;
            } else if (action.equals("Register")) {
                url = REGISTER_EVENT; //PAYMENT_ACCOUNT
            } else if (action.equals("Payment Account") || action.equals("Return Home")) {
                url = PAYMENT_ACCOUNT;
            } else if (action.equals("Cancel")) {
                url = CANCEL_EDIT_PROFILE;
            } else if (action.equals("Admin")) {
                url = ADMIN;
            } else if (action.equals("Unban User") || action.equals("Ban User")) {
                url = USERSTATUS;
            } else if (action.equals("DeleteComment")) {
                url = DELETECOMMENT;
            } else if (action.equals("EDIT")) {
                url = DEATIL_EVENT;
            } else if (action.equals("takeAttend")) {
                url = TAKEATTEND;
            } else if (action.equals("CreateAdminAccount")) {
                url = CREATEADMINACCOUNT;
            } else if (action.equals("createManagerAccount")) {
                url = CREATEMANAGERACCOUNT;
            } else if (action.equals("CLOSE")) {
                url = CLOSEEVENT;
            } else if (action.equals("CHECK")) {
                url = LIST_STUDENT;
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
