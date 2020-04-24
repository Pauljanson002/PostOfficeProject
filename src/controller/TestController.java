package controller;

import business.TestUser;
import data.testDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestUser user = testDB.selectUsers();
        req.setAttribute("user",user);
        getServletContext().getRequestDispatcher("/test.jsp").forward(req,resp);
    }
}
