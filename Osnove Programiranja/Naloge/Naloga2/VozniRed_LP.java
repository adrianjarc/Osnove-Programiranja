/*
Luka Pušić <luka@pusic.si>
Vozni red
*/

import java.util.Scanner;

public class VozniRed_LP{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Ura začetka vožnje: ");
		int ura_zacetka = stdin.nextInt();
		System.out.print("Minuta začetka: ");
		int minuta_zacetka = stdin.nextInt();
		System.out.print("Ura konca: ");
		int ura_konca = stdin.nextInt();
		System.out.print("Minuta konca: ");
		int minuta_konca = stdin.nextInt();
		System.out.print("Interval v min: ");
		int interval = stdin.nextInt();
		int cas; String ura, minute;
		for(cas = 0; cas <= (ura_konca - ura_zacetka)*60 + (minuta_konca - minuta_zacetka); cas += interval){
			//ura in minute naj bodo string, zato "" spredaj
			ura = ""+(ura_zacetka + (cas + minuta_zacetka) / 60);
			minute = ""+((cas + minuta_zacetka) % 60);
			//če je ura ali minuta ena števka, dodaj prefix 0
			if(minute.length() < 2){minute = "0"+minute;}
			if(ura.length() < 2){ura = "0"+ura;}

			System.out.print(ura+":"+minute+" ");
		}
	}
}
