/*
* Author: Adrian Jarc
*/

import java.util.Scanner;

public class UgibanjeStevil{

	static int n, ug, p;
	static double st = Math.random();
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args){
		System.out.print ("Koliko števk naj ima število? ");
		n = sc.nextInt();
		while(n<1 || n>9){
			System.out.print ("Število ima lahko samo od 1 - 9 števk. Vpiši ponovno: ");
			n = sc.nextInt();
		} //Evo èe sluèajno še kdo ni pogruntu kako se rešit problema èe da uporabnik preveliko ali premalo število števk.
		while (st<0.0){
			st = Math.random();
		} //To je tukaj za to da èe je število, ki ga je program izbral, sluèajno oblike 0.0... da to popravi ker drugaèe bi se število zaèelo z 0.
		Ugibanje();
	}
	
	public static void Ugibanje(){
		for (int i=0;i<n;i++){
			st *= 10;
		} //S temu forom postavimo število na pravilno število mest. To je tuki sam zato ker nismo preprièani o uporabi Math.pow()
		// Razlièica z Math.pow(); je: st *= (Math.pow(10,n)); Math.pow(); ni priporoèljiva.
		int st1 = (int)st;
		int ug1;
		int stu;
		while (ug != st1){
			System.out.print("Ugibajte: ");
			ug = sc.nextInt();
			if (ug < 0){
				System.out.print("Izbral sem stevilo: " +st1);
				break;
			}
			stu = String.valueOf(ug).trim().length(); //To je samo za število znakov pri ugibanju. Sicer je string ampak ga res ni nikjer kot spremenljivka. Btw tega ne uporabt.
			if (stu < n || stu > n){
				System.out.println("Število ima " + n + " števk");
				continue;
			}
			ug1 = ug;
			//Tukaj se zaène preverjanje števk
			for (int i=1;i<=n;i++){
				for (int j=n;j>i;j--){
					ug1 /= 10;
					st1 /= 10;
				}
				if (st1%10 > ug1%10){
					System.out.println(i + ". števka je premajhna."); //Tukaj pride izpis za i od 1-n
				}
				else if (st1%10 < ug1%10){
					System.out.println(i + ". števka je prevelika.");
				}
				st1 = (int)st;
				ug1 = ug;
			} //Konèano preverjanje štek skupaj z izpisom o njihovih vrednostih
			p++; //Poveèanje števila poskusov za konèni izpis
		}
		if (ug > 0){
			System.out.println("Èestitke! Potrebovali ste " + p + " poskusov");
		}
	}
}