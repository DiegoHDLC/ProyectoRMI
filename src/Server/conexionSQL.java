package Server;

import java.sql.*;
import Client.producto;

public class conexionSQL {
    static Connection con = null;

    public static producto getProducto(int codigo) throws Exception {
        producto prod = new producto();
        PreparedStatement ps;
        ResultSet rs;
        try {
            // conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://137.184.104.85:3306/rmi_remote_bd", "debian-sys-maint", "eNNgOWBO8FNtWfec");
            // sentencia / solicitud
            String query = "SELECT * FROM productos where codigo=" + codigo;
            ps = conexionSQL.con.prepareStatement(query);
            rs = ps.executeQuery();

            // obtencion de datos
            if (rs.next()) {
                prod.setCodigo(Integer.parseInt(rs.getString(1)));
                prod.setNombre(rs.getString(2));
                prod.setStock(Integer.parseInt(rs.getString(3)));
                prod.setValor(Integer.parseInt(rs.getString(4)));
                return prod;
            }
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la base de datos: " + e);
        }
        return null;
    }

}