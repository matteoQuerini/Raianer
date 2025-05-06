public class Pista {

    private  Aereo a;
    private  boolean  occupata;
    private  Semaforo M_pista;


    public Pista() {
        this.occupata = false;
        this.M_pista = new Semaforo(1);
    }

    public boolean getOccupata() {
        return occupata;
    }

    public void setOccupata(boolean occupata) {
        this.occupata = occupata;
    }

    public Aereo getA() {
        return a;
    }

    public void setA(Aereo a) {
        this.a = a;
    }


    public void usaPista() {
        M_pista.P();
        this.occupata = true;
        System.out.println(Constants.GREEN + "Pista in uso "+ Constants.RESET);
    }

    public void liberaPista(){
 
        this.occupata = false;
        System.out.println(Constants.GREEN + "pista viene liberata " + Constants.RESET);
        M_pista.V();
    }



}
