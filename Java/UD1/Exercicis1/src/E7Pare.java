import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class E7Pare {

    public static void main(String[] args) throws IOException{
        BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Digues el nom d'un fitxer de texte: ");
        String fitxerTexte = teclat.readLine();

        Path rutaFitxer = Path.of(fitxerTexte);
        String contingut = Files.readString(rutaFitxer);

        ProcessBuilder pb = new ProcessBuilder("java", "src/E7Fill.java");
        Process proces = pb.start();

        BufferedWriter alfill = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
        alfill.write(contingut);
        alfill.newLine();
        alfill.flush();
        alfill.close();

        System.out.print("Digues el nom del nou fitxer de texte: ");
        String nouFitxer = teclat.readLine();
        Path rutaNouFitxer = Path.of(nouFitxer);

        BufferedReader delFill = new BufferedReader(new InputStreamReader(proces.getInputStream()));
        String linea;
        while ((linea = delFill.readLine()) != null) {
            Files.writeString(rutaNouFitxer, linea + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }

        
        
    }
    
}
