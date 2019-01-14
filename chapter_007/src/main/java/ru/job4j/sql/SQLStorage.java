package ru.job4j.sql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SQLStorage {
    private static final Logger LOGGER = LogManager.getLogger(SQLStorage.class.getName());

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/car_catalog";
        String username = "postgres";
        String password = "fastin";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("delete from car_catalog where id = ?");

            st.setInt(1, 29);

            st.executeUpdate();
       //     ResultSet generatedKeys = st.getGeneratedKeys();
        //    if (generatedKeys.next()) {
       //         System.out.println(generatedKeys.getInt(1));
       //     }


            //     PreparedStatement st = conn.prepareStatement("SELECT * FROM car_catalog as u where u.id in (?, ?, ?)");
            //     st.setInt(1, 1);
            //     st.setInt(2, 2);
            //     st.setInt(3, 3);
            //     ResultSet rs = st.executeQuery();
            //     while (rs.next()) {
            //        System.out.println(String.format("%s %s", rs.getString("car_name"), rs.getString("body_id")));
            //     }
            //     rs.close();
            //     st.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }
}
