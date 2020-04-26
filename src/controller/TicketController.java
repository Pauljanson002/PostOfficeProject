package controller;

import business.Counter;
import business.Customer;
import business.Ticket;
import business.employee.CounterStaff;
import data.CounterDB;
import data.CustomerDB;
import data.TicketDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class TicketController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ticket ticket = new Ticket();


        // Just for now
        CounterStaff counterStaff = new CounterStaff();
        counterStaff.setId(1);
        Customer customer = CustomerDB.selectCustomer(Integer.parseInt(req.getParameter("icNumber")));
        if(customer == null){
            System.out.println("No customer found");
            customer  = new Customer();
            customer.setId(Integer.parseInt(req.getParameter("icNumber")));
            customer.setFirstName(req.getParameter("firstName"));
            customer.setLastName(req.getParameter("lastName"));
            CustomerDB.createCustomer(customer);

        }
        //
        ticket.setCounterStaff(counterStaff);
        ticket.setCustomer(customer);
        ticket.setReason(req.getParameter("service"));
        ticket = TicketDB.createTicket(ticket);

        Counter counter = getCounter(req.getParameter("reason"));
        counter.addTicket(ticket);
        HttpSession session = req.getSession();
        session.setAttribute("ticket",ticket);
        session.setAttribute("customer",customer);
        req.setAttribute("counter",counter);
        getServletContext().getRequestDispatcher("/ticket_confirmed.jsp").forward(req,resp);
    }

    public Counter getCounter(String reason){
//        Counter counter = CounterDB.getCounterByReason(reason);
        ArrayList<Counter> counters = (ArrayList<Counter>) getServletContext().getAttribute("counters");
        for(Counter c: counters){
            if (c.getReason().equals(reason)){
                return c;
            }
        }
        return null;
    }
    
}
