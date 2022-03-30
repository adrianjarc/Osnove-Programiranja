package n3;

import semop3.*;

public class Test {
    
    static Narocnik[] Narocniki = new Narocnik[10];
    static String[] stevilke;
    static int c=0;
    static int p;
    static int in;
    static int[] r = new int[10];
    
    public static void main(String[] args) {
        NastaviNarocnike();
        ZapolniTabeloStevilk(Narocniki.length);
        for(int i=0;i<Narocniki.length;i++){
            int d = stevilke.length-1;
            ZapolniStevilkeNarocnikov(d);
        }
        Prijatelji();
        for (int i=0;i<Narocniki.length;i++){
            Klici(i);
        }
        for (int i=0;i<Narocniki.length;i++){
            Racun(i);
            Znesek(i);
        }
        System.out.printf("Narocnik iz paketa prijatelji, ki je klical na največ različnih številk ima indeks: %d\n", najvecRazlicnih(Narocniki));
    }
    
    static void NastaviNarocnike(){
        Narocniki[0] = new Prijatelji();
        Narocniki[0].NastaviNarocnika("00-00-00", "Ana", "Amon", 20.0, 1);
        Narocniki[1] = new Mladi();
        Narocniki[1].NastaviNarocnika("01-01-01", "Boris", "Bor", 25.4, 2);
        Narocniki[2] = new Narocnik();
        Narocniki[2].NastaviNarocnika("02-02-02", "Cene", "Cajzek", 31.2, 0);
        Narocniki[3] = new Prijatelji();
        Narocniki[3].NastaviNarocnika("03-03-03", "Denis", "Debeljak", 32.0, 1);
        Narocniki[4] = new Mladi();
        Narocniki[4].NastaviNarocnika("04-04-04", "Eva", "Erjavec", 15.5, 2);
        Narocniki[5] = new Narocnik();
        Narocniki[5].NastaviNarocnika("05-05-05", "Franci", "Fink", 40.0, 0);
        Narocniki[6] = new Prijatelji();
        Narocniki[6].NastaviNarocnika("06-06-06", "Gabrijela", "Golob", 17.5, 1);
        Narocniki[7] = new Mladi();
        Narocniki[7].NastaviNarocnika("07-07-07", "Haris", "Hujič", 20.0, 2);
        Narocniki[8] = new Narocnik();
        Narocniki[8].NastaviNarocnika("08-08-08", "Ivan", "Ilc", 35.3, 0);
        Narocniki[9] = new Prijatelji();
        Narocniki[9].NastaviNarocnika("09-09-09", "Janez", "Jamšek", 12.5, 1);
    }
    
    static void ZapolniTabeloStevilk(int d){
        stevilke = new String[d];
        for(int i=0;i<stevilke.length;i++){
            stevilke[i] = Narocniki[i].VrniStevilko();
        }     
    }
    
    static void ZapolniStevilkeNarocnikov (int d){
        String[] st = new String[d];
        int k=0;
        for(int i=0;i<stevilke.length;i++){
            if(!(stevilke[i].equals(Narocniki[c].VrniStevilko()))){
                st[k]=stevilke[i];
                k++; 
            }
        }
       Narocniki[c].NapolniMozneStevilkezaNarocnika(st.length, st);
       c++;
    }
    
    static void Prijatelji(){
        String[] pr = {"01-01-01", "03-03-03", "05-05-05"};
        Narocniki[0].NastaviPrijatelje(pr);
        String[] pr1 = {"02-02-02", "04-04-04", "06-06-06"};
        Narocniki[3].NastaviPrijatelje(pr1);
        String[] pr2 = {"00-00-00", "02-02-02", "04-04-04"};
        Narocniki[6].NastaviPrijatelje(pr2);
        String[] pr3 = {"04-04-04", "06-06-06", "08-08-08"};
        Narocniki[9].NastaviPrijatelje(pr3);
    }
    
    static void Klici(int i){
        Narocniki[i].Klici();
    }
    
    static void Racun(int i){
        if (Narocniki[i].VrniPaket() == 0){
            System.out.printf("<navaden> %s, %s %s, %.2f EUR/mesec\nKlici: [", Narocniki[i].VrniStevilko(),Narocniki[i].VrniIme(), Narocniki[i].VrniPriimek(), Narocniki[i].VrniNarocnino());
            Narocniki[i].IzpisiKlice();
            System.out.println("]");
        } else if (Narocniki[i].VrniPaket() == 1){
            System.out.printf ("<prijatelji> %s, %s %s, %.2f EUR/mesec [", Narocniki[i].VrniStevilko(),Narocniki[i].VrniIme(), Narocniki[i].VrniPriimek(), Narocniki[i].VrniNarocnino());
            String[] s = Narocniki[i].VrniPrijatelje();
            for (int j=0;j<s.length;j++){
                if(j<(s.length-1)){
                    System.out.printf("%s, ", s[j]);                    
                } else {
                    System.out.printf("%s]\nKlici: [", s[j]); 
                }
            }
            Narocniki[i].IzpisiKlice();
            System.out.println("]");
        }else if (Narocniki[i].VrniPaket() == 2){
            System.out.printf ("<mladi> %s, %s %s, %.2f EUR/mesec\nKlici: [", Narocniki[i].VrniStevilko(),Narocniki[i].VrniIme(), Narocniki[i].VrniPriimek(), Narocniki[i].VrniNarocnino());
            Narocniki[i].IzpisiKlice();
            System.out.println("]");
        }
    }
    
    static void Znesek(int i){
        System.out.printf("Znesek računa: %.2f EUR\n", Narocniki[i].znesekRacuna());
    }
    
    private static int najvecRazlicnih(Narocnik[] t){
        for (int i=0;i<t.length;i++){
            if (t[i].VrniPaket() == 1){
                p++;
            }
        }if (p>0){
            for (int i=0;i<t.length;i++){
                String[] g = new String[t[i].VrniKlice().length];
                int dol = g.length;
                for (int j=0;j<g.length;j++){
                    g[j] = t[i].VrniKlice()[j].VrniStevilko();
                }
                for (int j=(dol-1);j<g.length;j++){
                    for (int k=(dol-1);k>=0;k--){
                        if (!g[j].equalsIgnoreCase(g[k])){
                            r[i]++;
                        }
                    }
                }
            }
            for (int i=0;i<r.length;i++){
                for (int j=(r.length-1);j>=0;j--){
                    if (r[i]>r[j]){
                        in = i;
                    } else {
                        in = j;
                    }
                }
            }
            return in;
        } else {
            return -1;
        }
    }
}
