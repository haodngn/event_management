/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventDAO;
import dto.EventDTO;
import dto.EventErrorDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HAO
 */
public class UpdateEventController extends HttpServlet {
    private final String HOME_PAGE = "home_page.jsp";
    private final String UPDATE_PAGE = "update_event.jsp";
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
        String url = UPDATE_PAGE;
        try {
            boolean checkErr = true;
            EventErrorDTO errorDTO = new EventErrorDTO();
            
            String speaker = request.getParameter("txtSpeaker");
            if (speaker.isEmpty()) {
                checkErr = false;
                errorDTO.setIsEmpty("Speaker can not be empty");
            }
            if (speaker.length() <= 6) {
                checkErr = false;
                errorDTO.setSpeakerLength("Speaker can not be less than 6 characters");
            }
            
            String eventName = request.getParameter("txtEventName");
            if (eventName.isEmpty()) {
                checkErr = false;
                errorDTO.setIsEmpty("Name can not be empty");
            }
            if (eventName.length() <= 6) {
                checkErr = false;
                errorDTO.setNameLength("Name can not be less than 6 characters");
            }
            
            String description = request.getParameter("txtDescription");
            if (description.isEmpty()) {
                checkErr = false;
                errorDTO.setIsEmpty("Description can not be empty");
            }
            if (description.length() <= 6) {
                checkErr = false;
                errorDTO.setDesLength("Description can not be less than 20 characters");
            }
            
            String location = request.getParameter("txtLocation");
            if (location.isEmpty()) {
                checkErr = false;
                errorDTO.setIsEmpty("Location can not be empty");
            }
            
            //conver string to date(util) to compare
            String occurDate = request.getParameter("txtOccurDate");
            String endDate = request.getParameter("txtEndDate");
            String registerDate = request.getParameter("registerDate");
            String expirationDate = request.getParameter("txtExpirationDate");
            
            Date occur = new SimpleDateFormat("MM-dd-yyyy").parse(occurDate);
            Date exp = new SimpleDateFormat("MM-dd-yyyy").parse(expirationDate);
            Date regist = new SimpleDateFormat("MM-dd-yyyy").parse(registerDate);
            Date end = new SimpleDateFormat("MM-dd-yyyy").parse(endDate);
            
            //expirationDate < RegisterDate
            if(exp.before(regist)){ 
                checkErr = false;
                errorDTO.setExpDateCheck("Expiration date must after Register date !!");
            }
            
            //RegisterDate > ExpirationDate
            if(regist.after(exp)){
                checkErr = false;
                errorDTO.setRegisterDateCheck("Register date must before Expiration date !!");
            }
            
            //Occur Date > End date
            if(occur.after(end)){
                checkErr = false;
                errorDTO.setOccurDateCheck("Occur date must before End date !!");
            }
            
            //End date < Occur Date
            if(end.before(occur)){
                checkErr = false;
                errorDTO.setEndDateCheck("End date must after Occur date !!");
            }
            
            //Occur Date < Exp Date
            if(occur.before(exp)){
                checkErr = false;
                errorDTO.setOccurDateCheck("Occur date must after Expiration date !!");
            }
            
            //Exp Date > Occur Date
            if(exp.after(occur)){
                checkErr = false;
                errorDTO.setExpDateCheck("Expiration date must before Occur date !!");
            }
            
            EventDAO eventDAO = new EventDAO();
            if (checkErr) {
                HttpSession session = request.getSession();
                session.removeAttribute("IMG");
                EventDTO eventDTO = new EventDTO(speaker, eventName, occurDate, endDate, registerDate, expirationDate, description, location);
                if (eventDAO.updateEvent(eventDTO)) {
                    url = HOME_PAGE;
                }
            } else {
                url = UPDATE_PAGE;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
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
