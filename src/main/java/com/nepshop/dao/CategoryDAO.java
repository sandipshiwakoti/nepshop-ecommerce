package com.nepshop.dao;

import com.nepshop.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    static Connection conn = DBConnectionUtil.getConnection();

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        String query = "select * from category";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                Category category = new Category(id, name, description);
                categories.add(category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categories;
    }

    public static boolean createCategory(String name, String description) {
        String query = "insert into category(name, description) values(?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, description);
            int rs = ps.executeUpdate();
            if (rs > 0)
                return true;
            else
                return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean updateCategory(int id, String name, String description) {
        String query = "update category set name = ?, description = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, id);
            int rs = ps.executeUpdate();
            if (rs > 0)
                return true;
            else
                return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean deleteCategory(int id) {
        String query = "delete from category where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0)
                return true;
            else
                return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static Category getCategory(int id) {
        String query = "select * from category where id=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");

                return new Category(id, name, description);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
