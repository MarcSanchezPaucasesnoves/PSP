import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx3 {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 2222;

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader entrada = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter sortida = new PrintWriter(
                     socket.getOutputStream(), true);
             Scanner teclat = new Scanner(System.in)) {

            System.out.println("Connectat al servidor. Introdueix les dades de l'adreça:");

            System.out.print("Carrer: ");
            String carrer = teclat.nextLine();

            System.out.print("Codi Postal: ");
            String codiPostal = teclat.nextLine();

            System.out.print("País: ");
            String pais = teclat.nextLine();

            int nombreCasa = 0;
            boolean nombreValid = false;
            while (!nombreValid) {
                System.out.print("Nombre de casa: ");
                try {
                    nombreCasa = Integer.parseInt(teclat.nextLine());
                    nombreValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Introdueix un número enter vàlid.");
                }
            }

            String json = String.format(
                    "{\"Carrer\":\"%s\",\"CodiPostal\":\"%s\",\"Pais\":\"%s\",\"NombreCasa\":%d}",
                    carrer, codiPostal, pais, nombreCasa
            );


            sortida.println(json);
            String resposta = entrada.readLine();
            System.out.println("Servidor respon: " + resposta);

        } catch (IOException e) {
            System.err.println("Error de connexió amb el servidor: " + e.getMessage());
        }
    }
}
