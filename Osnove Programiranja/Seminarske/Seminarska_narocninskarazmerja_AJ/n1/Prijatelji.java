package n1;

import semop3.*;

public class Prijatelji extends Narocnik {
    
    private static final int N = 3;
    private String[] stevilkePrijateljev;
    
    public void NastaviPrijatelje (String[] st){
        this.stevilkePrijateljev = new String[N];
        this.stevilkePrijateljev = st;
    }
    
    public String[] VrniPrijatelje(){
        return this.stevilkePrijateljev;
    }
    
    public double znesekRacuna(){
        if (this.VrniKlice().length < 1){
            return this.VrniNarocnino();
        }
        double cena = 0;
        for (int i=0;i<this.VrniKlice().length;i++){
            if(!JePrijatelj(this.VrniKlice()[i].VrniStevilko())){			
                cena +=(this.VrniKlice()[i].VrniDolzino() <= 60)? this.VrniKlice()[i].vrniCeno() : (this.VrniKlice()[i].vrniCeno()/60.0)*this.VrniKlice()[i].VrniDolzino();
            }
        }
        
        return (cena + this.VrniNarocnino());
    }
    
    public boolean JePrijatelj(String k){
        for(int i = 0;i < N;i++){
            if(k.equalsIgnoreCase(this.stevilkePrijateljev[i])){
                return true;
            }
        }
	return false;
    }
}
