import java.util.LinkedList;
import java.util.Queue;

public class BufferEx6 {
    private final Queue<Integer> cua;
    private final int CAPACITAT;


    public BufferEx6(int capacitat) {
        this.CAPACITAT = capacitat;
        cua = new LinkedList<>();
    }


    public synchronized void afegir(int producte) throws InterruptedException {
        while (cua.size() == CAPACITAT) {
            System.out.println("Productor esperant...");
            wait(); 
        }

        cua.add(producte);
        System.out.println("Producte afegit " + " | Buffer: " + cua);
        
        notifyAll(); 
    }


    public synchronized void llegir() throws InterruptedException {
        while (cua.isEmpty()) {
            System.out.println("Consumidor esperant...");
            wait(); 
        }

        int producte = cua.poll();
        System.out.println("Producte comprat " + " | Buffer: " + cua);
        
        notifyAll(); 
        
        
    }
}

