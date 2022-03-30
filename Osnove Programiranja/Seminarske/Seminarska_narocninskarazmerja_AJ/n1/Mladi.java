package n1;

import semop3.*;

public class Mladi extends Narocnik {
    
    private static final int M = 100;
    
    public double znesekRacuna(double mesecnaNarocnina){
        if(this.VrniKlice().length < 1){
            return this.VrniNarocnino();
        }
        boolean n = true;
        double cena = 0;
        int sum = 0;
        for(int i = 0;i < this.VrniKlice().length;i++){
            if(this.VrniKlice()[i].VrniDolzino() + sum >= M*60 && n){
                n = false;
                cena += (this.VrniKlice()[i].VrniDolzino()-(M*60 - sum)) / 60.0 *this.VrniKlice()[i].vrniCeno();
                sum += this.VrniKlice()[i].VrniDolzino();
                continue;
            }
            sum += this.VrniKlice()[i].VrniDolzino();
            if(sum >= M*60){
                cena +=(this.VrniKlice()[i].VrniDolzino() <= 60)? this.VrniKlice()[i].vrniCeno() : 0;
                cena +=(this.VrniKlice()[i].VrniDolzino() > 60)?( this.VrniKlice()[i].vrniCeno()/60.0)*this.VrniKlice()[i].VrniDolzino() : 0;			
            }
        }
        return (cena + this.VrniNarocnino());
    }
}
