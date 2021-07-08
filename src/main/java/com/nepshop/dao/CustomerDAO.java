package com.nepshop.dao;

import com.nepshop.model.Customer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import org.apache.commons.codec.binary.Base64;
import java.util.List;

public class CustomerDAO {
    static Connection conn = DBConnectionUtil.getConnection();

    public static List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "select * from customer";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                Blob blob = rs.getBlob("photo");
                Customer customer = null;
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
                    customer = new Customer(id, name, email, password, address, phone);
                }
                customers.add(customer);
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return customers;
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

    public static boolean createCustomer(String name, String email, String password, String address, String phone,
            InputStream inputStream) {
        String query = "insert into customer(name, email, password, address, phone, photo) values(?, ? ,?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, address);
            ps.setString(5, phone);
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

    public static boolean updateCustomer(int id, String name, String email, String password, String address,
            String phone) {
        String query = "update customer set name = ?, email = ? , password = ?, address = ?, phone = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, address);
            ps.setString(5, phone);
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

    public static boolean updateCustomer(int id, String name, String email, String password, String address,
            String phone, InputStream inputStream) {
        String query = "update customer set name = ?, email = ? , password = ?, address = ?, phone = ?, photo = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, address);
            ps.setString(5, phone);
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

    public static boolean deleteCustomer(int id) {
        String query = "delete from customer where id = ?";
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

    public static Customer getCustomer(int id) {
        String query = "select * from customer where id=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String phone = rs.getString("phone");

                return new Customer(id, name, email, password, address, phone);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean checkPassword(int id, String password) {
        String query = "select * from customer where id = ? and password = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean updateAcInfo(int id, String name, String email, String address, String phone,
            InputStream inputStream) {
        String query = "update customer set name = ?, email = ?, address = ?, phone = ?, photo = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setBlob(5, inputStream);
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

    public static boolean updateAcInfo(int id, String name, String email, String address, String phone) {
        String query = "update customer set name = ?, email = ?, address = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(5, phone);
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

    public static boolean updateAcPassword(int id, String oldPassword, String newPassword) {
        String queryCheck = "select * from customer where id = ? and password = ?";
        String queryUpdate = "update customer set password = ? where id = ?";
        try (PreparedStatement psCheck = conn.prepareStatement(queryCheck)) {
            psCheck.setInt(1, id);
            psCheck.setString(2, oldPassword);
            ResultSet rsCheck = psCheck.executeQuery();
            while (rsCheck.next()) {
                try (PreparedStatement psUpdate = conn.prepareStatement(queryUpdate)) {
                    psUpdate.setString(1, newPassword);
                    psUpdate.setInt(2, id);
                    int rsUpdate = psUpdate.executeUpdate();
                    if (rsUpdate > 0)
                        return true;
                    else
                        return false;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean deleteAc(int id, String password) {
        String queryCheck = "select * from customer where id = ? and password = ?";
        String queryDelete = "delete from customer where id = ?";
        try (PreparedStatement psCheck = conn.prepareStatement(queryCheck)) {
            psCheck.setInt(1, id);
            psCheck.setString(2, password);
            ResultSet rsCheck = psCheck.executeQuery();
            while (rsCheck.next()) {
                try (PreparedStatement psDelete = conn.prepareStatement(queryDelete)) {
                    psDelete.setInt(1, id);
                    int rsDelete = psDelete.executeUpdate();
                    if (rsDelete > 0)
                        return true;
                    else
                        return false;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static String getPhoto(int id) {
        String query = "select * from customer where id=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
                    return photo;
                }
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String getPassword(int id) {
        String query = "select * from customer where id=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String password = rs.getString("password");
                return password;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
