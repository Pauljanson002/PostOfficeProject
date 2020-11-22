package controller;

import business.Counter;
import business.employee.Staff;
import data.CounterDB;
import data.StaffDB;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

public class CounterContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        ArrayList<Counter> counters = CounterDB.selectAllCounters();
        sc.setAttribute("counters",counters);
        NotificationManager notificationManager = new NotificationManager();
        List<Staff> staffs =  StaffDB.selectAllStaffs();
        for (Staff s :
                staffs) {
            notificationManager.attach(s.getId());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Do nothing
    }
    //payment for staffs
    // adding employees
    // addding inventory products for sales person
    //todo account settings
    //todo clean up UI
}
