import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx5 {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 1500;

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader entrada = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter sortida = new PrintWriter(
                     socket.getOutputStream(), true);
             Scanner teclat = new Scanner(System.in)) {

            System.out.println("Connectat al servidor de fitxers.");
            System.out.print("Introdueix el nom del fitxer que vols llegir (ex: direcciones.txt): ");
            String nomFitxer = teclat.nextLine();

            sortida.println(nomFitxer);

            String linia;
            boolean primeraLinia = true;

            while ((linia = entrada.readLine()) != null) {
                if (primeraLinia && linia.startsWith("ERROR|")) {
                    System.out.println("Resposta del servidor -> " + linia);
                    break;
                }
                if (primeraLinia) {
                    System.out.println("\n--- Contingut de " + nomFitxer + " ---");
                    primeraLinia = false;
                }
                System.out.println(linia);
            }

            if (!primeraLinia) {
                System.out.println("--- Fi del fitxer ---");
            }

        } catch (IOException e) {
            System.err.println("No s'ha pogut connectar al servidor: " + e.getMessage());
        }
    }
}
