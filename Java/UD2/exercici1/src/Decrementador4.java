public class Decrementador4 implements Runnable{
    public Decrementador4() {

    }

    @Override 
    public void run() {
        for (int i = 0; i < 100000; i++) {
            App.operacio(2);
        }
    }
}
