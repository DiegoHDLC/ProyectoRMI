import java.rmi.Remote;

public interface IMensaje extends Remote {
    String enviaMensaje(int codigo) throws Exception;

    producto peticion(int codigo) throws Exception;
}
