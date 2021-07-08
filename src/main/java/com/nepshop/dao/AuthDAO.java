package com.nepshop.dao;

import com.nepshop.model.Customer;
import com.nepshop.model.User;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class AuthDAO {
    static Connection conn = DBConnectionUtil.getConnection();

    public static User loginUser(String email, String password) {
        User user = null;
        String query = "select * from users where email = ? and password =  ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");

                Blob blob = rs.getBlob("photo");
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
                    String photo = "data:image/jpg;base64," + base64String;
                    user = new User(id, name, email, password, gender, photo);
                } else {
                    user = new User(id, name, email, password, gender, null);
                }
                return user;
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public static boolean createUser(String name, String email, String password, String gender) {
        String query = "insert into users(name, email, password, gender) values(?, ? ,?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, gender);
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

    public static Customer loginCustomer(String email, String password) {
        Customer customer = null;
        String query = "select * from customer where email = ? and password =  ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                Blob blob = rs.getBlob("photo");
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
                    String photo = "data:image/jpg;base64," + base64String;
                    customer = new Customer(id, name, email, password, address, phone, photo);
                } else {
                    customer = new Customer(id, name, email, password, address, phone, null);
                }
                return customer;
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    public static boolean createCustomer(String name, String email, String password, String address, String phone) {
        String query = "insert into customer(name, email, password, address, phone) values(?, ? ,?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, address);
            ps.setString(5, phone);
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
}
