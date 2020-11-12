package data;

import business.Counter;
import business.employee.CounterStaff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CounterDB {

    public static Counter selectCounterByNumber(int number){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "select * from counters where number = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,number);
            rs = ps.executeQuery();
            Counter counter = new Counter();
            while(rs.next()){

                counter.setNumber(rs.getInt("number"));
                counter.setStaff(StaffDB.selectStaffwithId(rs.getInt("staffId")));
                counter.setReason(rs.getString("reason"));

            }
            return counter;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static ArrayList<Counter> selectAllCounters(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM COUNTERS ";
        ArrayList<Counter> counters = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Counter counter = new Counter();
                counter.setReason(rs.getString("reason"));
                CounterStaff counterStaff = StaffDB.selectStaffwithId(rs.getInt("staffid"),counter);
                counter.setStaff(counterStaff);
                counter.setNumber(rs.getInt("number"));
                counters.add(counter);
            }
            return counters;

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
