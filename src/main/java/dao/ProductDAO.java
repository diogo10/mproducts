package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Product;
import util.Db;

public class ProductDAO extends Db<Product> {

    @Override
    public List<Product> getAll() {


        String sql = "SELECT * FROM product order by created DESC;";
        List<Product> list = new ArrayList<>();

        try {
            ResultSet result = runSQL(sql);

            while (result.next()) {
                Product pro = new Product();
                pro.setName(result.getString("name"));
                pro.setCategory(result.getString("category"));
                pro.setPrice(result.getDouble("price"));
                pro.setCurrentStock(result.getInt("currentStock"));
                pro.setEnable(result.getInt("enable") == 1);
                pro.setUid(result.getString("uid"));
                pro.setCreated(result.getTimestamp("created"));
                pro.setUpdated(result.getTimestamp("updated"));
                list.add(pro);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            close();
        }

        return list;
    }

    @Override
    public List<Product> getAll(String orderBy) {


        String sql = "SELECT * FROM product order by " + orderBy  +" DESC;";
        List<Product> list = new ArrayList<>();

        try {
            ResultSet result = runSQL(sql);

            while (result.next()) {
                Product pro = new Product();
                pro.setName(result.getString("name"));
                pro.setCategory(result.getString("category"));
                pro.setPrice(result.getDouble("price"));
                pro.setCurrentStock(result.getInt("currentStock"));
                pro.setEnable(result.getInt("enable") == 1);
                pro.setUid(result.getString("uid"));
                pro.setCreated(result.getTimestamp("created"));
                pro.setUpdated(result.getTimestamp("updated"));
                list.add(pro);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            close();
        }

        return list;
    }

    @Override
    public Product get(String uid) {

        String sql = "SELECT * FROM product WHERE uid = '" + uid + "'";
        Product pro = null;

        try {
            ResultSet result = runSQL(sql);
            result.next();

            pro = new Product();
            pro.setName(result.getString("name"));
            pro.setCategory(result.getString("category"));
            pro.setPrice(result.getDouble("price"));
            pro.setCurrentStock(result.getInt("currentStock"));
            pro.setEnable(result.getInt("enable") == 1);
            pro.setUid(result.getString("uid"));
            pro.setCreated(result.getTimestamp("created"));
            pro.setUpdated(result.getTimestamp("updated"));


        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            close();
        }


        return pro;
    }

    @Override
    public boolean delete(String uid) {
        //TODO: create this method
        return false;
    }

    @Override
    public boolean update(Product product) {

        StringBuilder stringBuilder = new StringBuilder("UPDATE product set");
        stringBuilder.append(" name = '");
        stringBuilder.append(product.getName()).append("'");
        stringBuilder.append(" ,category = '");
        stringBuilder.append(product.getCategory()).append("'");
        stringBuilder.append(" ,price = '");
        stringBuilder.append(product.getPrice()).append("'");
        stringBuilder.append(" ,updated = '");
        stringBuilder.append(new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))).append("'");
        stringBuilder.append(" ,currentStock = '");
        stringBuilder.append(product.getCurrentStock()).append("'");
        stringBuilder.append(" ,enable = '");
        stringBuilder.append(product.getEnable() ? 1 : 0).append("'");

        stringBuilder.append(" WHERE uid = '");
        stringBuilder.append(product.getUid());
        stringBuilder.append("'");

        boolean result = false;
        try {
            result = runUpdateSQL(stringBuilder.toString());
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error update: " + e.getMessage());
        } finally {
            close();
        }


        return result;
    }

    public boolean add(Product product) {
        //FIXME: created and update is getting 01 instead of 14 on the hours

        StringBuilder stringBuilder = new StringBuilder("INSERT INTO product (name,");
        stringBuilder.append("category,price,updated,created,currentStock,enable,uid) ");
        stringBuilder.append("VALUES(");
        stringBuilder.append("'").append(product.getName()).append("',");
        stringBuilder.append("'").append(product.getCategory()).append("'");
        stringBuilder.append(",").append(product.getPrice());

        stringBuilder.append(",'").append(new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))).append("','");
        stringBuilder.append(new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis()))).append("',");

        stringBuilder.append(product.getCurrentStock()).append(",");
        stringBuilder.append(product.getEnable() ? 1 : 0).append(",");
        stringBuilder.append("'").append(generateUID()).append("')");

        boolean result = false;
        try {
            result = runUpdateSQL(stringBuilder.toString());
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error add: " + e.getMessage());
        } finally {
            close();
        }


        return result;
    }

    //MOBILE

    public List<Product> mobileGetAll() {


        String sql = "SELECT * FROM product where enable = 1 order by name";
        List<Product> list = new ArrayList<>();

        try {
            ResultSet result = runSQL(sql);

            while (result.next()) {
                Product pro = new Product();
                pro.setName(result.getString("name"));
                pro.setCategory(result.getString("category"));
                pro.setPrice(result.getDouble("price"));
                pro.setUid(result.getString("uid"));
                list.add(pro);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            close();
        }

        return list;
    }

}
