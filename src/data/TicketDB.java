package data;

import business.Ticket;
import business.employee.CounterStaff;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TicketDB {
    public static Ticket createTicket(Ticket ticket){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into tickets (staffid,customerId,reason,open,date,counterId) values(?,?,?,?,?,?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,ticket.getStaff().getId());
            ps.setInt(2,ticket.getCustomer().getId());
            ps.setString(3,ticket.getReason());
            ps.setInt(4,ticket.getState().showState());
            ps.setDate(5,ticket.getDate());
            ps.setInt(6,ticket.getCounterId());
            ps.executeUpdate();

            String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement identityStatement = connection.createStatement();
            ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
            identityResultSet.next();
            int ticketId = identityResultSet.getInt("IDENTITY");
            identityResultSet.close();
            identityStatement.close();

            ticket.setId(ticketId);
            return ticket;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Ticket> selectTicketswithCustomerId(int customerId){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM TICKETS WHERE CUSTOMERID = ?";
        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,customerId);
            rs = ps.executeQuery();
            while (rs.next()){
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                CounterStaff counterStaff = StaffDB.selectStaffwithId(Integer.parseInt(rs.getString("staffid")),null);
                ticket.setStaff(counterStaff);
                ticket.setReason(rs.getString("reason"));
                ticket.setDate(rs.getDate("date"));
                tickets.add(ticket);
            }
            return tickets;

        } catch (SQLException e) {
            e.printStackTrace();
            return tickets;
        }finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }
    }

    public  static ArrayList<Ticket> selectOpenTicketsWithStaffID(int staffID){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Ticket> tickets = new ArrayList<>();
        ResultSet rs = null;
        String query = "select * from tickets where staffid=? and open=1";
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,staffID);
            rs = ps.executeQuery();
            while (rs.next()){
                Ticket tempticket = new Ticket();
                tempticket.setId(rs.getInt("id"));
                tempticket.setReason(rs.getString("reason"));
                tempticket.setCustomer(CustomerDB.selectCustomer(rs.getInt("customerId")));
                tempticket.setStaff(StaffDB.selectStaffwithId(rs.getInt("staffId")));
                tempticket.setDate(rs.getDate("date"));
                tickets.add(tempticket);
            }

            return tickets;

        } catch (SQLException e) {
            e.printStackTrace();
            return tickets;
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }
    }
    public static void update(Ticket ticket){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE tickets SET open = ? WHERE id=? ";
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,ticket.getState().showState());
            ps.setInt(2,ticket.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }


    public static ArrayList<Integer> getLastYearReport(){
        ArrayList<Integer> report = new ArrayList<>(12);
        for (int i = 0; i <12 ; i++) {
            report.add(0);
        }
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * From tickets where YEAR(date) = YEAR(CURDATE())";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Date date = rs.getDate("date");
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month = cal.get(Calendar.MONTH);
                report.add(month,report.get(month)+1);
            }
            return report;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
