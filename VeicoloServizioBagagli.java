class VeicoloServizioBagagli{
    private Semaforo semaforo = new Semaforo(1);


    public void caricaBagagli(Aereo a, float pesoBagaglio){
        semaforo.P();

        if(a.getStiva() + pesoBagaglio <= a.getCapacitaMassimaStiva){
            a.caricaBagagli();
            System.out.println(Constants.GREEN +"Bagagli caricati con successo sull'aereo con codice di volo: " + a.getCodiceVolo());
        
        } else {
            System.out.println(Constants.RED +"Caricare l'aereo con meno bagagli");
        }

        semaforo.V();
    }

    public void scaricaBagagli(Aereo a){
        semaforo.P();

        a.scaricaBagagli();
        System.out.println(Constants.GREEN +"Bagagli scaricati con successo dall'aereo con codice di volo: " + a.getCodiceVolo());

        semaforo.V();
    }
}