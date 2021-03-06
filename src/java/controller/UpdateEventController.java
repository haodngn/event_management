/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventDAO;
import dao.PaymentDAO;
import dto.EventDTO;
import dto.EventErrorDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author HAO
 */
public class UpdateEventController extends HttpServlet {

    private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(UpdateEventController.class);

    private final String HOME_PAGE = "SearchEventController";
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
            int id = Integer.parseInt(request.getParameter("txtId"));
            String speaker = request.getParameter("txtSpeaker");
            String eventName = request.getParameter("txtEventName");
            String description = request.getParameter("txtDescription");
            String location = request.getParameter("txtLocation");
            int amountStudent = 0;
            if (!request.getParameter("txtAmount").equals("")) {
                amountStudent = Integer.parseInt(request.getParameter("txtAmount"));
            }

            float price = -1;
            if (!request.getParameter("txtPrice").equals("") || Float.parseFloat(request.getParameter("txtPrice")) > 0) {
                price = Float.parseFloat(request.getParameter("txtPrice"));
            }

            boolean foundErr = false;
            EventErrorDTO err = new EventErrorDTO();

            if (speaker.length() < 2 || speaker.length() > 50) {
                foundErr = true;
                err.setSpeakerLength("Field is required 2 - 50 character !!");
            }

            if (eventName.length() < 3 || eventName.length() > 30) {
                foundErr = true;
                err.setNameLength("Field is required 3 - 30 character !!");
            }

            if (description.length() < 3 || description.length() > 50) {
                foundErr = true;
                err.setDesLength("Field is required 3 - 50 charater !!");
            }

            if (location.length() < 2 || location.length() > 20) {
                foundErr = true;
                err.setLocationLength("Field is required 2 - 20 character !!");
            }

            if (amountStudent <= 10) {
                foundErr = true;
                err.setAmountStudentErr("At least 10 student can join this event !!");
            }

            //conver string to date(util) to compare
            String occurDate = request.getParameter("txtOccurDate");
            String endDate = request.getParameter("txtEndDate");
            String registerDate = request.getParameter("registerDate");
            String expirationDate = request.getParameter("txtExpirationDate");

            //get current date
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = formatter.format(date);

            //conver string to date(util) to compare
            Date occur = formatter.parse(occurDate);
            Date exp = formatter.parse(expirationDate);
            Date regist = formatter.parse(registerDate);
            Date end = formatter.parse(endDate);
            Date current = formatter.parse(currentDate);

            //expirationDate < RegisterDate
            if (exp.before(regist)) {
                foundErr = true;
                err.setExpDateCheck("Expiration date must after Register date !!");
            }

            //RegisterDate > ExpirationDate
            if (regist.after(exp)) {
                foundErr = true;
                err.setRegisterDateCheck("Register date must before Expiration date !!");
            }

            //Occur Date > End date
            if (occur.after(end)) {
                foundErr = true;
                err.setOccurDateCheck("Occur date must before End date !!");
            }

            //Occur date must at least 5 day since current date
            long diffrent = occur.getDate() - current.getDate();
            if (diffrent <= 5 && diffrent >= -5) {
                foundErr = true;
                err.setOccurDateCheck("Occur date must after current date at least 5 day !!");
            }

            //End date < Occur Date
            if (end.before(occur)) {
                foundErr = true;
                err.setEndDateCheck("End date must after Occur date !!");
            }

            //Occur Date < Exp Date
            if (occur.before(exp)) {
                foundErr = true;
                err.setOccurDateCheck("Occur date must after Expiration date !!");
            }

            //Exp Date > Occur Date
            if (exp.after(occur)) {
                foundErr = true;
                err.setExpDateCheck("Expiration date must before Occur date !!");
            }
//            EventDTO dto = new EventDTO(speaker, eventName, occurDate, endDate, registerDate, expirationDate, description, location, image);
            EventDTO dto = new EventDTO(speaker, eventName, occurDate, endDate, registerDate, expirationDate, description, location, amountStudent);
            if (foundErr) {
                request.setAttribute("UPDATE_ERR", err);
                request.setAttribute("EVENT", dto);// Detai Event
                request.setAttribute("EVENT_ID", id);
            } else {
                EventDAO dao = new EventDAO();

                boolean check = dao.updateEvent(dto, id);
                if (check) {
                    if (price <= 0 || request.getParameter("txtPrice").equals("")) {
                        boolean isFree = true;
                        PaymentDAO pdao = new PaymentDAO();
                        boolean result = pdao.updatePayment(id, isFree, 0);
                    } else {
                        boolean isFree = false;
                        PaymentDAO pdao = new PaymentDAO();
                        boolean result = pdao.updatePayment(id, isFree, price);
                    }
                    url = HOME_PAGE;
                }
            }

        } catch (ClassNotFoundException ex) {
            LOGGER.error("ClassNotFoundException at UpdateEventController: " + ex.getMessage());
        } catch (SQLException ex) {
            LOGGER.error("SQLException at UpdateEventController: " + ex.getMessage());
        } catch (NamingException ex) {
            LOGGER.error("NamingException at UpdateEventController: " + ex.getMessage());
        } catch (ParseException ex) {
            LOGGER.error("ParseException at UpdateEventController: " + ex.getMessage());
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
