package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public abstract class Db<T> {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    //private static final String PASSWORD = "nidokingdiogo";
    private static final String DBNAME = "mproducts";
    //private static final String WHERE = "localhost";
    private static final String WHERE = "XXX";

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet resultSet = null;


    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Properties properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
        properties.setProperty("useSSL", "false");
        properties.setProperty("serverTimezone", Calendar.getInstance().getTimeZone().getID());

        //localhost
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBNAME,properties);
        //RDS
        //conn = DriverManager.getConnection("jdbc:mysql://" + WHERE + ":3306/" + DBNAME,properties);

        return conn;
    }

    private void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        try {
            close(conn, stmt, rs);
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexao.");
            e.printStackTrace();
        }
    }

    private void close(Connection conn, Statement stmt, ResultSet rs) {

        try {

            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {

                stmt.close();

            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao fechar conexao.");
            e.printStackTrace();
        }
    }


    //UTIL

    protected ResultSet runSQL(String sql) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        conn = connect();

        try {
            stmt = conn.prepareStatement(sql);
            resultSet = stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("sql: " + e.getMessage());
        }
        return resultSet;
    }

    protected boolean runUpdateSQL(String sql) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        conn = connect();
        int result = 0;

        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql: " + e.getMessage());
        }
        return result > 0;
    }

    protected void close() {
        closeConnection(conn, stmt, resultSet);
    }

    protected String generateUID(){
        return UUID.randomUUID().toString().replace("-","");
    }


    //COMMON

    protected abstract List<?> getAll();
    protected abstract List<?> getAll(String orderBy);
    protected abstract Object get(String uid);
    protected abstract boolean delete(String uid);
    protected abstract boolean update(T obj);
    protected abstract boolean add(T obj);

}
