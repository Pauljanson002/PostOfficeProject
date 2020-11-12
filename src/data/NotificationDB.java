package data;

import business.util.Notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotificationDB {
    public static void insertNotification(Notification n){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection  = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into notification(staffid,reportid,seen) value (?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,n.getStaffId());
            ps.setInt(2,n.getReportId());
            ps.setInt(3,n.getSeen());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<Notification> selectNotificationWithStaffId(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Notification> notifications = new ArrayList<>();
        ResultSet rs = null;
        String query = "select * from notification where staffid = ? and seen = 0";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
               Notification notification = new Notification();
               notification.setStaffId(id);
               notification.setSeen(0);
               notification.setReportId(rs.getInt(2));
                notification.setMessage(rs.getString("message"));
                notifications.add(notification);
            }
            return notifications;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
