/*
Luka Pušić <luka@pusic.si>
Vaja 2 - Zgoscenke
*/

import java.util.Scanner;

public class Vaja2_LP{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Vnesite število praznih CD-jev: ");
		int velikost_cdja = 700;
		int st_cdjev = stdin.nextInt();
		int trenutni_cd = 1;
		int zasedeno = 0;
		while(trenutni_cd <= st_cdjev){
			System.out.print("Vnesite velikost datoteke v MB: ");
			int velikost_datoteke = stdin.nextInt();
			if(velikost_datoteke > velikost_cdja){
				System.out.println("Datoteka je prevelika!");
				System.exit(1);
			}else if(zasedeno + velikost_datoteke > velikost_cdja){
				trenutni_cd++;
				zasedeno = velikost_datoteke;
				System.out.print("Datoteka se shrani na CD št. "+trenutni_cd);
				System.out.println(", ki trenutno vsebuje " + zasedeno + " MB podatkov");
			}else{
				zasedeno += velikost_datoteke;
				System.out.print("Datoteka se shrani na CD št. "+trenutni_cd);
                                System.out.println(", ki trenutno vsebuje " + zasedeno + " MB podatkov");
			}
		}
	}
}
