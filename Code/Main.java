public class Main{
    public static void main(String[] args){
        Aereoporto aeroporto = new Aereoporto();
        AreaSosta areaSosta = new AreaSosta();
        Aereo aereo1 = new Aereo("FL123", 1000.0, 0.0, true, 500.0f, 1000.0f, 0.0f, 2000.0f);
        Aereo aereo2 = new Aereo("FL456", 800.0, 0.0, false, 300.0f, 800.0f, 0.0f, 1500.0f);


        Thread threadAereo1 = new Thread(() -> {
            aeroporto.getHangar().aggiungiAereo(aereo1);
            areaSosta.rifornisciAereo(aereo1, 500.0f); 
            areaSosta.caricaBagagli(aereo1, 100.0f);
            aeroporto.gestisciDecollo(aereo1);
        });

        Thread threadAereo2 = new Thread(() -> {
            aeroporto.getAreaSosta().aggiungiAereo(aereo2);
            areaSosta.rifornisciAereo(aereo2, 300.0f);
            areaSosta.caricaBagagli(aereo2, 50.0f);
            aeroporto.gestisciDecollo(aereo2);
        });



        threadAereo1.start();
        threadAereo2.start();

        
    }
}