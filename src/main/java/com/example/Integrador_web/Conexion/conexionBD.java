package com.example.Integrador_web.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {

    private static String url = "jdbc:postgresql://caboose.proxy.rlwy.net:49680/railway";
    private static String userName = "postgres";
    private static String password = "AJzNSiPAePlEycNSlHesBPLcvhPLRlkZ";
    private static Connection con;

    public static Connection getConexion() throws SQLException {

        con = DriverManager.getConnection(url, userName, password);

        return con;
    }
}
