package business.post;

import business.Customer;
import business.employee.CounterStaff;

import java.sql.Timestamp;

public class Post {
    private int postId;
    private Timestamp timestamp;
    private CounterStaff staff;
    private Customer customer;
    private String toAddress;
    private String fromAddress;


    public Post() {
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }



    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public CounterStaff getStaff() {
        return staff;
    }

    public void setStaff(CounterStaff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
