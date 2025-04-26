import java.util.*;

class AreaSosta{
    ArrayList<Aereo> aereiPresenti = new ArrayList<Aereo>();
    private final int MAX_POSTI = 3;
    private Semaforo semaforo = new Semaforo(3);

    public void aggiungiAereo(Aereo a){
        semaforo.P();
        
        if(aerei.size() < MAX_POSTI){
            aereiPresenti.add(a);
            System.out.println(Constants.GREEN + "Aereo aggiunto all'area di sosta" + Constants.RESET);

        } else {
            System.out.println(Constants.RED + "Area di sosta piena" + Constants.RESET);
        }

        semaforo.V();
    }

    public void rimuoviAereo(Aereo a){
        for(Aereo aereo : aereiPresenti){
            if(aereo.equals(a)){
                aereiPresenti.remouve(a);
            }
        }
    }

    public boolean equals(Object obj) {
        return (this == obj);
    }
}