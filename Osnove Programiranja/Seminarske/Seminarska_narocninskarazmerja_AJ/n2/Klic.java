package n2;

import semop3.*;

public class Klic {

    private String stevilka; // klicana številka
    private int dolzina; // dolžina pogovora v sekundah
    private double cenaMinute;
    
    public void NastaviKlic(String st, int d, double cm){
        this.stevilka = st;
        this.dolzina = d;
        this.cenaMinute = cm;
    }
    
    public void NastaviDolzino(int d){
        this.dolzina = d;
    }
    
    public String VrniStevilko(){
        return this.stevilka;
    }
    
    public int VrniDolzino(){
        return this.dolzina;
    }
    
    public double vrniCeno(){
        return this.cenaMinute;
    }
}
