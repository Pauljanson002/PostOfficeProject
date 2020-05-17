package business;

import business.post.Post;

import java.util.ArrayList;

public class Customer {
    private int id ;
    private String firstName;
    private String lastName;
    private ArrayList<Post> posts;
    public Customer() {
        posts = new ArrayList<Post>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
