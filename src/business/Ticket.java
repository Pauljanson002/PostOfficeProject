package business;

import business.employee.CounterStaff;

public class Ticket {
    private int id;
    private CounterStaff counterStaff;
    private Customer customer;
    private String reason;

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CounterStaff getCounterStaff() {
        return counterStaff;
    }

    public void setCounterStaff(CounterStaff counterStaff) {
        this.counterStaff = counterStaff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
