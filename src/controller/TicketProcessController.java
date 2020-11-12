package controller;

import business.Counter;
import business.Ticket;
import business.employee.CounterStaff;
import business.employee.Staff;
import business.post.ForeignPost;
import business.post.ParcelPost;
import business.post.TelemailPost;
import business.ticketState.Closed;
import data.PostDB;
import data.PriceTableDB;
import data.TicketDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class TicketProcessController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        Counter counter = (Counter) session.getAttribute("counter");
        CounterStaff counterStaff = (CounterStaff) session.getAttribute("staff");
        Counter counter = counterStaff.getCounter();
        int ticketSize = (int) session.getAttribute("ticketSize");
        ArrayList<Ticket> tickets = (ArrayList<Ticket>) session.getAttribute("tickets");

        String url = "/staff";
        if(ticketSize>=1){
            ticketSize--;
            Ticket ticket = tickets.remove(0);
            session.setAttribute("ticket",ticket);
            switch (counter.getNumber()){
                case 1:
                    url = "/staff/foreign-post-process.jsp";
                    break;
                case 2:
                    url = "/staff/telemail-process.jsp";
                    break;
                case 3:
                    url = "/staff/parcel-process.jsp";

                default:
                    url = "/staff";

            }
        }
        session.setAttribute("tickets",tickets);
        session.setAttribute("ticketSize",ticketSize);
        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeOfPost = req.getParameter("typeOfPost");
        String url = "/staff/payment.jsp";
        HttpSession session = req.getSession();
        Ticket ticket = (Ticket) session.getAttribute("ticket");
//        session.removeAttribute("ticket");
        ticket.setState(Closed.getInstance());
        TicketDB.update(ticket);
        int price = 0;
        switch (typeOfPost){
            case "foreign-post":
                ForeignPost foreignPost = new ForeignPost();
                foreignPost.setCountry(req.getParameter("country"));
                foreignPost.setType(req.getParameter("type"));
                foreignPost.setWeight(Integer.parseInt(req.getParameter("weight")));
                foreignPost.setCustomer(ticket.getCustomer());
                foreignPost.setFromAddress(req.getParameter("fromAddress"));
                foreignPost.setToAddress(req.getParameter("toAddress"));
                foreignPost.setStaff((CounterStaff) ticket.getStaff());
                foreignPost.setTimestamp(new Timestamp(new Date().getTime()));
                PostDB.insert(foreignPost);
                price = PriceTableDB.getPriceWithId(1);
                break;
            case "parcel":
                ParcelPost parcelPost = new ParcelPost();
                parcelPost.setWeight(Integer.parseInt(req.getParameter("weight")));
                parcelPost.setCustomer(ticket.getCustomer());
                parcelPost.setStaff((CounterStaff) ticket.getStaff());
                parcelPost.setFromAddress(req.getParameter("fromAddress"));
                parcelPost.setToAddress(req.getParameter("toAddress"));
                parcelPost.setTimestamp(new Timestamp(new Date().getTime()));
                PostDB.insert(parcelPost);
                price = PriceTableDB.getPriceWithId(2);
                break;
            case "telemail":
                TelemailPost telemailPost = new TelemailPost();
                telemailPost.setCustomer(ticket.getCustomer());
                telemailPost.setStaff((CounterStaff) ticket.getStaff());
                telemailPost.setFromAddress(req.getParameter("fromAddress"));
                telemailPost.setToAddress(req.getParameter("toAddress"));
                telemailPost.setTimestamp(new Timestamp(new Date().getTime()));
                telemailPost.setMessage(req.getParameter("message"));
                PostDB.insert(telemailPost);
                price = PriceTableDB.getPriceWithId(3);
                break;
        }
        req.setAttribute("price",price);
        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }
}
