import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx1 {
    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT = 5000;

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader entrada = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter sortida = new PrintWriter(
                     socket.getOutputStream(), true);
             Scanner teclat = new Scanner(System.in)) {

            System.out.println("Connectat al servidor. Escriu missatges (ADEU per sortir):");
            String text;
            do {
                System.out.print("> ");
                text = teclat.nextLine();
                sortida.println(text); // Envia al servidor
                String resposta = entrada.readLine(); // Espera resposta
                System.out.println("Servidor respon: " + resposta);
            } while (!"ADEU".equalsIgnoreCase(text));

        } catch (IOException e) {
            System.err.println("No s'ha pogut connectar al servidor: " + e.getMessage());
        }
    }
}
