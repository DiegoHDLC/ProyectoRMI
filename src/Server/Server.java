package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Client.IMensaje;
import Client.producto;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server implements IMensaje {

    protected Server() throws RemoteException {
        super();
    }

    @Override
    public String enviaMensaje(int codigo) throws Exception {
        producto prod = conexionSQL.getProducto(codigo);
        return "El servidor responde: Codigo:" + prod.getCodigo() + " Nombre" +
                prod.getNombre();
    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "15.228.170.95");
            IMensaje stub = (IMensaje) UnicastRemoteObject.exportObject(new Server(), 0);
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("ObjetoMensaje", stub);
            System.out.println("Servidor escuchando...");
        } catch (RemoteException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}