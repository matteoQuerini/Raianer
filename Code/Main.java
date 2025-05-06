public class Main{
    public static void main(String[] args){
        Aereoporto aeroporto = new Aereoporto();
        aeroporto.getPiste().add(new Pista());
        aeroporto.getPiste().add(new Pista());
        aeroporto.getPiste().add(new Pista());
        Aereo aereo1 = new Aereo("FL123", 1000.0, 0.0, true, 500.0f, 1000.0f, 0.0f, 2000.0f);
        Aereo aereo2 = new Aereo("FL456", 800.0, 0.0, false, 300.0f, 800.0f, 0.0f, 1500.0f);
        aeroporto.getHangar().aggiungiAereo(aereo1);
        aeroporto.getHangar().aggiungiAereo(aereo2);

        System.out.println(aereo1.getStato());
        

        Thread threadAereo1 = new Thread(() -> {
            aeroporto.getHangar().rimuoviAereo(aereo1);
            aeroporto.getAreaSosta().aggiungiAereo(aereo1);
            aeroporto.getAreaSosta().rifornisciAereo(aereo1, 500.0f); 
            aeroporto.getAreaSosta().caricaBagagli(aereo1, 100.0f);
            aeroporto.gestisciDecollo(aereo1);
            aeroporto.gestisciAtteraggio(aereo1);

        });

        Thread threadAereo2 = new Thread(() -> {
            aeroporto.getHangar().rimuoviAereo(aereo2);
            aeroporto.getAreaSosta().aggiungiAereo(aereo2);
            aeroporto.getAreaSosta().rifornisciAereo(aereo2, aereo2.getCapacitaMassimaSerbatoio() - aereo2.getSerbatoio());  
            aeroporto.gestisciDecollo(aereo2);
            aeroporto.gestisciAtteraggio(aereo2);
            aeroporto.getAreaSosta().scaricaBagagli(aereo2);
            aeroporto.getAreaSosta().caricaBagagli(aereo2, 200.0f);
            aeroporto.getAreaSosta().rifornisciAereo(aereo2, 500.0f); 
            aeroporto.gestisciDecollo(aereo2);
            aeroporto.gestisciAtteraggio(aereo2);
            aeroporto.getAreaSosta().scaricaBagagli(aereo2);
            aeroporto.getHangar().aggiungiAereo(aereo2);            
        });



        threadAereo1.start();
        threadAereo2.start();

        
    }
}