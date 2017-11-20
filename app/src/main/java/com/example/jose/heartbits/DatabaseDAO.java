package com.example.jose.heartbits;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by jose on 19-11-2017.
 */

public class DatabaseDAO extends Thread {
    String url = "jdbc:mysql://192.168.137.1:3306/heartbits";
    String username = "root";
    String password = "";


    public DatabaseDAO() throws SQLException {
    }

    public void run() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =DriverManager.getConnection(url, username, password);
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM heartbits.cama");
            int i=0;
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = rs.getMetaData().getColumnCount();
            for (i = 1; i <= columnCount; i++) {
                System.out.print(metadata.getColumnName(i) + ", ");
            }
            System.out.println();
            while (rs.next()) {
                String row = "";
                for (i = 1; i <= columnCount; i++) {
                    row += rs.getString(i) + ", ";
                }
                System.out.println(row);

            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

     public void testDbConnection() throws SQLException, ClassNotFoundException {
             try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection con = DriverManager.getConnection("jdbc:mysql://192.168.137.1:3307/heartbits?user=root&password=");

             String result = "Database connection success\n";
             Statement st = con.createStatement();

             ResultSet rs = st.executeQuery("select * from cama ");
             ResultSetMetaData rsmd = rs.getMetaData();
     } catch (Exception e) {
        e.printStackTrace();
    }
}

    protected String doInBackground(String... strings) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection =DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Database connected!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM heartbits.cama");
            int i=0;
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = rs.getMetaData().getColumnCount();
            for (i = 1; i <= columnCount; i++) {
                System.out.print(metadata.getColumnName(i) + ", ");
            }
            System.out.println();
            while (rs.next()) {
                String row = "";
                for (i = 1; i <= columnCount; i++) {
                    row += rs.getString(i) + ", ";
                }
                System.out.println(row);

            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}