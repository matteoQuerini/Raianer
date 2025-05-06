import java.util.ArrayList;

public class Hangar {
    
    private ArrayList<Aereo> aereiPresenti = new ArrayList<Aereo>();
    private final int MAX_POSTI = 5;
    private Semaforo semaforo = new Semaforo(1);
    
    public boolean aggiungiAereo(Aereo a){

        semaforo.P();
        boolean successo = false;
        try{
        if(aereiPresenti.size() < MAX_POSTI){
            aereiPresenti.add(a);
            a.setStato("nell'hangar");
            System.out.println(Constants.GREEN + "Aereo aggiunto all'hangar" + Constants.RESET);
            successo = true;
        } else {
            System.out.println(Constants.RED + "Hangar pieno" + Constants.RESET);
        }
    }finally {
        semaforo.V();
    }
       
    return successo;


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
