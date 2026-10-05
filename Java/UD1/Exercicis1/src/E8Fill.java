import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class E8Fill {

    private static int operarDosNombrePotserMalament(int a, int b, String operador) throws Exception{
        Random random = new Random();

        int nAleatori = random.nextInt(2);
        a += nAleatori;
        return Operacio.operarDosNombres(a, b, operador);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int nIteracions = Integer.parseInt(br.readLine());

            // Recuperar dada, operar-la i enviar-la (Iteració)
            for (int i = 0; i < nIteracions; i++) {
                Integer nAleatori1 = Integer.parseInt(br.readLine());
                Integer nAleatori2 = Integer.parseInt(br.readLine());
                String signe = Operacio.obtenirSigne(Integer.parseInt(br.readLine()));

                if (nAleatori1 != null && nAleatori2 != null && signe != null) {
                    System.out.println(operarDosNombrePotserMalament(nAleatori1, nAleatori2, signe));
                }

            }
            
            
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
}
