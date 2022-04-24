package connection;

import java.sql.*;

public class conexionSQL {
    static Connection con = null;

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/rmi_database", "root", "");
            System.out.println("Conectado...");
        } catch (Exception e) {
            System.out.println("No se pudo conectar: " + e);
        }
        return con;
    }
}