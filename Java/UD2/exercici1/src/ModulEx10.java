import java.util.Random;

public class ModulEx10 implements Runnable{
    private String nom;
    private long tempsTardat;
    private long tempsAEsperar;
    private BddEx10 bdd;


    public ModulEx10(String nom, BddEx10 bdd) {
        this.nom = nom;
        this.bdd = bdd;
        tempsTardat = 0;

        Random random = new Random();
        tempsAEsperar = random.nextLong(1000L, 5000L + 1);
    }
    

    @Override 
    public void run() {
        tempsTardat = System.currentTimeMillis();
        bdd.carregaDades(tempsAEsperar);
        tempsTardat = System.currentTimeMillis();
        bdd.escriureFitxer(nom, tempsTardat);
    }

}
