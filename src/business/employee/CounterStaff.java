package business.employee;

import business.Counter;

public class CounterStaff  extends Employee{
    Counter counter ;

    public CounterStaff() {
        this.setRoleName("Counter Staff");
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
}
