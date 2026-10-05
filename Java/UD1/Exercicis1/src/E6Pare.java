import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class E6Pare {
    public static void main(String[] args) throws IOException {
        BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escriu una frase: ");
        String frase = teclat.readLine();


        ProcessBuilder pb = new ProcessBuilder("java", "src/E6Fill.java");
        Process proces = pb.start();

        BufferedWriter alFill = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
        alFill.write(frase);
        alFill.newLine();
        alFill.flush();

        BufferedReader delFill = new BufferedReader(new InputStreamReader(proces.getInputStream()));
        String resultat = delFill.readLine();
        System.out.println("Número de paraules: " + resultat);
    }
}