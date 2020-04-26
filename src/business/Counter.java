package business;

import business.employee.CounterStaff;

import java.util.LinkedList;


public class Counter {
    private int number;
    private CounterStaff staff;
    private String reason;
    private LinkedList<Ticket> ticketQueue;
    private int availableTickets;

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public Counter() {
        ticketQueue = new LinkedList<Ticket>();
        availableTickets = 0;
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
        availableTickets++;
    }
    public Ticket removeTicket(){
        availableTickets--;
        return  ticketQueue.remove();

    }
}
