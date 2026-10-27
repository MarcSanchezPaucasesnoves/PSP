public class ProductorEx6 implements Runnable{
    private BufferEx6 pila;


    public ProductorEx6(BufferEx6 pila) {
        this.pila = pila;
    }



    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            try {
                pila.afegir(0);
            } catch (InterruptedException e) {
            
            }
        }
        
        
        
    }
}
