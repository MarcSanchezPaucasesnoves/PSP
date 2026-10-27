public class App {
    static int nombre = 0;
    public static void main(String[] args){
        // Exercici 1
        // Thread tic = new Tic();
        // Thread tac = new Tac();

        // tic.start();
        // tac.start();
        

        // Exercici 2
        // Thread tic = new Thread(new Tic());
        // Thread tac = new Thread(new Tac());

        // tic.start();
        // tac.start();
        
        // Exercici 3
        // Thread inc1 = new Thread(new Incrementador());
        // Thread inc2 = new Thread(new Incrementador());

        // inc1.start();
        // inc2.start();

        // try {
        //     inc1.join();
        //     inc2.join();
        // } catch (InterruptedException e) {
        //     System.out.println(e.getMessage());
        // }
        
        // System.out.println(nombre);


        // Exercici 4
        // Thread inc1 = new Thread(new Incrementador2());
        // Thread inc2 = new Thread(new Incrementador2());

        // inc1.start();
        // inc2.start();

        // try {
        //     inc1.join();
        //     inc2.join();

        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // IO.println(nombre);

        // Exercici 5
        // Thread inc = new Thread(new Incrementador4());
        // Thread dec = new Thread(new Decrementador4());

        // inc.start();
        // dec.start();

        // try {
        //     inc.join();
        //     dec.join();

        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // IO.println(nombre);


        // Exercici 6
        BufferEx6 pila = new BufferEx6(5);
        for (int i = 0; i<50; i++){
                    Thread productor = new Thread(new ProductorEx6(pila));
                    Thread consumidor = new Thread(new ConsumidorEx6(pila));
                    //Thread consumidor2 = new Thread(new ConsumidorEx6(pila));
                    productor.start();
                    consumidor.start();
                    //consumidor2.start();
        }

    }

    public static synchronized void operacio(int operacio) {
        if (operacio == 1) {
            nombre++;
        } else if (operacio == 2) {
            nombre--;
        }
    }
}
