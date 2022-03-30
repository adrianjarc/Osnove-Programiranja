/*
Luka Pušić <luka@pusic.si>
FRI, 2012
*/

import java.util.Scanner;

public class Seminarska{

	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);

		System.out.print("Koliko minut traja obravnava na okencu 1? ");
		int ucinkovitost1 = stdin.nextInt();
		System.out.print("Koliko minut traja obravnava na okencu 2? ");
		int ucinkovitost2 = stdin.nextInt();
		System.out.print("Koliko minut traja obravnava na okencu 3? ");
		int ucinkovitost3 = stdin.nextInt();
		
		int minuta = 0;
		int cakalna1 = 0, cakalna2 = 0, cakalna3 = 0;
		int cas1 = 0, cas2 = 0, cas3 = 0;
		
		while(true){
			minuta++;
			if(cas1 > 0){cas1--;}
			if(cas2 > 0){cas2--;}
			if(cas3 > 0){cas3--;}
			
			System.out.format("\nKoliko strank vstopi %d. minuto? ", minuta);
			
			int novihStrank = stdin.nextInt();
			if(novihStrank < 0){break;}
			
			// poglej, ce je cas da kdo odide
			if(ucinkovitost1 * (cakalna1-1) == cas1){cakalna1--;}
			if(ucinkovitost2 * (cakalna2-1) == cas2){cakalna2--;}
			if(ucinkovitost3 * (cakalna3-1) == cas3){cakalna3--;}
			
			System.out.format("Cakalni casi pred prihodom novih strank: %d | %d | %d\n", cas1, cas2, cas3);
			System.out.format("Dolzine vrst pred prihodom novih strank: %d | %d | %d\n", cakalna1, cakalna2, cakalna3);
			
			// vsako novo stranko razporedi na okence z najmanjšo vrsto
			for(int i=0; i < novihStrank; i++){
				if(cakalna1 <= Math.min(cakalna2,cakalna3)){cakalna1++;cas1+=ucinkovitost1;}
				else if(cakalna2 <= Math.min(cakalna1,cakalna3)){cakalna2++;cas2+=ucinkovitost2;}
				else if(cakalna3 <= Math.min(cakalna1,cakalna2)){cakalna3++;cas3+=ucinkovitost3;}
			}
			
			System.out.format("Dolzine vrst po prihodu novih strank: %d | %d| %d\n", cakalna1, cakalna2, cakalna3);
			System.out.format("Cakalni casi po prihodu novih strank: %d | %d| %d\n", cas1, cas2, cas3);
		}

	}
}
