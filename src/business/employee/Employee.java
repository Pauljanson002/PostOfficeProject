package business.employee;

public class Employee extends Staff {
    private Boolean activeStatus;

    public Employee() {
        this.activeStatus = true;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
