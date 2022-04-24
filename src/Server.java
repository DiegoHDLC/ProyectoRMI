import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements IMensaje {

    public String enviaMensaje(int codigo) throws Exception {
        producto prod = conexionSQL.getProducto(codigo);
        return "El servidor responde: Codigo:" + prod.getCodigo() + " Nombre" + prod.getNombre();
    }

    public producto peticion(int codigo) throws Exception {
        producto producto = conexionSQL.getProducto(codigo);
        return producto;
    }

    public static void main(String[] args) throws RemoteException {
        Server server = new Server();
        IMensaje stub = (IMensaje) UnicastRemoteObject.exportObject(server, 0);

        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("ObjetoMensaje", stub);

        System.out.println("Servidor escuchando...");
    }
}