/*
Luka Pušić <luka@pusic.si>
FRI, 2012
*/

import java.util.Scanner;

public class Smucanje_LP{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Vnesi št. tekmovalcev: ");
		int st_tekmovalcev = stdin.nextInt();
		int zmagovalec = -1;
		int rekord = 0;
		for(int n = 1; n <= st_tekmovalcev; n++){
			System.out.print("Tekmovalec "+n+"\n\tVnesite čas v prvem teku: ");
			int cas1 = stdin.nextInt();
			if(cas1 == -1){
				continue;
			}
			System.out.print("\tVnesite čas v drugem teku: ");
			int cas2 = stdin.nextInt();
			if(cas2 != -1){
				if(cas1 + cas2 > rekord){
					zmagovalec = n;
					rekord = cas1 + cas2;
				}
			}
		}
		if(zmagovalec > 0){
			System.out.println("Najboljši skupni čas ("+rekord+") je dosegel tekmovalec "+zmagovalec+".");
		}else{
			System.out.println("Vse tekmovalce so diskvalificirali!");
		}
	}
}
