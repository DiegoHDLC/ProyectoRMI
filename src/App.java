import java.util.List;

import connection.funcionesSQL;

public class App {
    public static void main(String[] args) throws Exception {
        funcionesSQL funciones = new funcionesSQL();
        List<String> lista = funciones.obtenerDatos(182920191);
        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
        System.out.println(lista.get(3));
    }
}
