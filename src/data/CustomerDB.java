package data;

import business.Customer;

import java.sql.*;

public class CustomerDB {
    public static Customer selectCustomer(int customerId){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "select * from customers where id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,customerId);
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Customer found");
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                return customer;
            }else{
                System.out.println("Customer not found");
                return null;
            }
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
    public static void createCustomer(Customer customer,String password){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into customers (id,firstName,lastName,passWord,roleName) values (?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,customer.getId());
            ps.setString(2,customer.getFirstName());
            ps.setString(3,customer.getLastName());
            ps.setString(4,password);
            ps.setString(5,"customer");
            ps.executeUpdate();
            System.out.println("Customer created successfully ");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static void update(Customer customer,String passWord){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "update customers set firstName=?,lastName=?,userName=?,passWord=? where id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,customer.getFirstName());
            ps.setString(2,customer.getLastName());
            ps.setString(3,customer.getUserName());
            ps.setString(4,passWord);
            ps.setInt(5,customer.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static void deleteCustomer(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "delete from customers where id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
