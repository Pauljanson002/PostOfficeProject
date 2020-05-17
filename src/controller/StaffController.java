package controller;

import business.Counter;
import business.employee.CounterStaff;
import data.StaffDB;

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
        String user_name = req.getUserPrincipal().getName();
        String url = "/staff/index.jsp";
        Counter counter = findCounterWithUserName(user_name);
        CounterStaff counterStaff = counter.getStaff();

        HttpSession session = req.getSession();
        session.setAttribute("staff",counterStaff);
        session.setAttribute("counter",counter);
        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }

    private Counter findCounterWithUserName(String userName){
        ArrayList<Counter> counters = (ArrayList<Counter>) getServletContext().getAttribute("counters");
        for(Counter c: counters){
            if(c.getStaff().getUserName().equals(userName)){
                return c;
            }
        }
        return null;
    }
}
