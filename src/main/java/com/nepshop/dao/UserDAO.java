package com.nepshop.dao;

import com.nepshop.model.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import org.apache.commons.codec.binary.Base64;
import java.util.List;

public class UserDAO {
    static Connection conn = DBConnectionUtil.getConnection();

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String query = "select * from users";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String gender = rs.getString("gender");

                Blob blob = rs.getBlob("photo");
                User s = null;
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
                    s = new User(id, name, email, password, gender, photo);
                } else {
                    s = new User(id, name, email, password, gender);
                }
                users.add(s);
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return users;
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

    public static boolean createUser(String name, String email, String password, String gender,
            InputStream inputStream) {
        String query = "insert into users(name, email, password, gender, photo) values(?, ? ,?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, gender);
            ps.setBlob(5, inputStream);
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

    public static boolean updateUser(int id, String name, String email, String password, String gender) {
        String query = "update users set name = ?, email = ? , password = ?, gender = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, gender);
            ps.setInt(5, id);
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

    public static boolean updateUser(int id, String name, String email, String password, String gender,
            InputStream inputStream) {
        String query = "update users set name = ?, email = ? , password = ?, gender = ?, photo = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, gender);
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

    public static boolean deleteUser(int id) {
        String query = "delete from users where id = ?";
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

    public static User getUser(int id) {
        String query = "select * from users where id=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String gender = rs.getString("gender");

                return new User(id, name, email, password, gender);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static boolean checkPassword(int id, String password) {
        String query = "select * from users where id = ? and password = ?";
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

    public static boolean updateAcInfo(int id, String name, String email, String gender, InputStream inputStream) {
        String query = "update users set name = ?, email = ?, gender = ?, photo = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, gender);
            ps.setBlob(4, inputStream);
            ps.setInt(5, id);
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

    public static boolean updateAcInfo(int id, String name, String email, String gender) {
        String query = "update users set name = ?, email = ?, gender = ? where id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, gender);
            ps.setInt(4, id);
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
        String queryCheck = "select * from users where id = ? and password = ?";
        String queryUpdate = "update users set password = ? where id = ?";
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
        String queryCheck = "select * from users where id = ? and password = ?";
        String queryDelete = "delete from users where id = ?";
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
        String query = "select * from users where id=?";
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
        String query = "select * from users where id=?";
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
