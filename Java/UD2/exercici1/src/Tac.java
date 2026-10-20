public class Tac extends Thread{

    @Override
    public void run(){
        try {
            sleep(500);
            while(true){
                System.out.println("TIC");
                sleep(1000);
        }
        } catch (InterruptedException e) {
            
        }
    }
}
