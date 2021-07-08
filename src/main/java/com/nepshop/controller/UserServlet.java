package com.nepshop.controller;

import com.nepshop.dao.UserDAO;
import com.nepshop.model.User;

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

@WebServlet(urlPatterns = "/userservlet", loadOnStartup = 1)
@MultipartConfig(maxFileSize = 16177215)
public class UserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String action = req.getParameter("action");
        if (action.equals("list")) {
            setUsers(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/user.jsp");
            rd.forward(req, res);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(req.getParameter("id"));
            boolean rs = UserDAO.deleteUser(id);
            RequestDispatcher rd = null;
            if (rs) {
                HttpSession session = req.getSession();
                User user = (User) session.getAttribute("user");
                int userId = user.getId();
                if (userId == id) {
                    session.removeAttribute("user");
                    // session.invalidate();
                    setToastMessage(req, "Your account is successfully deleted.", "success");
                    rd = req.getRequestDispatcher("/includes/ecommerce/login.jsp");
                } else {
                    setUsers(req);
                    setToastMessage(req, "User is successfully deleted.", "success");
                    rd = req.getRequestDispatcher("/includes/dashboard/user.jsp");
                }
            } else {
                setUsers(req);
                setToastMessage(req, "User cannot be deleted right now. Please try again later.", "error");
                rd = req.getRequestDispatcher("/includes/dashboard/user.jsp");
            }
            rd.forward(req, res);
        } else if (action.equals("populate")) {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = UserDAO.getUser(id);
            req.setAttribute("user", user);
            req.setAttribute("flag", true);
            setUsers(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/user.jsp");
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
            String gender = req.getParameter("gender");
            Part filePart = req.getPart("photo");
            boolean rs = false;
            if (filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                rs = UserDAO.createUser(name, email, password, gender, inputStream);
            } else {
                rs = UserDAO.createUser(name, email, password, gender);
            }
            if (rs) {
                setToastMessage(req, "User is successfully created.", "success");
            } else {
                setToastMessage(req, "User cannot be created right now. Please try again later.", "error");
            }
            setUsers(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/user.jsp");
            rd.forward(req, res);
        } else if (action.equals("update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String gender = req.getParameter("gender");
            Part filePart = req.getPart("photo");
            boolean rs = false;
            if (filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                rs = UserDAO.updateUser(id, name, email, password, gender, inputStream);
            } else {
                rs = UserDAO.updateUser(id, name, email, password, gender);
            }
            if (rs) {
                setToastMessage(req, "User is successfully updated.", "success");
            } else {
                setToastMessage(req, "User cannot be updated right now. Please try again later.", "error");
            }
            HttpSession session = req.getSession();
            User sessionUser = (User) session.getAttribute("user");
            if (sessionUser.getId() == id) {
                String photo = UserDAO.getPhoto(id);
                User user = new User(id, name, email, password, gender, photo);
                session.setAttribute("user", user);
            }
            setUsers(req);
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/user.jsp");
            rd.forward(req, res);
        } else if (action.equals("update_ac_info")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String gender = req.getParameter("gender");
            Part filePart = req.getPart("photo");
            boolean rs = false;
            if (filePart.getSize() > 0) {
                InputStream inputStream = filePart.getInputStream();
                rs = UserDAO.updateAcInfo(id, name, email, gender, inputStream);
            } else {
                rs = UserDAO.updateAcInfo(id, name, email, gender);
            }
            if (rs) {
                HttpSession session = req.getSession();
                String password = UserDAO.getPassword(id);
                String photo = UserDAO.getPhoto(id);
                User user = new User(id, name, email, password, gender, photo);
                session.setAttribute("user", user);
                setToastMessage(req, "Your account information is successfully updated.", "success");
            } else {
                setToastMessage(req, "Your account information cannot be updated right now. Please try again later.",
                        "error");
            }
            res.sendRedirect("/includes/dashboard/accountsettings.jsp");
        } else if (action.equals("update_ac_password")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String oldPassword = req.getParameter("old-password");
            String newPassword = req.getParameter("new-password");
            boolean rs = UserDAO.updateAcPassword(id, oldPassword, newPassword);
            if (rs) {
                setToastMessage(req, "Your account password is successfully changed.", "success");
            } else {
                setToastMessage(req, "The current password you have entered is incorrect.", "error");
            }
            RequestDispatcher rd = req.getRequestDispatcher("/includes/dashboard/accountsettings.jsp");
            rd.forward(req, res);
        } else if (action.equals("delete_ac")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String password = req.getParameter("password");
            boolean rs = UserDAO.deleteAc(id, password);
            RequestDispatcher rd = null;

            PrintWriter out = res.getWriter();
            out.println(rs);
            HttpSession session = req.getSession();
            if (rs) {
                session.removeAttribute("user");
                // session.invalidate();
                setToastMessage(req, "Your account is successfully deleted.", "success");
                rd = req.getRequestDispatcher("/includes/ecommerce/login.jsp");
            } else {
                setToastMessage(req, "The current password you have entered is incorrect.", "error");
                rd = req.getRequestDispatcher("/includes/dashboard/accountsettings.jsp");
            }
            rd.forward(req, res);
        }
    }

    void setUsers(HttpServletRequest req) {
        List<User> users = UserDAO.getUsers();
        req.setAttribute("users", users);
    }

    void setToastMessage(HttpServletRequest req, String message, String type) {
        HttpSession session = req.getSession();
        List<String> toast = new ArrayList<String>(Arrays.asList(message, type));
        session.setAttribute("toast", toast);
    }
}