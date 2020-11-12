package data;

import business.Customer;
import business.employee.Staff;
import business.post.ForeignPost;
import business.post.ParcelPost;
import business.post.Post;
import business.post.TelemailPost;

import javax.print.DocFlavor;
import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDB {
    public static void insert(Post post){
        if(post instanceof ForeignPost){
            insertForeignPost((ForeignPost) post);
        } else if(post instanceof ParcelPost){
            insertParcelPost((ParcelPost) post);
        } else if(post instanceof TelemailPost){
            insertTelemailPost((TelemailPost) post);
        }
    }
    private static void insertForeignPost(ForeignPost foreignPost){
        String query  = "insert into posts (time_stamp,category,staffId,customerId,to,from,country,weight,type) values (?,?,?,?,?,?,?,?,?)";
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(foreignPost.getTimestamp());
        parameters.add("Foreign Post");
        parameters.add(foreignPost.getStaff().getId());
        parameters.add(foreignPost.getCustomer().getId());
        parameters.add(foreignPost.getToAddress());
        parameters.add(foreignPost.getFromAddress());
        parameters.add(foreignPost.getCountry());
        parameters.add(foreignPost.getWeight());
        parameters.add(foreignPost.getType());
        DBUtil.updateDatabase(query,parameters);
    }
    private static void insertParcelPost(ParcelPost parcelPost){
        String query = "insert into posts (time_stamp,category,staffId,customerId,to,from,weight) values (?,?,?,?,?,?,?)";
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(parcelPost.getTimestamp());
        parameters.add("Parcel Post");
        parameters.add(parcelPost.getStaff().getId());
        parameters.add(parcelPost.getCustomer().getId());
        parameters.add(parcelPost.getToAddress());
        parameters.add(parcelPost.getFromAddress());
        parameters.add(parcelPost.getWeight());
        DBUtil.updateDatabase(query,parameters);
    }

    private static void insertTelemailPost(TelemailPost telemailPost){
        String query = "insert into posts (time_stamp,category,staffId,customerId,toAddress,fromAddress,message) values (?,?,?,?,?,?,?)";
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(telemailPost.getTimestamp());
        parameters.add("Telemail Post");
        parameters.add(telemailPost.getStaff().getId());
        parameters.add(telemailPost.getCustomer().getId());
        parameters.add(telemailPost.getToAddress());
        parameters.add(telemailPost.getFromAddress());
        parameters.add(telemailPost.getMessage());
        DBUtil.updateDatabase(query,parameters);
    }
    public static ArrayList<Post> selectAllPostsWithCustomer(Customer customer){
        int customerId = customer.getId();
        ArrayList<Post> posts = new ArrayList<>();
        String query = "select * from posts where customerId = ?";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,customerId);
            rs = ps.executeQuery();
            while (rs.next()){
                Post tempPost = new Post();
                tempPost.setCustomer(customer);
                tempPost.setStaff(StaffDB.selectStaffwithId(rs.getInt("staffId")));
                tempPost.setFromAddress(rs.getString("fromAddress"));
                tempPost.setToAddress(rs.getString("toAddress"));
                tempPost.setTimestamp(rs.getTimestamp("time_stamp"));
                tempPost.setPostId(rs.getInt("id"));
                posts.add(tempPost);
            }
            return posts;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeResultSet(rs);
            pool.freeConnection(connection);
        }
    }
}
