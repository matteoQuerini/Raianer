import java.util.*;

class AreaSosta{
    ArrayList<Aereo> aereiPresenti;
    private final int MAX_POSTI = 3;
    private Semaforo semaforo = new Semaforo(3);
    private VeicoloServizioBagagli veicoloServizioBagagli;
    private VeicoloServizioRifornimento veicoloServizioRifornimento;
    
    public AreaSosta(){
        this.aereiPresenti = new ArrayList<Aereo>();
        this.veicoloServizioBagagli = new VeicoloServizioBagagli();
        this.veicoloServizioRifornimento = new VeicoloServizioRifornimento();
    }

    public void aggiungiAereo(Aereo a){
        semaforo.P();
        
        if(aereiPresenti.size() < MAX_POSTI){
            aereiPresenti.add(a);
            a.setStato("in area di sosta");
            System.out.println(Constants.GREEN + "Aereo aggiunto all'area di sosta" + Constants.RESET);

        } else {
            System.out.println(Constants.RED + "Area di sosta piena" + Constants.RESET);
        }

        semaforo.V();
    }

    public void rimuoviAereo(Aereo a){
        for(Aereo aereo : aereiPresenti){
            if(aereo.equals(a)){
                aereiPresenti.remove(a);
            }
        }
    }

    public boolean equals(Object obj) {
        return (this == obj);
    }

    public void rifornisciAereo(Aereo a, float quantitaBenzina){
        veicoloServizioRifornimento.rifornisciAereo(a, quantitaBenzina);
    }

    public void caricaBagagli(Aereo a, float pesoBagaglio){
        veicoloServizioBagagli.caricaBagagli(a, pesoBagaglio);
    }
    
    public void scaricaBagagli(Aereo a){
        veicoloServizioBagagli.scaricaBagagli(a);
    }
}