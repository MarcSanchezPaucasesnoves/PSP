public class Incrementador2 implements Runnable{
    public Incrementador2() {

    }

    @Override 
    public void run() {
        for (int i = 0; i < 100000; i++) {
            _run2();
        }
    }

    private static synchronized void _run2() {
        App.nombre++;
    }
}
