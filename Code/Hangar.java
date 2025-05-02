import java.util.ArrayList;

public class Hangar {
    
    private ArrayList<Aereo> aereiPresenti = new ArrayList<Aereo>();
    private final int MAX_POSTI = 5;
    private Semaforo semaforo = new Semaforo(1);
    
    public void aggiungiAereo(Aereo a){
        semaforo.P();
        
        if(aereiPresenti.size() < MAX_POSTI){
            aereiPresenti.add(a);
            System.out.println(Constants.GREEN + "Aereo aggiunto all'hangar" + Constants.RESET);
        } else {
            System.out.println(Constants.RED + "Hangar pieno" + Constants.RESET);
        }
        
        semaforo.V();
    }
    
    public void rimuoviAereo(Aereo a){
        semaforo.P();
        
        if(aereiPresenti.remove(a)){
            System.out.println(Constants.GREEN + "Aereo rimosso dall'hangar" + Constants.RESET);
        } else {
            System.out.println(Constants.RED + "Aereo non trovato nell'hangar" + Constants.RESET);
        }
        
        semaforo.V();
    }

}
