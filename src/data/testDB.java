package data;

import business.TestUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testDB {
    public static TestUser selectUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        TestUser user = null;
        String query  = "SELECT * FROM TEST";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new TestUser();
                user.setId(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
            }
            return user;
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
