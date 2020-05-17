package controller;

import business.Counter;
import business.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class TicketProcessController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Counter counter = (Counter) session.getAttribute("counter");
        String url = "/staff";
        if(counter.getNumber() == 1){
            if(counter.getAvailableTickets()>=1){
            Ticket ticket = counter.removeTicket();
            req.setAttribute("ticket",ticket);
            url = "/staff/foreign-post-process.jsp";}
            else{
                url = "/staff";
            }
        }
        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }

}
