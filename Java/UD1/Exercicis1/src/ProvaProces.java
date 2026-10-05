import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProvaProces {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("ping", "google.com");
            Process proces = pb.start();
            
            BufferedReader delFill = new BufferedReader(new InputStreamReader(proces.getInputStream()));
            String line;
            while ((line = delFill.readLine()) != null) {
                System.out.println(line);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}