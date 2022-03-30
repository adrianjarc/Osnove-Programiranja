import java.util.Scanner;

public class Monopoly {
    public static int POLJA = 7 + (int)(Math.random()*13);
    public static int IGRALCI = 2 + (int)(Math.random()*8);
    public static int c = 1;
    static Igralec []ig;
    static Polje []po;
    
    public static void main(String[] args) {
        ig = new Igralec[IGRALCI];
        po = new Polje[POLJA];
        for (int i=0;i<ig.length;i++){
            ig[i]= new Igralec();
            ig[i].nastavistIgralca((1+i));
            ig[i].nastaviSteviloPolj(POLJA);
            ig[i].narediTabelo();
            ig[i].nastaviprPolozaj(0);
			ig[i].nastavivprLasti(0);
        }
        for (int i=0;i<po.length;i++){
            po[i] = new Polje();
        }
        for (int i=0;i<1;i++){
            po[i].naPolju("x");
        }
        for(int i=1;i<po.length;i++){
            while(c%4 != 0){
                c = 4 + (int)(Math.random()*20);
            }
            po[i].nastaviCeno(c);
            po[i].nastavistPolja(i);
            po[i].nastaviprLastinstvo("-");
            c = 1;
        }
        igra();
    }		
    
    public static void igra(){
		System.out.printf("%s%7s", "Cene:"," ");
        for (int i=0;i<po.length;i++){
			System.out.printf("%4s", po[i].vrniStrCeno());
		}
		System.out.printf("\n%s%1s" ,"Lastništvo:"," ");
		for (int i=0;i<po.length;i++){
			System.out.printf("%4s", po[i].vrniLastnistvo());
		}
		System.out.println();
		for(int i=0;i<ig.length;i++){
			System.out.printf("Igralec " + ig[i].izpisistIgralca() + ":" + "%2s", " ");
			for(int j=0;j<po.length;j++){
				System.out.printf("%4s", po[j].vrninaPolju());
			}
			System.out.printf(" | %1d\n", ig[i].izpisiDenar());
		}
		Scanner sc = new Scanner(System.in);
		int k = 0;
		int dol = ig.length;
		while (dol > 1){
            if(ig[k].izpisiDenar() <= 0 && ig[k].vrnivLasti() == 0){
                k++;
                continue;
            }
            System.out.print("Na potezi je igralec " + ig[k].izpisistIgralca() +" (položaj: " + ig[k].vrniPolozaj() +" | denar: " + ig[k].izpisiDenar() + " enot).\nVnesite število pik: ");
            int premik = sc.nextInt();
            while (premik > 6){
                System.out.print("Ponovno vnesite število pik: ");
                premik = sc.nextInt();
            }
            ig[k].nastaviPolozaj(premik); 
            if(po[ig[k].vrniPolozaj()].vrnistPolja()== 0){
                System.out.println("Pristali ste na začetnem polju.\nStoriti ne morete ničesar.");
            }else {
                System.out.println("Pristali ste na polju " + po[ig[k].vrniPolozaj()].vrnistPolja() + ".");
            }
            if("-".equals(po[ig[k].vrniPolozaj()].vrniLastnistvo())){
                System.out.print("Posest " + po[ig[k].vrniPolozaj()].vrnistPolja() + " s ceno " + po[ig[k].vrniPolozaj()].vrniStrCeno() + " enot je še naprodaj.\nŽelite kupiti to posest (1: da / 2: ne)? ");
                int ku = sc.nextInt();
                if (ku == 1){
                    if(po[ig[k].vrniPolozaj()].vrniintCeno()<= ig[k].izpisiDenar()){
                        po[ig[k].vrniPolozaj()].nastaviLastnistvo(ig[k].izpisistIgralca());
                        ig[k].kupi(po[ig[k].vrniPolozaj()].vrniintCeno());
						ig[k].nastavivLasti(1);
                    } else {
                        System.out.println("Nimate dovolj denarja za nakup te posesti");
                    }
                }
            } else {
                for(int i = 0;i<ig.length;i++){
                    if(Integer.toString((k+1)).equals(po[ig[k].vrniPolozaj()].vrniLastnistvo())){
                        System.out.print("Posest " + po[ig[k].vrniPolozaj()].vrnistPolja() + " s ceno " + po[ig[k].vrniPolozaj()].vrniStrCeno() + " enot je v vaši lasti.\nSe želite odpovedati tej posesti in prejeti 4 enot denarja (1: da / 2: ne)? ");
                        int od = sc.nextInt();
                        if (od == 1){
                            po[ig[k].vrniPolozaj()].nastaviprLastinstvo("-");
                            ig[k].prejmiPlacilo((po[ig[k].vrniPolozaj()].vrniintCeno()/2));
                        }
                        break;
                    } else if(Integer.toString((i+1)).equals(po[ig[k].vrniPolozaj()].vrniLastnistvo())){
                        System.out.println("Posest " + po[ig[k].vrniPolozaj()].vrnistPolja() + " s ceno " + po[ig[k].vrniPolozaj()].vrnistPolja() + " enot je v lasti igralca " + ig[i].izpisistIgralca() + ".\nPlačati morate najemnino v višini " + po[ig[k].vrniPolozaj()].vrniNajemnino() + " enot denarja.");
                        ig[k].placaj(po[ig[k].vrniPolozaj()].vrniNajemnino());
                        ig[i].prejmiPlacilo(po[ig[k].vrniPolozaj()].vrniNajemnino());
                        if(ig[k].izpisiDenar()<=0){
                            System.out.println("Žal ste bankrotirali in izgubili.");
							ig[k].nastavivprLasti(0);
                            for (int j=0;j<po.length;j++){
                                if(Integer.toString((k+1)).equals(po[j].vrniLastnistvo())){
                                    po[j].nastaviprLastinstvo("-");
                                }
                            }
                            dol--;
                            break;
                        }
                    }
                }
            }         
            System.out.printf("%s%7s", "Cene:"," ");
            for (int i=0;i<po.length;i++){
                System.out.printf("%4s", po[i].vrniStrCeno());
            }
            System.out.printf("\n%s%1s" ,"Lastništvo:"," ");
            for (int i=0;i<po.length;i++){
                System.out.printf("%4s", po[i].vrniLastnistvo());
            }
            System.out.println();
            for(int i=0;i<ig.length;i++){
                if (ig[i].izpisiDenar() > 0 && ig[i].vrnivLasti() > 0){
                    System.out.printf("Igralec " + ig[i].izpisistIgralca() + ":" + "%2s", " ");
                    ig[i].izpisiPolja();
                    System.out.printf(" | %1d\n", ig[i].izpisiDenar());
                }
            }
            k++;
            if(k>=ig.length){
                k = 0;
            }
        }
        for (int i=0;i<ig.length;i++){
            if (ig[i].izpisiDenar()>0){
                System.out.print("Zmagal je igralec " + ig[i].izpisistIgralca());
            }
        }
    }
}