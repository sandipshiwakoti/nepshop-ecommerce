package com.nepshop.controller;

import com.nepshop.dao.AuthDAO;
import com.nepshop.model.Customer;
import com.nepshop.model.User;

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

@WebServlet("/authservlet")
public class AuthServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("login")) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String role = req.getParameter("role");
            if (role.equalsIgnoreCase("customer")) {
                Customer customer = AuthDAO.loginCustomer(email, password);
                if (customer != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("customer", customer);
                    res.sendRedirect("/includes/ecommerce/customer.jsp");
                } else {
                    setToastMessage(req, "Login failed", "error");
                    RequestDispatcher rd = req.getRequestDispatcher("/includes/ecommerce/login.jsp");
                    rd.forward(req, res);
                }
            } else if (role.equalsIgnoreCase("admin")) {
                User user = AuthDAO.loginUser(email, password);
                if (user != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    res.sendRedirect("/includes/dashboard/home.jsp");
                } else {
                    setToastMessage(req, "Login failed", "error");
                    RequestDispatcher rd = req.getRequestDispatcher("/includes/ecommerce/login.jsp");
                    rd.forward(req, res);
                }
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("logout")) {
            HttpSession session = req.getSession();
            session.removeAttribute("user");
            session.removeAttribute("customer");
            session.invalidate();
            setToastMessage(req, "You have successfully logged out of the application.", "success");
            RequestDispatcher rd = req.getRequestDispatcher("/includes/ecommerce/login.jsp");
            rd.forward(req, res);
        }
    }

    void setToastMessage(HttpServletRequest req, String message, String type) {
        HttpSession session = req.getSession();
        List<String> toast = new ArrayList<String>(Arrays.asList(message, type));
        session.setAttribute("toast", toast);
    }
}
