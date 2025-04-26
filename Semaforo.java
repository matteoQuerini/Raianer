import java.util.*;



class Semaforo{
    int valore;
    
    public Semaforo(int v){
        this.valore = v;
    }
    
    
    synchronized public void P(){
        while(valore == 0){
            try{
                wait();
            } catch(InterruptedException e){}
        }
        valore --;
    }
    
    
    synchronized public void V(){
        valore++;
        notify();
    }
}
