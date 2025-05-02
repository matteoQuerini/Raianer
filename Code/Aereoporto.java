
import java.util.ArrayList;
import java.util.List;

public class Aereoporto {
    
    private Leggi leggi = new Leggi();
    private Hangar hangar;
    private AreaSosta areaSosta;
    private ArrayList<Pista> piste;
    private ArrayList<Aereo> aereiPresenti;
    private ArrayList<Aereo> aereiSoloAndata;
    private Semaforo semaforo;
    
    public Aereoporto() {
        this.hangar = new Hangar();
        this.areaSosta = new AreaSosta();
        this.piste = new ArrayList<Pista>();
        this.aereiPresenti = new ArrayList<Aereo>();
        this.semaforo = new Semaforo(1);

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

    public Aereo acquistaAereo(){
        String codiceVolo = leggi.unoString();
        double pesoMaxBagagli = leggi.unDouble();
        double pesoBagagli = leggi.unDouble();
        boolean soloAndata = leggi.unBoolean();
        float serbatoio = leggi.unFloat();
        float capacitaMassimaSerbatoio = leggi.unFloat();
        float capacitaStiva = leggi.unFloat();
        float capacitaMassimaStiva = leggi.unFloat();
    
        return new Aereo(codiceVolo, pesoMaxBagagli, pesoBagagli, soloAndata, serbatoio, capacitaMassimaSerbatoio, capacitaStiva, capacitaMassimaStiva);

    }     
    
    
    public void aggiungiAereo(Aereo a) {

        Aereo aereo = acquistaAereo();

        semaforo.P();
        aereiPresenti.add(aereo);
        System.out.println(Constants.GREEN + "Aereo aggiunto all'aeroporto" + Constants.RESET);
        semaforo.V();  
        
    }

    public void rimuoviAereo(Aereo a) {
        semaforo.P();
        if(aereiPresenti.remove(a)){
            System.out.println(Constants.GREEN + "Aereo rimosso dall'aeroporto" + Constants.RESET);
        } else {
            System.out.println(Constants.RED + "Aereo non trovato nell'aeroporto" + Constants.RESET);
        }
        semaforo.V();
}

    public void gestisciDecollo(Aereo a){

        semaforo.P();
        for (int i = 0; i < piste.size(); i++) {
         if(piste.get(i).getOccupata() == false){
            if(aereiPresenti.contains(a)){
                if(a.getPesoBagagli() <=  a.getPesoMaxBagagli() && a.getCapacitaStiva()<= a.getCapacitaMassimaStiva() && a.getSerbatoio() == a.getCapacitaMassimaSerbatoio()){
                Pista pista = piste.get(i);
                pista.usaPista();
                pista.setA(a);
                
                System.out.println(Constants.GREEN + "Aereo decollato" + Constants.RESET);
                pista.liberaPista();
                aereiPresenti.remove(a);
                }else{
                    System.out.println(Constants.RED + "Aereo non idoneo al decollo" + Constants.RESET);
                }
            }else{
                System.out.println(Constants.RED + "Aereo non trovato nell'aeroporto" + Constants.RESET);
            }

            } else {
                System.out.println(Constants.RED + "Pista occupata" + Constants.RESET);
            }
        }
        semaforo.V();

    }

    



}
