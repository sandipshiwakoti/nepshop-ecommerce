package com.nepshop.dao;

import com.nepshop.model.Product;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import org.apache.commons.codec.binary.Base64;
import java.util.List;

public class ProductDAO {
    static Connection conn = DBConnectionUtil.getConnection();

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String query = "select * from product";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                int categoryId = rs.getInt("category_id");
                String company = rs.getString("company");

                Blob blob = rs.getBlob("photo");
                Product product = null;
                String photo = null;
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    byte[] imageBytes = outputStream.toByteArray();
                    String base64String = new String(Base64.encodeBase64(imageBytes));
                    photo = "data:image/jpg;base64," + base64String;
                }
                product = new Product(id, name, description, price, categoryId, company, photo);
                products.add(product);
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public static List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> products = new ArrayList<>();
        String query = "select * from product where category_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                String company = rs.getString("company");

                Blob blob = rs.getBlob("photo");
                Product product = null;
                String photo = null;
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    byte[] imageBytes = outputStream.toByteArray();
                    String base64String = new String(Base64.encodeBase64(imageBytes));
                    photo = "data:image/jpg;base64," + base64String;
                }
                product = new Product(id, name, description, price, categoryId, company, photo);
                products.add(product);
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public static List<Product> getProductsByName(String searchField) {
        List<Product> products = new ArrayList<>();
        String query = "select * from product where name like ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, "%" + searchField + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                int categoryId = rs.getInt("category_id");
                String company = rs.getString("company");

                Blob blob = rs.getBlob("photo");
                Product product = null;
                String photo = null;
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    byte[] imageBytes = outputStream.toByteArray();
                    String base64String = new String(Base64.encodeBase64(imageBytes));
                    photo = "data:image/jpg;base64," + base64String;
                }
                product = new Product(id, name, description, price, categoryId, company, photo);
                products.add(product);
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public static boolean createProduct(String name, String description, Double price, int categoryId, String company,
            InputStream inputStream) {
        String query = "insert into product(name, description, price, category_id, company, photo) values(?, ? ,?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setInt(4, categoryId);
            ps.setString(5, company);
            ps.setBlob(6, inputStream);
            int rs = ps.executeUpdate();
            if (rs > 0)
                return true;
            else
                return false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean updateProduct(int id, String name, String description, Double price, int categoryId,
            String company) {
        String query = "update product set name = ?, description = ? , price = ?, category_id = ?, company = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setInt(4, categoryId);
            ps.setString(5, company);
            ps.setInt(6, id);
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

    public static boolean updateProduct(int id, String name, String description, Double price, int categoryId,
            String company, InputStream inputStream) {
        String query = "update product set name = ?, description = ? , price = ?, category_id = ?, company = ?, photo = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setDouble(3, price);
            ps.setInt(4, categoryId);
            ps.setString(5, company);
            ps.setBlob(6, inputStream);
            ps.setInt(7, id);
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

    public static boolean deleteProduct(int id) {
        String query = "delete from product where id = ?";
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

    public static Product getProduct(int id) throws IOException {
        String query = "select * from product where id=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                int categoryId = rs.getInt("category_id");
                String company = rs.getString("company");

                Blob blob = rs.getBlob("photo");
                String photo = null;
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    byte[] imageBytes = outputStream.toByteArray();
                    String base64String = new String(Base64.encodeBase64(imageBytes));
                    photo = "data:image/jpg;base64," + base64String;
                }
                return new Product(id, name, description, price, categoryId, company, photo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
