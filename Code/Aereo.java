public class Aereo {
    private String codiceVolo;
    private double pesoMaxBagagli;
    private double pesoBagagli;
    private boolean soloAndata;
    private float serbatoio;
    private float capacitaMassimaSerbatoio;
    private float capacitaStiva;
    private float capacitaMassimaStiva;
    private String stato = "";
    


    public Aereo(String codiceVolo, double pesoMaxBagagli, double pesoBagagli, boolean soloAndata, float serbatoio, float capacitaMassimaSerbatoio, float capacitaStiva, float capacitaMassimaStiva){
        this.codiceVolo = codiceVolo;
        this.pesoMaxBagagli = pesoMaxBagagli;
        this.pesoBagagli = pesoBagagli;
        this.soloAndata = soloAndata;
        this.serbatoio = serbatoio;
        this.capacitaMassimaSerbatoio = capacitaMassimaSerbatoio;
        this.capacitaStiva = capacitaStiva;
        this.capacitaMassimaStiva = capacitaMassimaStiva;

    }


    //GETTER E SETTER

    public String getStato(){
        return stato;
    }

    public void setStato(String stato){
        this.stato = stato;
    }

    public String getCodiceVolo(){
        return codiceVolo;
    }

    public void setCodiceVolo(String codiceVolo){
        this.codiceVolo = codiceVolo;
    }

    public double getPesoMaxBagagli(){
        return pesoMaxBagagli;
    }

    public void setPesoMaxBagagli(double pesoMaxBagagli){
        this.pesoMaxBagagli = pesoMaxBagagli;
    }

    public double getPesoBagagli(){
        return pesoBagagli;
    }

    public void setPesoBagagli(double pesoBagagli){
        this.pesoBagagli = pesoBagagli;
    }

    public boolean isSoloAndata(){
        return soloAndata;
    }

    public void setSoloAndata(boolean soloAndata){
        this.soloAndata = soloAndata;
    }

    public float getSerbatoio(){
        return serbatoio;
    }

    public void setSerbatoio(float serbatoio){
        this.serbatoio = serbatoio;
    }

    public float getCapacitaMassimaSerbatoio(){
        return capacitaMassimaSerbatoio;
    }

    public void setCapacitaMassimaSerbatoio(float capacitaMassimaSerbatoio){
        this.capacitaMassimaSerbatoio = capacitaMassimaSerbatoio;
    }

    public float getCapacitaStiva(){
        return capacitaStiva;
    }

    public void setCapacitaStiva(float capacitaStiva){
        this.capacitaStiva = capacitaStiva;
    }

    public float getCapacitaMassimaStiva(){
        return capacitaMassimaStiva;
    }

    public void setCapacitaMassimaStiva(float capacitaMassimaStiva){
        this.capacitaMassimaStiva = capacitaMassimaStiva;
    }

    //METODI

    public void caricaBagagli(float pesoBagagli){
        float nuovoCarico = this.capacitaStiva + pesoBagagli;
        setCapacitaStiva(nuovoCarico);
    }

    public void scaricaBagagli(){
        setCapacitaStiva(0);
    }

    public void rifornisci(float quantitaBenzina){
    
        float quantita = getSerbatoio() + quantitaBenzina;
        setSerbatoio(quantita);
    }
}