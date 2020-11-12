package data;

import business.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductDB {
    public static ArrayList<Product> selectAll() {
        ArrayList<Product> products = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from products";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                //  Product product = new Product(rs.getInt("id"),rs.getString("name"),rs.getInt("price"),rs.getInt("qty"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setQty(rs.getInt("qty"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }
    }

    public static void updateAll(ArrayList<Product> products) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "update products set qty = ? where id= ?";
        System.out.println(products.size());
        for (Product product : products) {
            try {
                ps = connection.prepareStatement(query);
                ps.setInt(1, product.getQty());
                ps.setInt(2, product.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        System.out.println("product DB");
        DBUtil.closePreparedStatement(ps);
        DBUtil.closeResultSet(rs);
        pool.freeConnection(connection);
    }

    public static void insert(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "insert into products (name, price, qty) value (?,?,?)";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,product.getName());
            ps.setInt(3, product.getQty());
            ps.setInt(2, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }
    }
}
