import java.util.Scanner;

public class Koledar{

	public static void main(String[] args){
		Scanner beri = new Scanner(System.in);
		
		final int M = 10; 
		final int DM = 25;
		final int DT = 9;
		
		System.out.print("Vnesite stevilko prvega meseca izbranega zaporedja: ");
		int prviMesec = beri.nextInt();
		System.out.print("Vnesite stevilko zadnjega meseca izbranega zaporedja: ");
		int zadnjiMesec = beri.nextInt();
		System.out.print("Vnesite stevilko dneva v tednu za prvi dan izbranega leta: ");
		int stDneva = beri.nextInt();
		int prelomniDan, zamik;
		int zadnjiPrelomni = -1000000; //kr ena vrednost, ker se itak določi znotraj zanke kasneje
		String zacasno; //v to spremenljivko shranjujemo izpis
		
		// PREVERI PRAVILNOST SPREMENLJIVK
		if(zadnjiMesec > M){
			System.out.println( "Napaka. Zadnji mesec je vecji od st. mesecev!");
			System.exit(0);
		}
		if(DM <= DT){
			System.out.println( "Napaka. Dnevov v mesecu mora biti več kot v tednu!");
			System.exit(0);
		}
		
		// GLAVNI DEL
		if(zadnjiMesec < prviMesec){
			zadnjiMesec = M + zadnjiMesec;
		}
		prelomniDan = DT - stDneva + 1;
		zamik = stDneva - 1;
		
		for(int mesec = 1; mesec <= zadnjiMesec; mesec++){
			zacasno = String.format("[Mesec %2d]\n", mesec); //izpisi trenutni mesec
			
			for(int dnevi = 1; dnevi <= DT; dnevi++){
				zacasno += String.format("%5d", dnevi); //izpisi dneve v tednu na vrhu (npr. 1 2 3 4 5 6 7)
			}
			zacasno += "\n"; //nova vrstica
			
			for(int crtica = 1; crtica <= DT * 5; crtica++){
				zacasno += "-"; //narisi crtice (dnevi v tednu * 5)
			}
			zacasno += "\n";
			
			//za vsak dan v mesecu izpisi dan
			for(int dan = 1; dan <= DM; dan++){
				//pred prvim dnevom izpisi izracunan zamik
				if(dan == 1){
					for(int z = 0; z < zamik; z++){
						zacasno += "     ";
					}
				}
				zacasno += String.format("%5d", dan);
				//poglej ce je cas, da gremo v novo vrstico
				if(dan % DT == prelomniDan){
					zadnjiPrelomni = dan;
					zacasno += "\n";
				}
			}
			
			zamik = DM - zadnjiPrelomni; //po formuli - zamik je (dnevov v mesecu minus prelomni dan predzadnje vrstice)
			prelomniDan = DT - zamik; //po forumuli - prelomi dan v novo vrstico pri (dolzina tedna - zamik), razen
			if(prelomniDan == DT){prelomniDan = 0;} //ce je prelomni dan DT, potem naj bo 0, ker bo tukaj dan % DT == 0, ne pa 7
			
			zacasno += "\n";
			
			//IZPISUJ SAMO MESECE V VNESENEM INTERVALU
			if(mesec >= prviMesec){
				System.out.println(zacasno);
				zacasno = "";
			}
		}
	}
}
