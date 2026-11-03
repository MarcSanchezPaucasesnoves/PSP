import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CubertEx8 {
    static int idCount;
    int id;
    Lock cubertlock;


    public CubertEx8() {
        this.cubertlock = new ReentrantLock();
        id = idCount;
        idCount++;
    }

    public void agafar(){
        cubertlock.lock();
    }

    public void deixar(){
        cubertlock.unlock();
    }

    @Override
    public String toString() {
        return "CubertEx8 [id=" + id + "]";
    }
}
