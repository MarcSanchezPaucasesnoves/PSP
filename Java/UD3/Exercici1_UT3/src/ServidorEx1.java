import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEx1 {
    public static void main(String[] args) {
        final int PORT = 2222;

        try (ServerSocket servidor = new ServerSocket(PORT)) {
            System.out.println("Servidor TCP escoltant al port " + PORT + "...");

            try (Socket clientSocket = servidor.accept();
                 BufferedReader entrada = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter sortida = new PrintWriter(
                         clientSocket.getOutputStream(), true)) {

                System.out.println("Client connectat des de: " + clientSocket.getInetAddress());

                String missatge;
                while ((missatge = entrada.readLine()) != null) {
                    System.out.println("Rebut: " + missatge);
                    if ("ADEU".equalsIgnoreCase(missatge)) {
                        sortida.println("Connexió tancada pel servidor.");
                        break;
                    }
                    sortida.println("ECO: " + missatge.toUpperCase());
                }
            }
        } catch (IOException e) {
            System.err.println("Error de xarxa al servidor: " + e.getMessage());
        }
    }
}
