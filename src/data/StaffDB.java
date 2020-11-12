package data;

import business.Counter;
import business.Sale;
import business.employee.CounterStaff;
import business.employee.PostMaster;
import business.employee.SalesPerson;
import business.employee.Staff;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDB {
    public static Staff selectStaffwithUserName(String userName){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM STAFFS WHERE USERNAME = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,userName);
            rs = ps.executeQuery();
            Staff staff = null;
            if(rs.next()){
                if(rs.getString("userRole").equalsIgnoreCase("counterStaff")){
                    CounterStaff tempStaff = new CounterStaff();
                    tempStaff.setId(rs.getInt("id"));
                    tempStaff.setFirstName(rs.getString("firstName"));
                    tempStaff.setLastName(rs.getString("lastName"));
                    tempStaff.setCounter(CounterDB.selectCounterByNumber(rs.getInt("counterId")));
                    staff = tempStaff;
                }else if (rs.getString("userRole").equalsIgnoreCase("postMaster")){
                    staff = new PostMaster();
                    staff.setId(rs.getInt("id"));
                    staff.setFirstName(rs.getString("firstName"));
                    staff.setLastName(rs.getString("lastName"));
                }else if (rs.getString("userRole").equalsIgnoreCase("salesPerson")){
                    SalesPerson tempStaff = new SalesPerson();
                    tempStaff.setId(rs.getInt("id"));
                    tempStaff.setFirstName(rs.getString("firstName"));
                    tempStaff.setLastName(rs.getString("lastName"));
                    tempStaff.setUserName(rs.getString("userName"));
                    staff = tempStaff;
                }

                //TODO Update the counterStaff details to full
//                counterStaff.setCounterId(rs.getInt("counterId"));
            }
            return staff;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static  CounterStaff selectStaffwithId(int id){
        return  selectStaffwithId(id,null);
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
                tempStaff.setRoleName(rs.getString("userRole"));
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
    public static void update(Staff staff){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "UPDATE STAFFS SET firstName = ?,lastName=?,userName=? WHERE id=? ";
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1,staff.getFirstName());
            ps.setString(2,staff.getLastName());
            ps.setString(3,staff.getUserName());
            ps.setInt(4,staff.getId());
            ps.executeUpdate();
            ps = connection.prepareStatement("insert into staffpass (Username, password, name) value (?,?,?)");
            ps.setString(2,"root");
            ps.setString(1,staff.getUserName());
            ps.setString(3,staff.getFirstName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static Staff selectStaffWithCounterID(int counterId){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * FROM STAFFS WHERE counterId = ? ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        Staff staff = new Staff();
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,counterId);
            rs = ps.executeQuery();
            while(rs.next()){
                staff.setUserName(rs.getString("userName"));
                staff.setId(rs.getInt("id"));
                staff.setRoleName(rs.getString("userRole"));
                staff.setFirstName(rs.getString("firstName"));
                staff.setLastName(rs.getString("lastName"));
            }
            return staff;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);

        }
    }

    public static void insert(Staff staff){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "insert into staffs (id, firstName, lastName, userName, userRole) value (?,?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,staff.getId());
            ps.setString(2,staff.getFirstName());
            ps.setString(3,staff.getLastName());
            ps.setString(4,staff.getUserName());
            ps.setString(5,staff.getRoleName());
            ps.executeUpdate();
            ps = connection.prepareStatement("insert into staffpass (Username, password, name) value (?,?,?)");
            ps.setString(2,"root");
            ps.setString(1,staff.getUserName());
            ps.setString(3,staff.getFirstName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}
