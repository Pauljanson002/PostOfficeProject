package controller;

import business.employee.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.StaffDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class MasterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = null;
        String action = req.getParameter("action");
        if(action == null){
           url = "/master/index.jsp";
        }else{
            displayEmployees(req,resp);
        }

        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }
    private void displayEmployees(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        List<Staff> staffs = StaffDB.selectAllStaffs();
        Gson gson = new Gson();
        String json = gson.toJson(staffs);
        PrintWriter pw = resp.getWriter();
        pw.println(json);
    }
}
