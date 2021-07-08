package com.nepshop.controller;

import com.nepshop.dao.CustomerDAO;
import com.nepshop.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/customerservlet", loadOnStartup = 1)
@MultipartConfig(maxFileSize = 16177215)
public class CustomerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getParameter("action");
        if (action.equals("list")) {
            setCustomers(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/customer.jsp");
            rd.forward(req, res);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean rs = CustomerDAO.deleteCustomer(id);
            RequestDispatcher rd = null;
            if (rs) {
                setCustomers(req);
                setToastMessage(req, "Customer is successfully deleted.", "success");
                rd = req.getRequestDispatcher("/includes/dashboard/customer.jsp");
            } else {
                setCustomers(req);
                setToastMessage(req, "Customer cannot be deleted right now. Please try again later.", "error");
                rd = req.getRequestDispatcher("/includes/dashboard/customer.jsp");
            }
            rd.forward(req, res);
        } else if (action.equals("populate")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Customer customer = CustomerDAO.getCustomer(id);
            req.setAttribute("customer", customer);
            req.setAttribute("flag", true);
            setCustomers(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/customer.jsp");
            rd.forward(req, res);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("create")) {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");
            Part filePart = req.getPart("photo");
            boolean rs = false;
            if (filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                rs = CustomerDAO.createCustomer(name, email, password, address, phone, inputStream);
            } else {
                rs = CustomerDAO.createCustomer(name, email, password, address, phone);
            }
            if (rs) {
                setToastMessage(req, "Customer is successfully created.", "success");
            } else {
                setToastMessage(req, "Customer cannot be created right now. Please try again later.", "error");
            }
            setCustomers(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/customer.jsp");
            rd.forward(req, res);
        } else if (action.equals("update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");
            Part filePart = req.getPart("photo");
            boolean rs = false;
            if (filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                rs = CustomerDAO.updateCustomer(id, name, email, password, address, phone, inputStream);
            } else {
                rs = CustomerDAO.updateCustomer(id, name, email, password, address, phone);
            }
            if (rs) {
                setToastMessage(req, "Customer is successfully updated.", "success");
            } else {
                setToastMessage(req, "Customer cannot be updated right now. Please try again later.", "error");
            }
            setCustomers(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/customer.jsp");
            rd.forward(req, res);
        }
    }

    void setCustomers(HttpServletRequest req) {
        List<Customer> customers = CustomerDAO.getCustomers();
        req.setAttribute("customers", customers);
    }

    void setToastMessage(HttpServletRequest req, String message, String type) {
        HttpSession session = req.getSession();
        List<String> toast = new ArrayList<String>(Arrays.asList(message, type));
        session.setAttribute("toast", toast);
    }
}