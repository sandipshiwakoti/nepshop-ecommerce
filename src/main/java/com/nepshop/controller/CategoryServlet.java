package com.nepshop.controller;

import com.nepshop.dao.CategoryDAO;
import com.nepshop.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/categoryservlet", loadOnStartup = 1)
public class CategoryServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getParameter("action");
        if (action.equals("list")) {
            setCategories(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/category.jsp");
            rd.forward(req, res);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean rs = CategoryDAO.deleteCategory(id);
            RequestDispatcher rd = null;
            if (rs) {
                setCategories(req);
                setToastMessage(req, "Category is successfully deleted.", "success");
                rd = req.getRequestDispatcher("/includes/dashboard/category.jsp");
            } else {
                setCategories(req);
                setToastMessage(req, "Category cannot be deleted right now. Please try again later.", "error");
                rd = req.getRequestDispatcher("/includes/dashboard/category.jsp");
            }
            rd.forward(req, res);
        } else if (action.equals("populate")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Category category = CategoryDAO.getCategory(id);
            req.setAttribute("category", category);
            req.setAttribute("flag", true);
            setCategories(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/category.jsp");
            rd.forward(req, res);
        } else if (action.equals("display-categories")) {
            setCategories(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/ecommerce/products.jsp");
            rd.forward(req, res);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("create")) {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            System.out.println(name + " " + description);
            boolean rs = CategoryDAO.createCategory(name, description);
            if (rs) {
                setToastMessage(req, "Category is successfully created.", "success");
            } else {
                setToastMessage(req, "Category cannot be created right now. Please try again later.", "error");
            }
            setCategories(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/category.jsp");
            rd.forward(req, res);
        } else if (action.equals("update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            boolean rs = false;
            rs = CategoryDAO.updateCategory(id, name, description);
            if (rs) {
                setToastMessage(req, "Category is successfully updated.", "success");
            } else {
                setToastMessage(req, "Category cannot be updated right now. Please try again later.", "error");
            }
            setCategories(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/category.jsp");
            rd.forward(req, res);
        }
    }

    void setCategories(HttpServletRequest req) {
        List<Category> categories = CategoryDAO.getCategories();
        req.setAttribute("categories", categories);
    }

    void setToastMessage(HttpServletRequest req, String message, String type) {
        HttpSession session = req.getSession();
        List<String> toast = new ArrayList<String>(Arrays.asList(message, type));
        session.setAttribute("toast", toast);
    }
}