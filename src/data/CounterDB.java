package data;

import business.Counter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CounterDB {
    public static Counter getCounterByReason(String reason){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from counters where reason=?";
        Counter counter = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,reason);
            rs = ps.executeQuery();
            if(rs.next()){
                counter = new Counter();
                counter.setNumber(rs.getInt("number"));
                //TODO getStaff from id
                int staffId = rs.getInt("staffId");
                counter.setStaff(null);
                // Others
                counter.setReason(rs.getString("reason"));
            }
            return counter;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
