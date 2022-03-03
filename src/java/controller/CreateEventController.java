/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EventDAO;
import dao.PaymentDAO;
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
import java.io.File;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


/**
 *
 * @author Admin
 */
@MultipartConfig
public class CreateEventController extends HttpServlet {

    private static final Logger LOGGER = org.apache.log4j.Logger.getLogger(CreateEventController.class);
    private final String ADD_PAGE = "SearchEventController";
    private final String ERROR = "create_event.jsp";
    public static final String SAVE_DIRECTORY = "assets/event";

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
//        String carID = request.getParameter("txtID");
        String speaker = request.getParameter("txtSpeaker");
        String eventName = request.getParameter("txtEventName");
        String occurDate = request.getParameter("txtOccurDate");
        String endDate = request.getParameter("txtEndDate");
        String registerDate = request.getParameter("registerDate");
        String expirationDate = request.getParameter("txtExpirationDate");

        String description = request.getParameter("txtDescription");
        String location = request.getParameter("txtLocation");

        float price = -1;
        if (!request.getParameter("txtPrice").equals("")) {
            price = Float.parseFloat(request.getParameter("txtPrice"));
        }
      //image
        String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.substring(0, appPath.indexOf("build")) + "web\\";
            appPath = appPath.replace('\\', '/');

            // Thư mục để save file tải lên.
            String fullSavePath = null;
            if (appPath.endsWith("/")) {
                fullSavePath = appPath + SAVE_DIRECTORY;
            } else {
                fullSavePath = appPath + "/" + SAVE_DIRECTORY;
            }

            // Tạo thư mục nếu nó không tồn tại.
            File fileSaveDir = new File(fullSavePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            String fileName = "";
            for (Part part : request.getParts()) {
                String fileExtension = getFileExtension(part);
                if (fileExtension != null && fileExtension.length() > 0) {
                    fileName = String.valueOf(System.currentTimeMillis()) + fileExtension;
                    String filePath = fullSavePath + File.separator + fileName;
                    System.out.println("Write attachment to file: " + filePath);

                    part.write(filePath);
                    String buildPath = request.getServletContext().getRealPath("");
                    if (buildPath.endsWith("/")) {
                        buildPath = buildPath + SAVE_DIRECTORY;
                    } else {
                        buildPath = buildPath + "/" + SAVE_DIRECTORY;
                    }
                    buildPath += File.separator + fileName;
                    File finish = new File(buildPath);
                    while (!finish.exists());
                }
            }


        EventErrorDTO err = new EventErrorDTO();
        boolean foundErr = false;
        try {
            if (speaker.length() < 2 || speaker.length() > 100) {
                foundErr = true;
                err.setSpeakerLength("Field is required 2 - 100 character !!");
            }

            if (eventName.length() < 3 || eventName.length() > 100) {
                foundErr = true;
                err.setNameLength("Field is required 3 - 100 character !!");
            }

            if (description.length() < 3 || description.length() > 500) {
                foundErr = true;
                err.setDesLength("Field is required 3 - 500 charater !!");
            }

            if (location.length() < 2 || location.length() > 200) {
                foundErr = true;
                err.setLocationLength("Field is required 2 - 200 character !!");
            }

            //conver string to date(util) to compare
            Date occur = new SimpleDateFormat("MM-dd-yyyy").parse(occurDate);
            Date exp = new SimpleDateFormat("MM-dd-yyyy").parse(expirationDate);
            Date regist = new SimpleDateFormat("MM-dd-yyyy").parse(registerDate);
            Date end = new SimpleDateFormat("MM-dd-yyyy").parse(endDate);

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

            if (foundErr) {
                request.setAttribute("CREATE_ERR", err);
            } else {
                HttpSession sess = request.getSession();
                UserDTO user = (UserDTO) sess.getAttribute("USER");
                System.out.println("user id: " + user.getUserID());
                System.out.println("des: " + description);

                EventDAO dao = new EventDAO();
                boolean result = dao.createEvent(speaker, eventName, occurDate, endDate, registerDate, expirationDate, 0, description, location,"assets/event/" + fileName ,user.getUserID());
                if (result) {
                    EventDAO edao = new EventDAO();
                    int eventID = edao.getMaxId();
                    System.out.println("eventid: " + eventID);

                    if (price == -1) {
                        boolean isFree = true;
                        PaymentDAO pdao = new PaymentDAO();
                        boolean crepayment = pdao.creatPayment(isFree, 0, eventID);
                    } else {
                        boolean isFree = false;
                        PaymentDAO pdao = new PaymentDAO();
                        boolean crepayment = pdao.creatPayment(isFree, price, eventID);
                    }
                    url = ADD_PAGE;
                    request.setAttribute("CREATE_SUCCESS", "Create success !");
                }
            }
        } catch (SQLException ex) {
            LOGGER.error("SQLException at CreateEventController: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            LOGGER.error("ClassNotFoundException at CreateEventController: " + ex.getMessage());
        } catch (NamingException ex) {
            LOGGER.error("NamingException at CreateEventController: " + ex.getMessage());
        } catch (ParseException ex) {
            LOGGER.error("ParseException at CreateEventController: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }
    private String getFileExtension(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String clientFileName = "";
                if (s.contains(".")) {
                    clientFileName = s.substring(s.lastIndexOf("."), s.length() - 1);
                }
                return clientFileName;
            }
        }
        return null;
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