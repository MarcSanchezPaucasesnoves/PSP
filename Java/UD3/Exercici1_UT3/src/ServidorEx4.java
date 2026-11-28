import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEx4 {
    public static void main(String[] args) {
        final int PORT = 2000;

        try (ServerSocket servidor = new ServerSocket(PORT)) {
            System.out.println("Servidor Calculadora TCP escoltant al port " + PORT + "...");

            try (Socket clientSocket = servidor.accept();
                 BufferedReader entrada = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter sortida = new PrintWriter(
                         clientSocket.getOutputStream(), true)) {

                System.out.println("Client connectat des de: " + clientSocket.getInetAddress());

                String peticio = entrada.readLine();

                if (peticio != null) {
                    System.out.println("Petició rebuda: " + peticio);
                    String resposta = processarOperacio(peticio);
                    sortida.println(resposta);
                }
            }
        } catch (IOException e) {
            System.err.println("Error de xarxa al servidor: " + e.getMessage());
        }
    }

    private static String processarOperacio(String peticio) {
        String[] parts = peticio.split("\\|");

        if (parts.length != 3) {
            return "ERROR: Format invàlid. Ha de ser OPERACIO|NUM1|NUM2";
        }

        String operacio = parts[0].trim().toUpperCase();
        double num1, num2;

        try {
            num1 = Double.parseDouble(parts[1].trim());
            num2 = Double.parseDouble(parts[2].trim());
        } catch (NumberFormatException e) {
            return "ERROR: Els operands han de ser nombres vàlids.";
        }

        switch (operacio) {
            case "SUMA":
                return "Resultat: " + (num1 + num2);
            case "RESTA":
                return "Resultat: " + (num1 - num2);
            case "MULTIPLICACIO":
                return "Resultat: " + (num1 * num2);
            case "DIVISIO":
                if (num2 == 0) {
                    return "ERROR: No es pot dividir per zero.";
                }
                return "Resultat: " + (num1 / num2);
            default:
                return "ERROR: Operació desconeguda (" + operacio + "). Usa SUMA, RESTA, MULTIPLICACIO o DIVISIO.";
        }
    }
}
