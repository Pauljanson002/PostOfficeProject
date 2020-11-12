package controller;

import business.Counter;
import business.Product;
import business.SaleRequest;
import business.Ticket;
import business.employee.CounterStaff;
import business.employee.SalesPerson;
import business.employee.Staff;
import business.ticketState.Closed;
import business.util.Notification;
import data.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class StaffController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String url = "/staff/index.jsp";
        if(req.getRequestURI().endsWith("/sales")){
            String user_name = req.getUserPrincipal().getName();
            Staff salesPerson = (Staff) StaffDB.selectStaffwithUserName(user_name);
            url = "/sales/index.jsp";
            ArrayList<SaleRequest> saleRequests = SaleRequestDB.selectAll();
            req.setAttribute("requests",saleRequests);
            session.setAttribute("staff",salesPerson);


        }
        else if (req.getRequestURI().endsWith("/view")){
            int id = Integer.parseInt(req.getParameter("id"));
            SaleRequest saleRequest = SaleRequestDB.selectSaleRequest(id);
            req.setAttribute("request",saleRequest);
            url = "/sales/show.jsp";

        } else if (req.getRequestURI().endsWith("/process")){
            int id = Integer.parseInt(req.getParameter("id"));
            SaleRequest saleRequest = new SaleRequest();
            saleRequest.setId(id);
            saleRequest.setState(Closed.getInstance());
            SaleRequestDB.updateState(saleRequest);
            url = "/sales";
        }

        else {
            String user_name = req.getUserPrincipal().getName();
            Staff counterStaff = (Staff) StaffDB.selectStaffwithUserName(user_name);
            ArrayList<Ticket> tickets = TicketDB.selectOpenTicketsWithStaffID(counterStaff.getId());
            int ticketSize = tickets.size();
        session.setAttribute("ticketSize",ticketSize);
        session.setAttribute("tickets",tickets);
        session.setAttribute("staff",counterStaff);
        }

        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().endsWith("/add")){
            Product product = new Product();
            product.setQty(Integer.parseInt(req.getParameter("qty")));
            product.setPrice(Integer.parseInt(req.getParameter("price")));
            product.setName(req.getParameter("name"));
            ProductDB.insert(product);
        }
        resp.sendRedirect(req.getContextPath()+"/sales");
    }
}
