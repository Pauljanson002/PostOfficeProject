package controller;

import business.Customer;
import data.CustomerDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/customer/index.jsp";
        String user_id = req.getUserPrincipal().getName();
        Customer customer = CustomerDB.selectCustomer(Integer.parseInt(user_id));
        HttpSession session = req.getSession();
        session.setAttribute("customer",customer);
        req.getServletContext().getRequestDispatcher(url).forward(req,resp);

    }


}
