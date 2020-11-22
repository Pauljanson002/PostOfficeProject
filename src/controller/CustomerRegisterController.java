package controller;

import business.Customer;
import data.CustomerDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomerRegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.endsWith("/settings")){
            Customer customer = (Customer) req.getSession().getAttribute("customer");
            customer.setFirstName(req.getParameter("firstName"));
            customer.setLastName(req.getParameter("lastName"));
            customer.setUserName(req.getParameter("userName"));
            CustomerDB.update(customer,req.getParameter("passWord"));
            resp.sendRedirect("/Customer/customer");
        }
        else {
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(req.getParameter("id")));
            customer.setFirstName(req.getParameter("firstName"));
            customer.setLastName(req.getParameter("lastName"));
            CustomerDB.createCustomer(customer,req.getParameter("passWord"));
            resp.sendRedirect("/Customer");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.endsWith("/delete")){
            HttpSession session = req.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            CustomerDB.deleteCustomer(customer.getId());
            session.invalidate();
            resp.sendRedirect("/Customer");

        }
    }
}
