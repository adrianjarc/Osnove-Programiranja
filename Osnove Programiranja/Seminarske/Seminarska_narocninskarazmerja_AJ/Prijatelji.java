package semop3;

public class Prijatelji extends Narocnik {
    
    private static final int N = 3;
    private String[] stevilkePrijateljev;
    
    public void NastaviPrijatelje (String[] st){ //nastavim številke
        this.stevilkePrijateljev = new String[N];
        this.stevilkePrijateljev = st;
    }
    
    public String[] VrniPrijatelje(){ //berem številke
        return this.stevilkePrijateljev;
    }
    
    public double znesekRacuna(){ //izračun za znesek
        if (this.VrniKlice().length < 1){
            return this.VrniNarocnino();
        }
        double cena = 0;
        for (int i=0;i<this.VrniKlice().length;i++){
            if(!JePrijatelj(this.VrniKlice()[i].VrniStevilko())){ // preverimo če je morda ta klicana številka na seznamu prijateljev. če ni se ta if izvede			
                cena +=(this.VrniKlice()[i].VrniDolzino() <= 60)? this.VrniKlice()[i].vrniCeno() : (this.VrniKlice()[i].vrniCeno()/60.0)*this.VrniKlice()[i].VrniDolzino();
            }
        }
        
        return (cena + this.VrniNarocnino());
    }
    
    public boolean JePrijatelj(String k){ //metoda prverjanaja številk
        for(int i = 0;i < N;i++){
            if(k.equalsIgnoreCase(this.stevilkePrijateljev[i])){
                return true;
            }
        }
	return false;
    }
}
