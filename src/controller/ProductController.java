package controller;

import business.Customer;
import business.Product;
import business.SaleRequest;
import data.ProductDB;
import data.SaleRequestDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> products = ProductDB.selectAll();
        req.setAttribute("products",products);
        String url = "/customer/sales/products.jsp";
        req.getServletContext().getRequestDispatcher(url).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<Product> products = ProductDB.selectAll();
        SaleRequest saleRequest = new SaleRequest();
        int totalAmount = 0;
        HashMap<String,Integer> itemBought = new HashMap<>();
        for(Product product:products){
            int qtBought = Integer.parseInt(req.getParameter(String.valueOf(product.getId())));
            product.setQty(product.getQty()-qtBought);
            itemBought.put(product.getName(),qtBought);
            totalAmount+=(qtBought*product.getPrice());
        }
        ProductDB.updateAll(products);
        System.out.println("updated");
        saleRequest.setAmount(totalAmount);
        saleRequest.setCustomer((Customer) session.getAttribute("customer"));
        saleRequest.setProducts(itemBought);
        saleRequest.setDate(new Date(new java.util.Date().getTime()));
        SaleRequestDB.insert(saleRequest);


        resp.sendRedirect("/Customer/customer/sales");
    }
}
