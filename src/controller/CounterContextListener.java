package controller;

import business.Counter;
import data.CounterDB;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;

public class CounterContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        ArrayList<Counter> counters = CounterDB.selectAllCounters();
        sc.setAttribute("counters",counters);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //Do nothing
    }
}
