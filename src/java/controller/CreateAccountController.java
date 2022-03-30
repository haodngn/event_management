/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import dto.UserErrorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateAccountController", urlPatterns = {"/CreateAccountController"})
public class CreateAccountController extends HttpServlet {
    
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(CreateAccountController.class);
    
    private static final String CREATE_PAGE = "createAdminAccount.jsp";
    private static final String ADMIN_PAGE = "AdminController";

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
        
        String url = CREATE_PAGE;
        
        String name = request.getParameter("txtName");
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        String phone = request.getParameter("txtPhone");
        
        String txtGender = request.getParameter("txtGender");
        boolean gender = true;
        if(txtGender.equals("male")){
            gender = true;
        }else{
            gender = false;
        }
        
        String txtRoleID = request.getParameter("txtRole");
        int role = 3;
        if(txtRoleID.equals("admin")){
            role = 3;
        }else if(txtRoleID.equals("eventDep")){
            role = 2;
        }
        
        try {
            String regex = "^[0-9\\-\\+]{9,15}$";
            
            UserErrorDTO err = new UserErrorDTO();
            boolean foundErr = false;
            
            if(password.length() < 6 || password.length() > 15){
                foundErr = true;
                err.setPasswordErr("Password required 6 - 15 character !!");
            }
            
            if(!phone.matches(regex)){
                foundErr = true;
                err.setPhoneErr("Invalid phone number !!");
            }
            
            if(foundErr){
                request.setAttribute("USER_ERR", err);
            }else{
                UserDAO uDAO = new UserDAO();
                boolean check = uDAO.createManagerAccount(name, email, password, role, phone, gender);
                if(check){
                    request.setAttribute("CREATE_SUCCESS", "Create Account Success");
                    url = ADMIN_PAGE;
                }
            }
        } catch (SQLException ex) {
            LOGGER.error("SQLException at CreateAccountController: " + ex);
        } catch (ClassNotFoundException ex) {
            LOGGER.error("ClassNotFoundException at CreateAccountController: " + ex);
        } catch (NamingException ex) {
            LOGGER.error("NamingException at CreateAccountController: " + ex);
        } catch (MessagingException ex) {
            LOGGER.error("MessagingException at CreateAccountController: " + ex);
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
