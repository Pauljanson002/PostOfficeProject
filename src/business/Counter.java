package business;

import business.employee.CounterStaff;



public class Counter {
    private int number;
    private CounterStaff staff;
    private String reason;

    public Counter() {

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
}
