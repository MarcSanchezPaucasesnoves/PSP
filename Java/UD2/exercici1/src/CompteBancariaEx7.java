import java.util.concurrent.locks.ReentrantLock;

public class CompteBancariaEx7 {
    private ReentrantLock lock;
    private double saldo;
    private int id;
    private static int idCount = 0;

    public CompteBancariaEx7(double saldo) {
        lock = new ReentrantLock();
        this.saldo = saldo;
        id = idCount;
        idCount++;
    }

    public ReentrantLock getLock(){
        return lock;
    }

    public void afegirSaldo(double saldo){
        this.saldo += saldo;
    }

    public void retirarSaldo(double saldo){
        this.saldo -= saldo;
    }

}
