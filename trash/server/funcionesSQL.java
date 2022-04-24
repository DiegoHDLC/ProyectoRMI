// package server;

// import java.sql.PreparedStatement;
// import java.sql.ResultSet;

// import client.imensaje;

// public class funcionesSQL implements imensaje {

// public producto getProducto(int codigo) throws Exception {
// producto prod = new producto();
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
// prod.setCodigo(Integer.parseInt(rs.getString(1)));
// prod.setNombre(rs.getString(2));
// prod.setStock(Integer.parseInt(rs.getString(3)));
// prod.setValor(Integer.parseInt(rs.getString(4)));
// return prod;
// }
// }
// } catch (Exception e) {
// System.out.println("Hubo un problema, error: " + e);
// }
// return null;
// }

// }
