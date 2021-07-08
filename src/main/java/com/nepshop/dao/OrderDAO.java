package com.nepshop.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.nepshop.model.OrderedProduct;

import org.apache.commons.codec.binary.Base64;

public class OrderDAO {
    static Connection conn = DBConnectionUtil.getConnection();

    public static int createOrder(Double total_cost, int customer_id, String shipping_address, String phone,
            String payment_method) {
        int order_id = 0;
        String query = "insert into orders(total_cost, customer_id, shipping_address, phone, payment_method) values(?, ? ,?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDouble(1, total_cost);
            ps.setInt(2, customer_id);
            ps.setString(3, shipping_address);
            ps.setString(4, phone);
            ps.setString(5, payment_method);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                order_id = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order_id;
    }

    public static boolean createOrderedProduct(int product_id, int order_id, int quantity) {
        String query = "insert into ordered_product(product_id, order_id, quantity) values(?, ? ,?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, product_id);
            ps.setInt(2, order_id);
            ps.setInt(3, quantity);
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

    public static List<OrderedProduct> getOrderedProduct(int customer_id) {
        List<OrderedProduct> list = new ArrayList<>();
        String query = "select p.photo, p.name, p.company, p.price, op.quantity, od.shipping_address, od.payment_method from ordered_product as op join product as p on p.id = op.product_id join orders as od on od.id = op.order_id join customer as c on c.id = od.customer_id where c.id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, customer_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String company = rs.getString("company");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String shipping_address = rs.getString("shipping_address");
                String payment_method = rs.getString("payment_method");

                Blob blob = rs.getBlob("photo");
                String photo = null;
                OrderedProduct op = null;
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
                op = new OrderedProduct(photo, name, company, price, quantity, shipping_address, payment_method);
                list.add(op);
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
