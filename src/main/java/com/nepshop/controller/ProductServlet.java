package com.nepshop.controller;

import com.nepshop.dao.CategoryDAO;
import com.nepshop.dao.ProductDAO;
import com.nepshop.model.Category;
import com.nepshop.model.Product;

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

@WebServlet(urlPatterns = "/productservlet", loadOnStartup = 1)
@MultipartConfig
public class ProductServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getParameter("action");
        if (action.equals("list")) {
            setProducts(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/product.jsp");
            rd.forward(req, res);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean rs = ProductDAO.deleteProduct(id);
            RequestDispatcher rd = null;
            if (rs) {
                setProducts(req);
                setToastMessage(req, "Product is successfully deleted.", "success");
                rd = req.getRequestDispatcher("/includes/dashboard/product.jsp");
            } else {
                setProducts(req);
                setToastMessage(req, "Product cannot be deleted right now. Please try again later.", "error");
                rd = req.getRequestDispatcher("/includes/dashboard/product.jsp");
            }
            rd.forward(req, res);
        } else if (action.equals("populate")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = ProductDAO.getProduct(id);

            req.setAttribute("product", product);
            req.setAttribute("flag", true);
            setProducts(req);
            // PrintWriter out = res.getWriter();
            // out.println(product.toString());
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/product.jsp");
            rd.forward(req, res);
        } else if (action.equals("display-all-products")) {
            setProducts(req);
            setCategories(req);
            req.setAttribute("categoryName", "all products");
            RequestDispatcher rd = req.getRequestDispatcher("/includes/ecommerce/products.jsp");
            rd.forward(req, res);
        } else if (action.equals("filter-products-by-category")) {
            int categoryId = Integer.parseInt(req.getParameter("category-id"));
            setProductsByCategoryId(req, categoryId);
            setCategories(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/ecommerce/products.jsp");
            rd.forward(req, res);
        } else if (action.equals("display-single-product")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = ProductDAO.getProduct(id);
            req.setAttribute("product", product);
            setCategoryByCategoryId(req, product.getCategoryId());
            RequestDispatcher rd = req.getRequestDispatcher("/includes/ecommerce/singleproduct.jsp");
            rd.forward(req, res);
        } else if (action.equals("search-products-by-name")) {
            String searchField = req.getParameter("search-field");
            setProductsBySearchField(req, searchField);
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
            Double price = Double.parseDouble(req.getParameter("price"));
            int categoryId = Integer.parseInt(req.getParameter("category-id"));
            String company = req.getParameter("company");
            Part filePart = req.getPart("photo");
            boolean rs = false;
            if (filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                rs = ProductDAO.createProduct(name, description, price, categoryId, company, inputStream);
            }
            if (rs) {
                setToastMessage(req, "Product is successfully created.", "success");
            } else {
                setToastMessage(req, "Product cannot be created right now. Please try again later.", "error");
            }
            setProducts(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/product.jsp");
            rd.forward(req, res);
        } else if (action.equals("update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            Double price = Double.parseDouble(req.getParameter("price"));
            int categoryId = Integer.parseInt(req.getParameter("category-id"));
            String company = req.getParameter("company");
            Part filePart = req.getPart("photo");
            boolean rs = false;
            if (filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                rs = ProductDAO.updateProduct(id, name, description, price, categoryId, company, inputStream);
            } else {
                rs = ProductDAO.updateProduct(id, name, description, price, categoryId, company);
            }
            if (rs) {
                setToastMessage(req, "Product is successfully updated.", "success");
            } else {
                setToastMessage(req, "Product cannot be updated right now. Please try again later.", "error");
            }
            setProducts(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/product.jsp");
            rd.forward(req, res);
        }
    }

    void setProducts(HttpServletRequest req) {
        List<Product> products = ProductDAO.getProducts();
        req.setAttribute("products", products);
        setCategories(req);
    }

    void setCategories(HttpServletRequest req) {
        List<Category> categories = CategoryDAO.getCategories();
        req.setAttribute("categories", categories);
    }

    void setProductsByCategoryId(HttpServletRequest req, int categoryId) {
        List<Product> products = ProductDAO.getProductsByCategoryId(categoryId);
        setCategoryByCategoryId(req, categoryId);
        req.setAttribute("products", products);
        if (products.isEmpty()) {
            setToastMessage(req, "Products of this category are not available right now.", "info");
        }
    }

    void setProductsBySearchField(HttpServletRequest req, String searchField) {
        List<Product> products = ProductDAO.getProductsByName(searchField);
        req.setAttribute("products", products);
        if (products.isEmpty()) {
            setToastMessage(req, "The searched product is not avaiable.", "info");
        }
    }

    void setCategoryByCategoryId(HttpServletRequest req, int categoryId) {
        Category activeCategory = CategoryDAO.getCategory(categoryId);
        req.setAttribute("activeCategory", activeCategory);
    }

    void setToastMessage(HttpServletRequest req, String message, String type) {
        HttpSession session = req.getSession();
        List<String> toast = new ArrayList<String>(Arrays.asList(message, type));
        session.setAttribute("toast", toast);
    }
}