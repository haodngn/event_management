/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.EventDAO;
import dto.RegisterDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author MSI
 */
public class TakeAttendanceController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(TakeAttendanceController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            EventDAO dao = new EventDAO();
            HttpSession ses = request.getSession();
            String message = "";
            Boolean checkAttend = false;
            Boolean firstTime = true;
            String attendCode = request.getParameter("attendanceCode");
            if (attendCode != null) {
                if (!attendCode.equals("")) {
                    System.out.println("TAO o Dayyy");
                    checkAttend = dao.checkAttendance(Integer.parseInt(attendCode));
                    firstTime = false;
                }
            }

            if (checkAttend) {
                message = "Successfully";
            } else {
                message = "Error";
            }
            request.setAttribute("firstTime", firstTime);
            request.setAttribute("checkAttendMessage", message);
            int eventId = Integer.parseInt(request.getParameter("txtId"));
            List<RegisterDTO> listRegister = dao.getListEventStudent(eventId);
            request.setAttribute("txtId", eventId);
            ses.setAttribute("listRegisterStudent", listRegister);
        } catch (Exception e) {
            LOGGER.error("Error at TakeAttendanceController: " + e);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("attendance.jsp");
            rd.forward(request, response);
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
