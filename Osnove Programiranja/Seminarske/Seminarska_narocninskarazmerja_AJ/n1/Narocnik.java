package n1;

import semop3.*;

public class Narocnik {
    
    private String telefonskaStevilka;
    private String ime;
    private String priimek;
    private double mesecnaNarocnina;
    private Klic[] klici; 
    private String[] stevilke;
    private int paket;
    protected double zr =0;

    public void NastaviNarocnika (String ts, String i, String pr, double mn, int p){
        telefonskaStevilka = ts;
        ime = i;
        priimek = pr;
        mesecnaNarocnina = mn;
        paket = p;
    }
    
    public void NastaviPrijatelje(String[] pr){
    }

    public void NapolniMozneStevilkezaNarocnika(int d, String[] st){
        this.stevilke = new String[d];
        this.stevilke = st;
    }
    
    public void Klici(){
        int d = (int)(Math.random()*11);
        this.klici = new Klic[d];
        for (int i=0;i<klici.length;i++){
            klici[i] = new Klic();
            double c = Math.random();
            while (c<0.01 || c>0.90){
                c = Math.random();
            }
            int f = (int)(Math.random()*9);
            this.klici[i].NastaviKlic(this.stevilke[f], ((int)(Math.random()*6001)), c);
        }
    }
    
    public void IzpisiKlice(){
        for (int i=0;i<this.klici.length;i++){
            if (i>0){
                if(i<(this.klici.length-1)){
                    System.out.printf("        %s | %d s | %1.2f EUR/min,\n", this.klici[i].VrniStevilko(), this.klici[i].VrniDolzino(), this.klici[i].vrniCeno());
                } else {
                    System.out.printf("        %s | %d s | %.2f EUR/min", this.klici[i].VrniStevilko(), this.klici[i].VrniDolzino(), this.klici[i].vrniCeno());
                }
            }else if (klici.length > 1)  {
                System.out.printf("%s | %d s | %.2f EUR/min,\n", this.klici[i].VrniStevilko(), this.klici[i].VrniDolzino(), this.klici[i].vrniCeno());
            } else if (klici.length == 1){
                System.out.printf("%s | %d s | %.2f EUR/min", this.klici[i].VrniStevilko(), this.klici[i].VrniDolzino(), this.klici[i].vrniCeno());
            }
        }
    }
    
    public double znesekRacuna(){
        if(this.VrniKlice().length < 1){
            return this.mesecnaNarocnina;
        }
        double cena = 0;
	for(int i = 0;i < this.klici.length; i++){	
            cena +=(klici[i].VrniDolzino() <= 60)? klici[i].vrniCeno() : ( klici[i].vrniCeno()/60.0)*klici[i].VrniDolzino();
        }						
	return (cena + this.mesecnaNarocnina);
    }
    
    public String VrniStevilko(){
        return this.telefonskaStevilka;
    }
    
    public String VrniIme(){
        return this.ime;
    }
    
    public String VrniPriimek(){
        return this.priimek;
    }
    
    public int VrniPaket(){
        return this.paket;
    }
    
    public double VrniNarocnino(){
        return this.mesecnaNarocnina;
    }
    
    public String[] VrniPrijatelje(){
        return this.stevilke;
    }
    public Klic[] VrniKlice(){
        return klici;
    }
}
