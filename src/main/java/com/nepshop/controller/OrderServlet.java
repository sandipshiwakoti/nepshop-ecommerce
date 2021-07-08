package com.nepshop.controller;

import com.nepshop.dao.OrderDAO;
import com.nepshop.model.Order;
import com.nepshop.model.OrderedProduct;
import com.nepshop.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/orderservlet")
public class OrderServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        int customer_id = customer.getId();
        String action = req.getParameter("action");
        if (action.equals("order")) {
            String shipping_address = req.getParameter("shipping_address");
            String phone = req.getParameter("phone");
            String payment_method = req.getParameter("payment_method");
            Double total_cost = Double.parseDouble(req.getParameter("total_cost"));
            String quantityList[] = req.getParameter("quantity_list").split(",");
            ;
            String productidList[] = req.getParameter("productid_list").split(",");
            int order_id = OrderDAO.createOrder(total_cost, customer_id, shipping_address, phone, payment_method);
            if (order_id != 0) {
                for (int i = 0; i < quantityList.length; i++) {
                    int product_id = Integer.parseInt(productidList[i]);
                    int quantity = Integer.parseInt(quantityList[i]);
                    System.out.println(product_id + " " + quantity);
                    boolean rs = OrderDAO.createOrderedProduct(product_id, order_id, quantity);
                    if (rs) {
                        session.setAttribute("flag", true);
                    }
                }
            }
            RequestDispatcher rd = req.getRequestDispatcher("/includes/ecommerce/customer.jsp");
            rd.forward(req, res);
        } else if (action.equals("display_ordered_products")) {
            List<OrderedProduct> orderedProducts = OrderDAO.getOrderedProduct(customer_id);
            session.setAttribute("flag", false);
            session.setAttribute("orderedProducts", orderedProducts);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/ecommerce/orderedproduct.jsp");
            rd.forward(req, res);
        }
    }

    void setToastMessage(HttpServletRequest req, String message, String type) {
        HttpSession session = req.getSession();
        List<String> toast = new ArrayList<String>(Arrays.asList(message, type));
        session.setAttribute("toast", toast);
    }
}
