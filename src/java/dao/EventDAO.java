/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EventDTO;
import dto.RegisterDTO;
import dto.UserDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBHelper;

/**
 *
 * @author Admin
 */
public class EventDAO implements Serializable {

    List<EventDTO> listEvent;

    public List<EventDTO> getListEvent() {
        return listEvent;
    }

    public EventDTO getEventByID(int id)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        EventDTO dto = null;

        try {
            String sql = "select E.ID, E.EventName, E.Speaker, E.EndDate, E.RegisterDate, E.ExpirationDate, E.OccurDate, E.Description, \n"
                    + "E.Location, E.StudentCount, E.Image, P.Price, E.StudentMax\n"
                    + "from Event E\n"
                    + "join Payment P\n"
                    + "on E.ID = P.Event_Id\n"
                    + "where E.ID =?";

            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {

                DateFormat df = new SimpleDateFormat("YYYY-MM-dd");//convert date to String with format dd//MM//YYYY

                String speaker = rs.getString("Speaker");
                String name = rs.getString("EventName");
                String location = rs.getString("Location");
                String des = rs.getString("Description");
                String image = rs.getString("Image");
                float price = rs.getFloat("Price");
                int studentCount = rs.getInt("StudentCount");
                int studentMax = rs.getInt("StudentMax");

                Date EndDate = rs.getDate("EndDate");
                Date RegisterDate = rs.getDate("RegisterDate");
                Date ExpirationDate = rs.getDate("ExpirationDate");
                Date OccurDate = rs.getDate("OccurDate");

                //convert Date to String to store in dto
                String end = df.format(EndDate);
                String register = df.format(RegisterDate);
                String exp = df.format(ExpirationDate);
                String occur = df.format(OccurDate);

                dto = new EventDTO(id, speaker, name, occur, end, register, exp, studentCount, des, location, image, price, studentMax);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return dto;
    }

    //get all event WITHOUT paging
    public void getAll()
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.listEvent = new ArrayList<>();

        try {
            String sql = "select ID, Speaker, EventName, Location, Image "
                    + "from Event "
                    + "where status=1 ";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            System.out.println("sql: " + sql);
            while (rs.next()) {
                int Id = rs.getInt("ID");
                String speaker = rs.getString("Speaker");
                String name = rs.getString("EventName");
                String location = rs.getString("Location");
                String image = rs.getString("Image");

                EventDTO dto = new EventDTO(Id, speaker, name, location, image);
                if (this.listEvent == null) {
                    this.listEvent = new ArrayList<>();
                }
                this.listEvent.add(dto);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void getAllForDep()
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.listEvent = new ArrayList<>();

        try {
            String sql = "select E.ID, E.EventName, E.Speaker, E.EndDate, E.RegisterDate, E.ExpirationDate, E.OccurDate, E.Description, \n"
                    + "E.Location, E.StudentCount, E.Posted_by, E.Image, E.StudentMax, P.Price\n"
                    + "from Event E\n"
                    + "left join Payment P\n"
                    + "on E.ID = P.Event_Id\n"
                    + "where E.Status=1 ";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            System.out.println("sql: " + sql);
            while (rs.next()) {
                DateFormat df = new SimpleDateFormat("YYYY-MM-dd");//convert date to String with format dd//MM//YYYY

                int id = rs.getInt("ID");
                String speaker = rs.getString("Speaker");
                String name = rs.getString("EventName");
                String location = rs.getString("Location");
                String des = rs.getString("Description");
                int postBy = rs.getInt("Posted_by");
                int count = rs.getInt("StudentCount");
                String image = rs.getString("Image");
                int max = rs.getInt("StudentMax");
                float price = rs.getFloat("Price");

                Date EndDate = rs.getDate("EndDate");
                Date RegisterDate = rs.getDate("RegisterDate");
                Date ExpirationDate = rs.getDate("ExpirationDate");
                Date OccurDate = rs.getDate("OccurDate");

                //convert Date to String to store in dto
                String end = df.format(EndDate);
                String register = df.format(RegisterDate);
                String exp = df.format(ExpirationDate);
                String occur = df.format(OccurDate);

                EventDTO dto = new EventDTO(id, speaker, name, occur, end, register, exp, count, des, location, postBy, image, price, max);
                if (this.listEvent == null) {
                    this.listEvent = new ArrayList<>();
                }
                this.listEvent.add(dto);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    //get event by studentID
    
    public void getEventByStudentID(int ID)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.listEvent = new ArrayList<>();

        try {
            String sql = "select E.ID, E.Speaker, E.EventName, E.OccurDate, E.Location, R.Attendence\n" +
                    "from Event E\n" +
                    "join Register R\n" +
                    "on E.ID = R.Event_id\n" +
                    "where R.Student_id = ?";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, ID);
            rs = stm.executeQuery();
            System.out.println("sql: " + sql);
            while (rs.next()) {
                DateFormat df = new SimpleDateFormat("YYYY-MM-dd");//convert date to String with format dd//MM//YYYY
                
                int Id = rs.getInt("ID");
                String speaker = rs.getString("Speaker");
                String name = rs.getString("EventName");
                String location = rs.getString("Location");
                boolean attendence = rs.getBoolean("Attendence");
                
                Date OccurDate = rs.getDate("OccurDate");
                String occur = df.format(OccurDate);

                EventDTO dto = new EventDTO(Id, speaker, name, occur, location, attendence);
                if (this.listEvent == null) {
                    this.listEvent = new ArrayList<>();
                }
                this.listEvent.add(dto);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    //get all search WITHOUT paging
    public void getBySearch(String name)
            throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.listEvent = new ArrayList<>();

        if (name.equals("")) {
            name = null;
        } else {
            name = "%" + name + "%";
        }

        try {
            String sql = "select ID, Speaker, EventName, Location, Image "
                    + "from Event "
                    + "where status=1 "
                    + "and EventName like ISNULL(?,EventName) ";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            rs = stm.executeQuery();

            while (rs.next()) {
                int Id = rs.getInt("ID");
                String Eventname = rs.getString("EventName");
                String speaker = rs.getString("Speaker");
                String location = rs.getString("Location");
                String image = rs.getString("Image");

                EventDTO dto = new EventDTO(Id, speaker, Eventname, location, image);
                if (this.listEvent == null) {
                    this.listEvent = new ArrayList<>();
                }
                this.listEvent.add(dto);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public int pagingEventBySearch(String searchValue) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int countPage = 0;
        if (searchValue.equals("")) {
            searchValue = null;
        } else {
            searchValue = "%" + searchValue + "%";
        }
        try {
            String sql = "select count(ID) as row "
                    + "from Event "
                    + "where EventName like ? ";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, searchValue);
            rs = stm.executeQuery();
            while (rs.next()) {
                int total = rs.getInt("row");
                countPage = total / 5;
                if (total % 5 != 0) {
                    countPage++;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return countPage;
    }

    public List<EventDTO> getEventByName(String name, int index)
            throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EventDTO> listAdminEvent = null;
        if (name.equals("")) {
            name = null;
        } else {
            name = "%" + name + "%";
        }
        try {
            String sql = "Select ID, Speaker, EventName, OccurDate, "
                    + "EndDate, RegisterDate, ExpirationDate, StudentCount, "
                    + "Description, Location, Image from Event where EventName like ? "
                    + "order by OccurDate "
                    + "OFFSET ? ROWS  FETCH NEXT 5 ROWS ONLY";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            stm.setInt(2, (index - 1) * 5);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String eventName = rs.getString("EventName");
                String speaker = rs.getString("Speaker");
                String occurDate = rs.getString("OccurDate");
                String endDate = rs.getString("EndDate");
                String registerDate = rs.getString("RegisterDate");
                String expirationDate = rs.getString("ExpirationDate");
                int studentCount = rs.getInt("StudentCount");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String image = rs.getString("Image");

                EventDTO dto = new EventDTO(id, speaker, eventName, occurDate, endDate, registerDate, expirationDate, studentCount, description, location, image);
                if (listAdminEvent == null) {
                    listAdminEvent = new ArrayList<>();
                }
                listAdminEvent.add(dto);
            }
            return listAdminEvent;

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public int getMaxId() throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int maxid = 0;
        try {
            String sql = "SELECT MAX(ID) as row FROM Event";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                maxid = rs.getInt("row");
            }

            return maxid;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean createEvent(String speaker, String eventName,
            String occurDate, String enddate, String registerDate,
            String expirationDate, int studentCount, String description,
            String loaction, String image, int prosted_by, int amountStudent) throws SQLException, ClassNotFoundException, NamingException, ParseException {

        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            String sql = "insert into Event(Speaker, EventName, Description, EndDate, ExpirationDate, Location, OccurDate, "
                    + "Posted_by, RegisterDate, StudentCount, Status,Image, StudentMax) "
                    + "values(?,?,?,?,?,?,?,?,?,?,1,?, ?)";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);

            Date occur = Date.valueOf(occurDate);
            Date end = Date.valueOf(enddate);
            Date register = Date.valueOf(registerDate);
            Date expiration = Date.valueOf(expirationDate);

            stm.setString(1, speaker);
            stm.setString(2, eventName);
            stm.setString(3, description);
            stm.setDate(4, end);
            stm.setDate(5, expiration);
            stm.setString(6, loaction);
            stm.setDate(7, occur);
            stm.setInt(8, prosted_by);
            stm.setDate(9, register);
            stm.setInt(10, studentCount);
            stm.setString(11, image);
            stm.setInt(12, amountStudent);

            int row = stm.executeUpdate();
            if (row > 0) {
                check = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean updateEvent(EventDTO dto, int id) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean update = false;
        String sql = "update Event "
                + "set Speaker = ?, EventName = ?, "
                + "OccurDate = ?, EndDate = ?, "
                + "RegisterDate = ?, ExpirationDate = ?, "
                + "Description = ?, Location = ? "
                + "where ID = ?  ";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);

            stm.setString(1, dto.getSpeaker());
            stm.setString(2, dto.getEventName());
            stm.setString(3, dto.getOccurDate());
            stm.setString(4, dto.getEnddate());
            stm.setString(5, dto.getRegisterDate());
            stm.setString(6, dto.getExpirationDate());
            stm.setString(7, dto.getDescription());
            stm.setString(8, dto.getLoaction());

            stm.setInt(9, id);

            if (stm.executeUpdate() > 0) {
                update = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return update;
    }

    public boolean deleteEvent(int id) throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        String sql = "update Event set status=0 where id=?";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, id);

            if (stm.executeUpdate() > 0) {
                check = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean registerEvent(int userID, int eventID, Date registerDate, String code) throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean check = false;
        String sql = "Insert into Register(Event_id, Student_id, RegisterDate, Attendence, Code) values (?, ?, ?, ?, ?)";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, eventID);
            stm.setInt(2, userID);
            stm.setDate(3, registerDate);
            stm.setBoolean(4, false);
            stm.setString(5, code);

            if (stm.executeUpdate() > 0) {
                check = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean checkRegistedEvent(int userID, int eventID) throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean check = false;
        String sql = "Select ID from Register Where Event_id = ? and Student_id = ?";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);

            stm.setInt(1, eventID);
            stm.setInt(2, userID);
            rs = stm.executeQuery();

            if (rs.next()) {
                check = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean checkRegisterEventValidation(Date currentDate, int eventID) throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs;
        boolean check = false;
        String sql = "Select ID from Event Where ID = ? and registerDate < ? and expirationDate > ? and StudentCount < StudentMax";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, eventID);
            stm.setDate(2, currentDate);
            stm.setDate(3, currentDate);
            rs = stm.executeQuery();

            if (rs.next()) {
                check = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    // Dem bao nhieu Event (moi trang 5 event)
    public int pagingEvent() throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int countPage = 0;

        try {
            String sql = "select count(ID) as row from Event where Status=1";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int total = rs.getInt("row");
                countPage = total / 5;
                if (total % 5 != 0) {
                    countPage++;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return countPage;
    }

    public void getAllEventForAdmin(int index)
            throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        this.listEvent = new ArrayList<>();

        try {
            String sql = "Select ID, Speaker, EventName, OccurDate,"
                    + " EndDate, RegisterDate, ExpirationDate, StudentCount, "
                    + "Description, Location, Image from Event where status=1 "
                    + "order by OccurDate "
                    + "OFFSET ? ROWS  FETCH NEXT 5 ROWS ONLY";
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 5);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String eventName = rs.getString("EventName");
                String speaker = rs.getString("Speaker");
                String occurDate = rs.getString("OccurDate");
                String endDate = rs.getString("EndDate");
                String registerDate = rs.getString("RegisterDate");
                String expirationDate = rs.getString("ExpirationDate");
                int studentCount = rs.getInt("StudentCount");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String image = rs.getString("Image");

                EventDTO dto = new EventDTO(id, speaker, eventName, occurDate, endDate, registerDate, expirationDate, studentCount, description, location, image);
                if (this.listEvent == null) {
                    this.listEvent = new ArrayList<>();
                }
                this.listEvent.add(dto);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public int countTotalEvent() throws ClassNotFoundException, NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs;
        int eventCount = 0;
        String sql = "Select count(ID) as totalEvent from Event";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            if (rs.next()) {
                eventCount = rs.getInt("totalEvent");
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return eventCount;
    }

    public boolean updateStudentCount(int id) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean update = false;
        String sql = "update Event "
                + "set StudentCount = StudentCount + 1 "
                + "where ID = ?  ";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);

            if (stm.executeUpdate() > 0) {
                update = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return update;
    }

    public List<RegisterDTO> getListEventStudent(int eventId) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RegisterDTO> listRegister = null;
        String sql = "Select A.ID as id, A.Name as name, A.Email as email, R.Attendence as attend "
                + "From Account A Join Register R On A.ID = R.Student_id and R.Event_id = ?";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, eventId);
            rs = stm.executeQuery();

            while(rs.next()) {
                int accountId = rs.getInt("id");
                String accountName = rs.getString("name");
                String accountEmail = rs.getString("email");
                Boolean attend = rs.getBoolean("attend");
                RegisterDTO dto = new RegisterDTO(accountId, accountName, accountEmail, attend);
                if (listRegister == null) {
                    listRegister = new ArrayList<>();
                }
                
                listRegister.add(dto);
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return listRegister;
    }
    
    public boolean checkAttendance(int code) throws ClassNotFoundException, SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean update = false;
        String sql = "Update Register set Attendence = ? where code = ?";
        try {
            con = DBHelper.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setBoolean(1, true);
            stm.setInt(2, code);

            if (stm.executeUpdate() > 0) {
                update = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return update;
    }
}
