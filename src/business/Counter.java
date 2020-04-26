package business;

import business.employee.CounterStaff;

import java.util.LinkedList;


public class Counter {
    private int number;
    private CounterStaff staff;
    private String reason;
    private LinkedList<Ticket> ticketQueue;

    public Counter() {
        ticketQueue = new LinkedList<Ticket>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CounterStaff getStaff() {
        return staff;
    }

    public void setStaff(CounterStaff staff) {
        this.staff = staff;
    }
    public void addTicket(Ticket ticket){
        ticketQueue.add(ticket);
    }
    public Ticket removeTicket(){
        return  ticketQueue.remove();
    }
}
