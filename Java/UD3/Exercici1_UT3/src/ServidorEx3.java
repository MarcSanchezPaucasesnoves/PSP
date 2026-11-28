import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEx3 {
    public static void main(String[] args) {
        final int PORT = 2222;
        final String FITXER = "direcciones.txt";

        try (ServerSocket servidor = new ServerSocket(PORT)) {
            System.out.println("Servidor TCP escoltant al port " + PORT + "...");

            try (Socket clientSocket = servidor.accept();
                 BufferedReader entrada = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter sortida = new PrintWriter(
                         clientSocket.getOutputStream(), true)) {

                System.out.println("Client connectat des de: " + clientSocket.getInetAddress());

                String jsonRebut = entrada.readLine();

                if (jsonRebut != null) {
                    System.out.println("Dades rebudes: " + jsonRebut);

                    try (BufferedWriter escriptorFitxer = new BufferedWriter(new FileWriter(FITXER, true))) {
                        escriptorFitxer.write(jsonRebut);
                        escriptorFitxer.newLine();
                    }

                    sortida.println("OK");
                }
            }
        } catch (IOException e) {
            System.err.println("Error d'entrada/sortida al servidor: " + e.getMessage());
        }
    }
}
