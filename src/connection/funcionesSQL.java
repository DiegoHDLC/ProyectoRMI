package connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class funcionesSQL {
    // public void obtenerDatos(int codigo) {
    // PreparedStatement ps;
    // ResultSet rs;
    // try {
    // if (conexionSQL.conectar() == null) {
    // System.out.println("error en la conexion");
    // } else {
    // String query = "SELECT * FROM productos where codigo=" + codigo;
    // ps = conexionSQL.conectar().prepareStatement(query);
    // rs = ps.executeQuery();
    // if (rs.next()) {
    // System.out.println(rs.getString(2));
    // }
    // }
    // } catch (Exception e) {
    // System.out.println("Hubo un problema, error: " + e);
    // }
    // }

    // Metodo para retornar los datos al cliente
    public List<String> obtenerDatos(int codigo) {
        List<String> lista = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        try {
            if (conexionSQL.conectar() == null) {
                System.out.println("error en la conexion");
            } else {
                String query = "SELECT * FROM productos where codigo=" + codigo;
                ps = conexionSQL.conectar().prepareStatement(query);
                rs = ps.executeQuery();
                if (rs.next()) {
                    lista.add(rs.getString(1));
                    lista.add(rs.getString(2));
                    lista.add(rs.getString(3));
                    lista.add(rs.getString(4));
                    return lista;
                }
            }
        } catch (Exception e) {
            System.out.println("Hubo un problema, error: " + e);
        }
        return null;
    }

}
