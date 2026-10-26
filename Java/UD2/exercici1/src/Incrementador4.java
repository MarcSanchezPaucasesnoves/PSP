public class Incrementador4 implements Runnable{
    public Incrementador4() {

    }

    @Override 
    public void run() {
        for (int i = 0; i < 100000; i++) {
            App.operacio(1);
        }
    }
}