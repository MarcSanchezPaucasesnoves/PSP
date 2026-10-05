import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class E8Pare {
    public static void main(String[] args) {
        int nNombres = 11;
        int nOperacions = 5;
        Random generadorNombres = new Random();


        try {
            ProcessBuilder pb = new ProcessBuilder("java", "src/E8Fill.java");
            Process proces = pb.start();

            BufferedWriter alFill = new BufferedWriter(new OutputStreamWriter(proces.getOutputStream()));
            alFill.write(String.valueOf(nOperacions));
            alFill.newLine();
            alFill.flush();

            for (int i = 0; i < nOperacions; i++) {
                int nAleatori1 = generadorNombres.nextInt(nNombres);
                int nAleatori2 = generadorNombres.nextInt(nNombres);
                int signeAleatori = generadorNombres.nextInt(2);

                alFill.write(String.valueOf(nAleatori1));
                alFill.newLine();
                alFill.write(String.valueOf(nAleatori2));
                alFill.newLine();
                alFill.write(String.valueOf(signeAleatori));
                alFill.newLine();
                alFill.flush();

                // Iterarar les respostes
                int operacioCorrecte = Operacio.operarDosNombres(nAleatori1, nAleatori2, Operacio.obtenirSigne(signeAleatori));
                BufferedReader delFill = new BufferedReader(new InputStreamReader(proces.getInputStream()));
                String resultat = delFill.readLine();

                String comprovacioOperacio = (operacioCorrecte == Integer.parseInt(resultat)) ? "Correcte" : "Incorrecte";

                System.out.println("Resultat de la operació " + nAleatori1 + " " + Operacio.obtenirSigne(signeAleatori) + " " + nAleatori2 + " = " + resultat + " " + comprovacioOperacio);

            }


             
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
