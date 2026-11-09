import java.util.concurrent.Semaphore;

public class BddEx10{

    private final Semaphore semafor;
   

    public BddEx10(int nSemafor) {
        semafor = new Semaphore(nSemafor);
    }


    public void carregaDades(long tempsAEsperar) {
        try {
            semafor.acquire();
            Thread.sleep(tempsAEsperar);
            
        } catch (InterruptedException e) {
            IO.println("Error: " + e.getMessage());
        } finally {
            semafor.release();
        }
        
    }

    synchronized public void escriureFitxer(String nomFil, long tempsTardat) {

    }
    
}
