package data;

import business.Counter;
import business.employee.CounterStaff;
import business.employee.Staff;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDB {
    public static CounterStaff selectStaffwithUserName(String userName){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM STAFFS WHERE USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,userName);
            rs = ps.executeQuery();
            CounterStaff counterStaff = null;
            if(rs.next()){
                 counterStaff = new CounterStaff();
                counterStaff.setId(rs.getInt("id"));
                counterStaff.setFirstName(rs.getString("firstName"));
                counterStaff.setLastName(rs.getString("lastName"));
                //TODO Update the counterStaff details to full
//                counterStaff.setCounterId(rs.getInt("counterId"));
            }
            return counterStaff;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static CounterStaff selectStaffwithId(int id, Counter counter){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection  = pool.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM STAFFS WHERE ID = ?";
        CounterStaff counterStaff = null;
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                counterStaff = new CounterStaff();
                counterStaff.setFirstName(rs.getString("firstName"));
                counterStaff.setLastName(rs.getString("lastName"));
                counterStaff.setId(id);
                counterStaff.setCounter(counter);
                counterStaff.setUserName(rs.getString("userName"));
            }
            return counterStaff;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }
    }
    public static List<Staff> selectAllStaffs(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        List<Staff> staffs = new ArrayList<Staff>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM staffs";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Staff tempStaff = new Staff();
                tempStaff.setFirstName(rs.getString("firstName"));
                tempStaff.setLastName(rs.getString("lastName"));
                tempStaff.setId(rs.getInt("id"));
                tempStaff.setUserName(rs.getString("userName"));
                staffs.add(tempStaff);
            }
            return staffs;
        } catch (SQLException e) {
            e.printStackTrace();
            return staffs;
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}
