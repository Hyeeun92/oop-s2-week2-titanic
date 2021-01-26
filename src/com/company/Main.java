package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        final String DB_URL = "jdbc:mysql://localhost:3306/titanicmanifest";
        final String DB_USER = "root";
        final String DB_PASSWORD = "ah447Sladl!";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            Statement stmt = con.createStatement();
            String sqlQuery = "select * from titanic";
            ResultSet rs = stmt.executeQuery(sqlQuery);

            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            for (int i = 1; i <= numberOfColumns; i++){
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
            System.out.println();

            while (rs.next())
                System.out.println(rs.getInt(1) + "\t " + rs.getInt(2) + "\t " + rs.getInt(3)  + "\t " + rs.getString(4));
            con.close();

        }
        catch (SQLException e){
            System.out.println(e.toString());
        }
        catch (Exception e) {


        } finally {

        }
    }
}
