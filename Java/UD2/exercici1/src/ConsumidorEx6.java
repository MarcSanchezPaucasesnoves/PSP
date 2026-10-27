public class ConsumidorEx6 implements Runnable{
    private BufferEx6 pila;


    public ConsumidorEx6(BufferEx6 pila) {
        this.pila = pila;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            try {
                pila.llegir();
            } catch (InterruptedException e) {
            
            }
        }
        
        
    }
}
