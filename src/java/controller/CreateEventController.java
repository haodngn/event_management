/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tinnt.error.CreateEventError;

/**
 *
 * @author Admin
 */
public class CreateEventController extends HttpServlet {
    private final String ADD_PAGE = "create_event.jsp";
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
        
        String url = ADD_PAGE;
        
//        String carID = request.getParameter("txtID");
        String speaker = request.getParameter("txtSpeaker");
        String eventName = request.getParameter("txtEventName");
        String occurDate = request.getParameter("txtOccurDate");
        String endDate = request.getParameter("txtEndDate");
        String registerDate = request.getParameter("registerDate");
        String expirationDate = request.getParameter("txtExpirationDate");
        int studentCount = Integer.parseInt(request.getParameter("txtStudentCount"));
        String description = request.getParameter("txtDescription");
        String location = request.getParameter("txtLocation");
        int prosted_by = Integer.parseInt(request.getParameter("txtPostedBy"));
        int postId = Integer.parseInt(request.getParameter("txtPostId"));
        
        CreateEventError err = new CreateEventError();
        boolean foundErr = false;
        try {
            if(speaker == null || eventName == null || occurDate == null || endDate == null || registerDate == null || expirationDate == null
                    ||description == null || location == null){
                foundErr = true;
                err.setIsEmpty("Field is empty !");
            }
            
            if(foundErr){
                request.setAttribute("CREATE_ERR", err);
            }else{
                EventDAO dao = new EventDAO();
                int maxid = dao.getMaxId();
                int id = maxid + 1;
                System.out.println("id: " +id);
                boolean result = dao.createEvent(id, speaker, eventName, occurDate, endDate, registerDate, expirationDate, studentCount, description, location, prosted_by, postId);
                if(result){
                    request.setAttribute("CREATE_SUCCESS", "Create success !");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateEventController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateEventController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CreateEventController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CreateEventController.class.getName()).log(Level.SEVERE, null, ex);
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
