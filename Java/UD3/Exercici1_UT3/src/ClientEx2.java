import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx2 {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 2222;
        String resposta;

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader entrada = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter sortida = new PrintWriter(
                     socket.getOutputStream(), true);
             Scanner teclat = new Scanner(System.in)) {

            System.out.println("Connectat al servidor. Escriu missatges (ADEU per sortir): ");
            String text;
            do {
                System.out.print("> ");
                text = teclat.nextLine();
                sortida.println(text);
                resposta = entrada.readLine();
                System.out.println("Servidor respon: " + resposta);
            } while (!"ADEU".equalsIgnoreCase(text)
                && resposta != null
                && !resposta.startsWith("ENCERTAT"));

        } catch (IOException e) {
            System.err.println("No s'ha pogut connectar al servidor: " + e.getMessage());
        }
    }
}
