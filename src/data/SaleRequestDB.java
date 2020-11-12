package data;

import business.SaleRequest;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SaleRequestDB {
    public static void insert(SaleRequest saleRequest){
        ConnectionPool pool = ConnectionPool.getInstance();
        String query = "insert into salerequests(amount,customerid,products,state,date) values (?,?,?,?,?) ";
        Connection connection = pool.getConnection();
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,saleRequest.getAmount());
            ps.setInt(2,saleRequest.getCustomer().getId());
            Gson gson = new Gson();
            String jsonString = gson.toJson(saleRequest.getProducts());
            ps.setString(3,jsonString);
            ps.setInt(4,saleRequest.getState().showState());
            ps.setDate(5,new java.sql.Date(new Date().getTime()));
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    public static ArrayList<SaleRequest> selectAll(){
        ConnectionPool pool = ConnectionPool.getInstance();
        String query = "select * from salerequests where state=1";
        Connection connection = pool.getConnection();
        PreparedStatement ps =null;
        ResultSet rs =null;
        ArrayList<SaleRequest> saleRequests = new ArrayList<>();
        Gson gson = new Gson();
        HashMap<String,Integer> integerHashMap = new HashMap<>();
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                SaleRequest saleRequest = new SaleRequest();
                saleRequest.setId(rs.getInt("id"));
                saleRequest.setCustomer(CustomerDB.selectCustomer(rs.getInt("customerid")));
                saleRequest.setAmount(rs.getInt("amount"));
                saleRequest.setProducts(gson.fromJson(rs.getString("products"),integerHashMap.getClass()));
                saleRequests.add(saleRequest);
            }
            return saleRequests;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }
    }
    public static SaleRequest selectSaleRequest(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        String query = "select * from salerequests where id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = pool.getConnection();
        Gson gson = new Gson();
        HashMap<String,Integer> hashMap = new HashMap<>();
        SaleRequest saleRequest = new SaleRequest();
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                saleRequest.setId(id);
                saleRequest.setAmount(rs.getInt("amount"));
                saleRequest.setCustomer(CustomerDB.selectCustomer(rs.getInt("customerid")));
                saleRequest.setProducts(gson.fromJson(rs.getString("products"),hashMap.getClass()));

            }
            return saleRequest;

        } catch (SQLException e) {
            e.printStackTrace();
            return saleRequest;
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }
    public  static void updateState(SaleRequest saleRequest){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "update salerequests set state=? where id=? ";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,saleRequest.getState().showState());
            ps.setInt(2,saleRequest.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);

        }
    }

    public static ArrayList<Integer> getLastYearReport(){
        ArrayList<Integer> report = new ArrayList<>(12);
        for (int i = 0; i <12 ; i++) {
           report.add(0);
        }
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "SELECT * From salerequests where YEAR(date) = YEAR(CURDATE())";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Date date = rs.getDate("date");
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month = cal.get(Calendar.MONTH);
                report.add(month,report.get(month)+rs.getInt("amount"));
            }
            return report;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
