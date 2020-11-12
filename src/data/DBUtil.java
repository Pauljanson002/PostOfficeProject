package data;

import java.sql.*;
import java.util.ArrayList;

public class DBUtil {

    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void updateDatabase(String query, ArrayList<Object> parameters){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =  null;
        try{
            ps = connection.prepareStatement(query);
            for(int i=0;i<parameters.size();i++){
                Object obj = parameters.get(i);
                if(obj instanceof Integer){
                    ps.setInt(i+1,(Integer) obj);
                } else if(obj instanceof String){
                    ps.setString(i+1,(String) obj);
                } else if(obj instanceof Timestamp) {
                    ps.setTimestamp(i+1, (Timestamp) obj);
                }
            }
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }


}