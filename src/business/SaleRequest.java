package business;


import business.employee.Staff;
import business.ticketState.Open;
import business.ticketState.State;

import java.sql.Date;
import java.util.HashMap;

public class SaleRequest {
    private int id;
    private int amount;
    private HashMap<String,Integer> products;
    private Customer customer;
    private State state;
    private Date date;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public SaleRequest() {
        this.state = Open.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public HashMap<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, Integer> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
