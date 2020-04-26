package controller;

import business.employee.CounterStaff;
import data.StaffDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StaffController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_name = req.getUserPrincipal().getName();
        String url = "/staff/index.jsp";
        CounterStaff counterStaff = StaffDB.selectStaffwithUserName(user_name);
        HttpSession session = req.getSession();
        session.setAttribute("staff",counterStaff);
        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }
}
