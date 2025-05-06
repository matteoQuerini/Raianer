public class Main {
    public static void main(String[] args) {
        Aereoporto aeroporto = new Aereoporto();
        VeicoloServizioBagagli veicolo = new VeicoloServizioBagagli();

        // Creazione aerei (simulati)
        Aereo aereo1 = new Aereo("FL123", 1000.0, 0.0, true, 500.0f, 1000.0f, 0.0f, 2000.0f);
        Aereo aereo2 = new Aereo("FL456", 800.0, 0.0, false, 300.0f, 800.0f, 0.0f, 1500.0f);

        // Thread per gestire gli aerei
        Thread threadAereo1 = new Thread(() -> {
            aeroporto.getHangar().aggiungiAereo(aereo1);
            aereo1.rifornisci(500.0f); 
            veicolo.caricaBagagli(aereo1, 300.0f);
            aeroporto.gestisciDecollo(aereo1);
        });

        Thread threadAereo2 = new Thread(() -> {
            aeroporto.getAreaSosta().aggiungiAereo(aereo2);
            aereo2.rifornisci(300.0f);
            veicolo.caricaBagagli(aereo2, 200.0f);
            aeroporto.gestisciDecollo(aereo2);
        });

        // Avvio thread
        threadAereo1.start();
        threadAereo2.start();

        // Aggiungi altre operazioni...
    }
}