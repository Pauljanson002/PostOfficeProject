package controller;

import business.employee.PostMaster;
import business.employee.Staff;
import data.SaleRequestDB;
import data.StaffDB;
import data.TicketDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MasterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/master/index.jsp";
        System.out.println(req.getRequestURI());
        if(req.getRequestURI().endsWith("/employees")){
            String id = req.getParameter("id");
            if(id!=null){
                Staff staff = StaffDB.selectStaffwithId(Integer.parseInt(id),null);
                req.setAttribute("staff",staff);
                url = "/master/showStaff.jsp";

            }
            else{
                System.out.println("hit");
                List<Staff> staffs = StaffDB.selectAllStaffs();
                req.setAttribute("employees",staffs);
                url = "/master/employeeTable.jsp";
            }
        } else{
            String userName = req.getUserPrincipal().getName();
            Staff staff = StaffDB.selectStaffwithUserName(userName);
            PostMaster master = null;
            master = (PostMaster) StaffDB.selectStaffwithUserName(userName);
            HttpSession session = req.getSession();
            ArrayList<Integer> report = SaleRequestDB.getLastYearReport();
            ArrayList<Integer> ticketReport = TicketDB.getLastYearReport();
            req.setAttribute("report",report);
            req.setAttribute("ticketReport",ticketReport);
            session.setAttribute("master",master);
        }
        System.out.println(req.getRequestURI());
        getServletContext().getRequestDispatcher(url).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/master/employees";
        if(req.getRequestURI().endsWith("/employees")) {
            String id = req.getParameter("id");
            if (id != null) {
                Staff staff = new Staff();
                staff.setFirstName(req.getParameter("firstName"));
                staff.setLastName(req.getParameter("lastName"));
                staff.setRoleName(req.getParameter("roleName"));
                staff.setId(Integer.parseInt(req.getParameter("id")));
                staff.setUserName(req.getParameter("userName"));
                StaffDB.update(staff);
                System.out.println("staff update done");
            }
        }else if(req.getRequestURI().endsWith("/add")){
                Staff staff = new Staff();
                staff.setId(Integer.parseInt(req.getParameter("id")));
                staff.setFirstName(req.getParameter("firstName"));
                staff.setLastName(req.getParameter("lastName"));
                staff.setRoleName(req.getParameter("roleName"));
                staff.setUserName(req.getParameter("userName"));
                StaffDB.insert(staff);
                System.out.println("Staff inserted ");
            }

        resp.sendRedirect(req.getContextPath()+"/master/employees");

    }


}
