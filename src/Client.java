import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {
    }

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry(1099);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese codigo de busqueda: ");
            int entrada = sc.nextInt();
            if (entrada == 0) {
                return;
            } else {
                IMensaje stub = (IMensaje) reg.lookup("ObjetoMensaje");
                System.out.println("Cliente solicita datos de: " + entrada);
                System.out.println(stub.enviaMensaje(entrada));

                // producto producto = stub.peticion(entrada); // producto que devuelve el
                // server
                // System.out.println("Codigo: " + producto.getCodigo());
                // System.out.println("Nombre: " + producto.getNombre());
                // System.out.println("Stock: " + producto.getStock());
                // System.out.println("Valor: " + producto.getValor());
            }
        }
    }

}
