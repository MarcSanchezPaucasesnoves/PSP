public class Incrementador implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++) {
            suma();
        }
    }

    synchronized private void suma(){
        App.nombre++;
    }
}
