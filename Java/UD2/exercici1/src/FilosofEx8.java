public class FilosofEx8 extends Thread{
    String nom;
    CubertEx8 cubertEsq;
    CubertEx8 cuberDret;

    public FilosofEx8(String nom, CubertEx8 cubertEsq, CubertEx8 cuberDret) {
        this.nom = nom;
        this.cubertEsq = cubertEsq;
        this.cuberDret = cuberDret;
    }


    private void menjar() { 
        try {
            cubertEsq.agafar();
            cuberDret.agafar();
            IO.println("El filosof " + nom + " ha agafat els dos cuberts (" + cubertEsq + ", " + cuberDret + ")");
            Thread.sleep(5000);
            IO.println("El filosof "  + nom + " ha deixat els dos cuberts (" + cubertEsq + ", " + cuberDret + ")");

        } catch (Exception e) {
            IO.println(e.getMessage());
        } finally {
            cubertEsq.deixar();
            cuberDret.deixar();
        }
    }

    private void esperar(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            IO.println(e.getMessage());
        }
        
    }

    @Override
    public void run(){
        menjar();
        esperar();
    }
}
