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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
//import tinnt.error.CreateEventError;
import dto.EventErrorDTO;
import dto.UserDTO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CreateEventController extends HttpServlet {
    private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(CreateEventController.class);
    private final String ADD_PAGE = "SearchEventController";
    private final String ERROR = "create_event.jsp";
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
        
        String url = ERROR;

        String speaker = request.getParameter("txtSpeaker");
        String eventName = request.getParameter("txtEventName");
        String occurDate = request.getParameter("txtOccurDate");
        String endDate = request.getParameter("txtEndDate");
        String registerDate = request.getParameter("registerDate");
        String expirationDate = request.getParameter("txtExpirationDate");
        
        String description = request.getParameter("txtDescription");
        String location = request.getParameter("txtLocation");
        
        EventErrorDTO err = new EventErrorDTO();
        boolean foundErr = false;
        try {
            if(speaker.length() < 2 || speaker.length() > 50){
                foundErr = true;
                err.setSpeakerLength("Field is required 2 - 50 character !!");
            }
            
            if(eventName.length() < 3 || eventName.length() > 30){
                foundErr = true;
                err.setNameLength("Field is required 3 - 30 character !!");
            }
            
            if(description.length() < 3 || description.length() > 50){
                foundErr = true;
                err.setDesLength("Field is required 3 - 50 charater !!");
            }
            
            if(location.length() < 2 || location.length() > 20){
                foundErr = true;
                err.setLocationLength("Field is required 2 - 20 character !!");
            }
            
            //conver string to date(util) to compare
            Date occur = new SimpleDateFormat("MM-dd-yyyy").parse(occurDate);
            Date exp = new SimpleDateFormat("MM-dd-yyyy").parse(expirationDate);
            Date regist = new SimpleDateFormat("MM-dd-yyyy").parse(registerDate);
            Date end = new SimpleDateFormat("MM-dd-yyyy").parse(endDate);
            
            //expirationDate < RegisterDate
            if(exp.before(regist)){ 
                foundErr = true;
                err.setExpDateCheck("Expiration date must after Register date !!");
            }
            
            //RegisterDate > ExpirationDate
            if(regist.after(exp)){
                foundErr = true;
                err.setRegisterDateCheck("Register date must before Expiration date !!");
            }
            
            //Occur Date > End date
            if(occur.after(end)){
                foundErr = true;
                err.setOccurDateCheck("Occur date must before End date !!");
            }
            
            //End date < Occur Date
            if(end.before(occur)){
                foundErr = true;
                err.setEndDateCheck("End date must after Occur date !!");
            }
            
            //Occur Date < Exp Date
            if(occur.before(exp)){
                foundErr = true;
                err.setOccurDateCheck("Occur date must after Expiration date !!");
            }
            
            //Exp Date > Occur Date
            if(exp.after(occur)){
                foundErr = true;
                err.setExpDateCheck("Expiration date must before Occur date !!");
            }

            
            if(foundErr){
                request.setAttribute("CREATE_ERR", err);
            }else{
                HttpSession sess = request.getSession();
                UserDTO user = (UserDTO) sess.getAttribute("USER");
                
                EventDAO dao = new EventDAO();
                boolean result = dao.createEvent(speaker, eventName, occurDate, endDate, registerDate, expirationDate, 0, description, location, user.getUserID());
                if(result){
                    url = ADD_PAGE;
                    request.setAttribute("CREATE_SUCCESS", "Create success !");
                }
            }
        } catch (SQLException ex) {
            LOGGER.error("SQLException at CreateEventController: "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            LOGGER.error("ClassNotFoundException at CreateEventController: "+ex.getMessage());
        } catch (NamingException ex) {
            LOGGER.error("NamingException at CreateEventController: "+ex.getMessage());
        } catch (ParseException ex) {
            LOGGER.error("ParseException at CreateEventController: "+ex.getMessage());
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
