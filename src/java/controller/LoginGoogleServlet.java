/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.GooglePojo;
import common.GoogleUtils;
import dao.UserDAO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.mail.MessagingException;
import org.apache.log4j.Logger;
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
 * @author HAO
 */
@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginGoogleServlet.class);
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS = "SearchEventController";
    private static final String ERROR = "login.jsp";
    
    private final String DEFAULT_PASSWORD = "123456";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        String url = ERROR;
        
        try {
            String code = request.getParameter("code");
            HttpSession session = request.getSession();
            if (code == null || code.isEmpty()) {
                RequestDispatcher dis = request.getRequestDispatcher(ERROR);
                dis.forward(request, response);
            } else {
                String accessToken = GoogleUtils.getToken(code);
                GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
                String name = null;
                String email = googlePojo.getEmail();
                String picture = googlePojo.getPicture();
                String password = DEFAULT_PASSWORD;

                //get name
                if(googlePojo.getName() == null){
                    name = googlePojo.getEmail().split("@")[0];
                }

                UserDAO dao = new UserDAO();
                UserDTO user = dao.checkLogin(email, password);
                
                if(user == null){
                    dao.createAccount(name, email, password, 1, picture);
                }
                session.setAttribute("USER", user);
                
                url = SUCCESS;

            }
        } catch (NoSuchAlgorithmException ex) {
            LOGGER.error("NoSuchAlgorithmException at GoogleLoginServlet: "+ex);
        } catch (SQLException ex) {
            LOGGER.error("SQLException at GoogleLoginServlet: "+ex);
        } catch (NamingException ex) {
            LOGGER.error("NamingException at GoogleLoginServlet: "+ex);
        } catch (ClassNotFoundException ex) {
            LOGGER.error("ClassNotFoundException at GoogleLoginServlet: "+ex);
        } catch (MessagingException ex) {
            LOGGER.error("MessagingException at GoogleLoginServlet: "+ex);
        }finally{
            response.sendRedirect(url);
            out.close();
        }
        
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
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
