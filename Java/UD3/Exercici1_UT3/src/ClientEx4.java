import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx4 {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 2000;

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader entrada = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter sortida = new PrintWriter(
                     socket.getOutputStream(), true);
             Scanner teclat = new Scanner(System.in)) {

            System.out.println("Connectat al servidor calculadora.");
            System.out.print("Introdueix l'operació (SUMA, RESTA, MULTIPLICACIO, DIVISIO): ");
            String operacio = teclat.nextLine().trim().toUpperCase();

            System.out.print("Introdueix el primer nombre: ");
            String num1 = teclat.nextLine().trim();

            System.out.print("Introdueix el segon nombre: ");
            String num2 = teclat.nextLine().trim();

            
            String missatge = operacio + "|" + num1 + "|" + num2;

            sortida.println(missatge);
            String resposta = entrada.readLine();
            System.out.println("Servidor respon -> " + resposta);

        } catch (IOException e) {
            System.err.println("No s'ha pogut connectar al servidor: " + e.getMessage());
        }
    }
}
