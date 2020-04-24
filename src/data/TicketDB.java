package data;

import business.Ticket;

import java.sql.*;

public class TicketDB {
    public static void createTicket(Ticket ticket){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into tickets (staffid,customerId,reason) values(?,?,?);";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,ticket.getCounterStaff().getId());
            ps.setInt(2,ticket.getCustomer().getId());
            ps.setString(3,ticket.getReason());
            ps.executeUpdate();

            String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement identityStatement = connection.createStatement();
            ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
            identityResultSet.next();
            int ticketId = identityResultSet.getInt("IDENTITY");
            identityResultSet.close();
            identityStatement.close();

            ticket.setId(ticketId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
