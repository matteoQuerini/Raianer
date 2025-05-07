class VeicoloServizioRifornimento{
    private Semaforo semaforo = new Semaforo(1);

    public void rifornisciAereo(Aereo a, float quantitaBenzina){
        semaforo.P();

        if(a.getSerbatoio() + quantitaBenzina <= a.getCapacitaMassimaSerbatoio()){
            a.rifornisci(quantitaBenzina);
            System.out.println(Constants.GREEN +"Rifornimento dell'aereo " +a.getCodiceVolo()+ " avvenuto con successo");
        
        } else {
            System.out.println(Constants.RED +"Rifornire l'aereo " +a.getCodiceVolo()+ "con meno benzina");
            a.rifornisci(a.getCapacitaMassimaSerbatoio());
        }
    
        semaforo.V();
    }
}