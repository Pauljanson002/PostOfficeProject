package controller;

import business.Customer;
import business.post.Post;
import data.PostDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class PostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        ArrayList<Post> posts = PostDB.selectAllPostsWithCustomer(customer);
        req.setAttribute("posts",posts);
        getServletContext().getRequestDispatcher("/customer/posts.jsp").forward(req,resp);
    }


}
