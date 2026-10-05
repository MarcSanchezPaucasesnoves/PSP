import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E6Fill {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String frase = br.readLine();
        int numParaules = frase.split("\\s+").length;
        System.out.print(numParaules);
    }
}