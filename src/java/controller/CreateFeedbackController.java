/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FeedbackDAO;
import dto.FeedbackErrorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HAO
 */
public class CreateFeedbackController extends HttpServlet {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(CreateFeedbackController.class);

    private final String DETAIL_EVENT = "GetDetailEventController";
    private final String FAIL = "invalid.jsp";

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

        String url = FAIL;

        String description_fb = request.getParameter("txtDescription_FB");
        String post_time = request.getParameter("txtPostTime");
        int event_id = Integer.parseInt(request.getParameter("txtId"));
        int posted_by = Integer.parseInt(request.getParameter("txtPostedBy"));
        int rating = Integer.parseInt(request.getParameter("txtRating"));

        FeedbackErrorDTO err = new FeedbackErrorDTO();
        boolean foundErr = false;

        try {
            if (rating <= 0 || rating > 5) {
                foundErr = true;
                err.setRatingError("Field is required 1-5 star  !!");
            }

            if (foundErr) {
                request.setAttribute("CREATE_ERR", err);
            } else {
                FeedbackDAO dao = new FeedbackDAO();
                boolean result = dao.createFeedback(event_id, posted_by, description_fb, rating, post_time);
                if (result) {
                    request.setAttribute("CREATE_SUCCESS", "Create success !");
                    url = DETAIL_EVENT;
                }
            }
        } catch (SQLException ex) {
            LOGGER.error("SQLException at CreateFeedbackController: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            LOGGER.error("ClassNotFoundException at CreateFeedbackController: " + ex.getMessage());
        } catch (NamingException ex) {
            LOGGER.error("NamingException at CreateFeedbackController: " + ex.getMessage());
        } catch (ParseException ex) {
            LOGGER.error("ParseException at CreateFeedbackController: " + ex.getMessage());
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
