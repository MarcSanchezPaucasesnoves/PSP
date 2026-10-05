import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E7Fill {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea.toUpperCase());
        }
        

    }
}
