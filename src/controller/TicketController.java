package controller;

import business.Counter;
import business.Customer;
import business.Ticket;
import business.employee.CounterStaff;
import business.employee.Staff;
import data.CounterDB;
import data.CustomerDB;
import data.StaffDB;
import data.TicketDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class TicketController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Ticket ticket = new Ticket();
        int counterID = Integer.parseInt(req.getParameter("counter"));


        // Just for now
        Staff staff = getStaffWithCounterID(counterID);

        Customer customer = (Customer) session.getAttribute("customer");

        ticket.setStaff(staff);
        ticket.setCustomer(customer);
        ticket.setReason(CounterDB.selectCounterByNumber(counterID).getReason());
        ticket.setCounterId(counterID);
        ticket.setDate(new java.sql.Date(new Date().getTime()));
        TicketDB.createTicket(ticket);
         req.setAttribute("ticket",ticket);
        getServletContext().getRequestDispatcher("/customer/ticket_confirmed.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String url = "/customer/tickets.jsp";
        Customer customer = (Customer) session.getAttribute("customer");
        ArrayList<Ticket> tickets = TicketDB.selectTicketswithCustomerId(customer.getId());
        req.setAttribute("tickets",tickets);
        req.getServletContext().getRequestDispatcher(url).forward(req,resp);
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
    private Staff getStaffWithCounterID(int counterId){
        return StaffDB.selectStaffWithCounterID(counterId);
    }
    
}
