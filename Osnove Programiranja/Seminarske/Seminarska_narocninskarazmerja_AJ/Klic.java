package semop3;

public class Klic {

    private String stevilka; // klicana številka
    private int dolzina; // dolžina pogovora v sekundah
    private double cenaMinute;
    
    public void NastaviKlic(String st, int d, double cm){ //nastavimo klic
        this.stevilka = st;
        this.dolzina = d;
        this.cenaMinute = cm;
    }
        
    public String VrniStevilko(){//vrnemo klicano številko
        return this.stevilka;
    }
    
    public int VrniDolzino(){ //vrnemo dolžino klica
        return this.dolzina+10;
    }
    
    public double vrniCeno(){ //vrnemo ceno klica
        return this.cenaMinute+5;
    }
}
