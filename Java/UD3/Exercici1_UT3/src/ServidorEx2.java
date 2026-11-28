import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServidorEx2 {
    public static void main(String[] args) {
        final int PORT = 2222;

        Random random = new Random();
        int numAleatori = random.nextInt(3) + 1;
        int nIntents = 0;

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

                    try {
                        int num = Integer.parseInt(missatge);
                        nIntents++;

                        if (num == numAleatori) {
                            sortida.println("ENCERTAT, nIntents: " + nIntents);
                            break;
                        } else if (numAleatori > num) sortida.println("Número secret MAJOR");
                        else sortida.println("Número secret MENOR");

                    } catch (NumberFormatException e) {

                        if ("ADEU".equalsIgnoreCase(missatge)) {
                            sortida.println("Connexió tancada pel servidor.");
                            break;
                        }

                        sortida.println("El que s'ha enviat no és un nombre vàlid");
                    }
                    
                }
            }
        } catch (IOException e) {
            System.err.println("Error de xarxa al servidor: " + e.getMessage());
        }
    }
}
