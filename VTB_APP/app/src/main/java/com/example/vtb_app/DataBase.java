package com.example.vtb_app;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private Connection connection;

    private final String host = "10.0.2.2";

    private final String database = "VTB_MOBILE";
    private final int port = 5432;
    private final String user = "postgres";
    private final String pass = "1";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public DataBase() throws SQLException {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        //this.disconnect();
        System.out.println("connection status:" + status);
    }

    private void connect() throws SQLException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);

                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }

        DatabaseMetaData metaData = connection.getMetaData();

        try (ResultSet rs = metaData.getTables(null, null, "%", null)) {

            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCount = rsMeta.getColumnCount();

            while (rs.next()) {

                System.out.println("\n----------");
                System.out.println(rs.getString("TABLE_NAME"));
                System.out.println("----------");

                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsMeta.getColumnName(i);
                    System.out.format("%s:%s\n", columnName, rs.getString(i));
                }

            }
        }

    }


    public Connection getExtraConnection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    public void getAllUsers() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users;");
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean getUser(String email, String name) throws SQLException{

        int size =0;
        String sqlquery = "SELECT users.email, users.name from users WHERE users.email = ? and users.name = ?";
        PreparedStatement pstmt = connection.prepareStatement(sqlquery, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        pstmt.setString(1,email);
        pstmt.setString(2,name);

        System.out.println(pstmt);
        ResultSet affectedRows = pstmt.executeQuery();
        System.out.println(affectedRows.getFetchSize());

        if (affectedRows != null)
        {
            affectedRows.last();    // moves cursor to the last row
            size = affectedRows.getRow(); // get row id
        }

        if (size>0){
            return true;
        }else {
            return false;
        }

    }

    public boolean putUser(String email, String name) throws SQLException {
        if (!getUser(email, name)) {
            String sqlquery = "INSERT INTO users VALUES (?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sqlquery,
                    Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, email);
            pstmt.setString(2, name);

            int affectedRows = pstmt.executeUpdate();
            return true;
        } else {
            int size =0;

            String sqlquery = "SELECT users.email, users.name from users WHERE users.email = ? and users.name = ?";
            PreparedStatement pstmt = connection.prepareStatement(sqlquery, ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1,email);
            pstmt.setString(2,name);


            System.out.println(pstmt);
            ResultSet affectedRows = pstmt.executeQuery();
            System.out.println(affectedRows.getFetchSize());

            if (affectedRows != null)
            {
                affectedRows.last();    // moves cursor to the last row
                size = affectedRows.getRow(); // get row id
            }

            if (size>0){
                return true;
            }else {
                return false;
            }
        }
    }
}
