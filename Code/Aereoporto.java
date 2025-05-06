import java.util.ArrayList;

public class Aereoporto {
    
    private final Leggi leggi = new Leggi();
    private final Hangar hangar;
    private final AreaSosta areaSosta;
    private final ArrayList<Pista> piste;
    private final ArrayList<Aereo> aereiPresenti;
    private final ArrayList<Aereo> aereiSoloAndata;
    private final Semaforo semaforoAeroporto = new Semaforo(1); // Semaforo centralizzato
    
    public Aereoporto() {
        this.hangar = new Hangar();
        this.areaSosta = new AreaSosta();
        this.piste = new ArrayList<Pista>();
        this.aereiPresenti = new ArrayList<Aereo>();
        this.aereiSoloAndata = new ArrayList<Aereo>(); // Fix NullPointerException
    }
    
    public Hangar getHangar() {
        return hangar;
    }
    
    public AreaSosta getAreaSosta() {
        return areaSosta;
    }
    
    public ArrayList<Aereo> getAereiPresenti() {
        return aereiPresenti;
    }
    
    public ArrayList<Pista> getPiste() {
        return piste;
    }
    
    public Aereo acquistaAereo() {
        return new Aereo(
            leggi.unoString(),
            leggi.unDouble(),
            leggi.unDouble(),
            leggi.unBoolean(),
            leggi.unFloat(),
            leggi.unFloat(),
            leggi.unFloat(),
            leggi.unFloat()
        );
    }
    
    public void aggiungiAereo() {
        Aereo aereo = acquistaAereo();
        semaforoAeroporto.P();
        try {
            if (hangar.aggiungiAereo(aereo)) {
                aereiPresenti.add(aereo);
                System.out.println(Constants.GREEN + "Aereo aggiunto all'hangar" + Constants.RESET);
            } else {
                System.out.println(Constants.RED + "Hangar pieno!" + Constants.RESET);
            }
        } finally {
            semaforoAeroporto.V(); // Rilascio garantito
        }
    }
    
    public void rimuoviAereo(Aereo a) {
        semaforoAeroporto.P();
        try {
            if (aereiPresenti.remove(a)) {
                System.out.println(Constants.GREEN + "Aereo rimosso dall'aeroporto" + Constants.RESET);
            } else {
                System.out.println(Constants.RED + "Aereo non trovato" + Constants.RESET);
            }
        } finally {
            semaforoAeroporto.V();
        }
    }
    
    public void gestisciDecollo(Aereo a) {
        semaforoAeroporto.P();
        try {
            boolean decolloRiuscito = false;
            for (Pista pista : piste) {
                if (!pista.getOccupata() && a.getSerbatoio() == a.getCapacitaMassimaSerbatoio() && a.getPesoBagagli() <= a.getPesoMaxBagagli() && a.getCapacitaStiva() <= a.getCapacitaMassimaStiva()) {
                    pista.usaPista();
                    pista.setA(a);
                    a.setStato("in volo");
                    aereiPresenti.remove(a);
                    aereiSoloAndata.add(a);
                    System.out.println(Constants.GREEN + "DECOLLO RIUSCITO: " + a.getCodiceVolo() + Constants.RESET);
                    pista.liberaPista();
                    decolloRiuscito = true;
                    break;
                }
            }
            if (!decolloRiuscito) {
                System.out.println(Constants.RED + "DECOLLO FALLITO: " + a.getCodiceVolo() + " (serbatoio/pista/bagagli)" + Constants.RESET);
            }
        } finally {
            semaforoAeroporto.V();
        }
    }
    
    public void gestisciAtteraggio(Aereo a) {
        semaforoAeroporto.P();
        try {
            boolean atterraggioRiuscito = false;
            for (Pista pista : piste) {
                if (!pista.getOccupata() && aereiSoloAndata.contains(a)) { // Fix: controllo sicuro
                    pista.usaPista();
                    a.setStato("in area di sosta");
                    areaSosta.aggiungiAereo(a);
                    aereiSoloAndata.remove(a);
                    System.out.println(Constants.GREEN + "ATTERRAGGIO RIUSCITO: " + a.getCodiceVolo() + Constants.RESET);
                    pista.liberaPista();
                    atterraggioRiuscito = true;
                    break;
                }
            }
            if (!atterraggioRiuscito) {
                System.out.println(Constants.RED + "ATTERRAGGIO FALLITO: " + a.getCodiceVolo() + Constants.RESET);
            }
        } finally {
            semaforoAeroporto.V();
        }
    }
}