package data;

import business.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public static void createCustomer(Customer customer){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into customers (id,firstName,lastName) values (?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,customer.getId());
            ps.setString(2,customer.getFirstName());
            ps.setString(3,customer.getLastName());
            ps.executeUpdate();
            System.out.println("Customer created successfully ");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
