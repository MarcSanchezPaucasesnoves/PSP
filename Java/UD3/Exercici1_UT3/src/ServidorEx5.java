import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEx5 {
    public static void main(String[] args) {
        final int PORT = 1500;

        try (ServerSocket servidor = new ServerSocket(PORT)) {
            System.out.println("Servidor de Fitxers TCP escoltant al port " + PORT + "...");

            try (Socket clientSocket = servidor.accept();
                 BufferedReader entrada = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter sortida = new PrintWriter(
                         clientSocket.getOutputStream(), true)) {

                System.out.println("Client connectat des de: " + clientSocket.getInetAddress());

                String nomFitxer = entrada.readLine();

                if (nomFitxer != null) {
                    System.out.println("El client demana el fitxer: " + nomFitxer);
                    File fitxer = new File(nomFitxer.trim());

                    if (fitxer.exists() && fitxer.isFile()) {
                        try (BufferedReader lectorFitxer = new BufferedReader(new FileReader(fitxer))) {
                            String linia;
                            while ((linia = lectorFitxer.readLine()) != null) {
                                sortida.println(linia);
                            }
                        }
                        System.out.println("Fitxer enviat correctament.");
                    } else {
                        sortida.println("ERROR|Fitxer no trobat");
                        System.out.println("Fitxer no trobat. Error enviat al client.");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error d'entrada/sortida al servidor: " + e.getMessage());
        }
    }
}
