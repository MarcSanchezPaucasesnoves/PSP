import static java.lang.Thread.sleep;

public class TacRunnable {
    public void run(){
        while(true){
            System.out.println("TIC");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                  
            }
        }
    }
}
