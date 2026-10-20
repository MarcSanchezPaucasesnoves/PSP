public class Tic extends Thread{

    @Override
    public void run(){
        try {
            while(true){
                System.out.println("TIC");
                sleep(1000);
        }
        } catch (InterruptedException e) {
            
        }
    }
}
