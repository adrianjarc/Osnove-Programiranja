/*
Luka Pušić <luka@pusic.si>
FRI, 2012
Anžetove Sveče
*/

import java.util.Scanner;

public class AnzetoveSvece{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Vnesite višino (>= 2): ");
		int visina = stdin.nextInt();
		int sirina = (int)Math.pow(2,(visina-1))+1;
		int i,j;
		for(i = 0; i < visina; i++){
			for(j = 0; j < sirina; j++){
				if(j%((int)Math.pow(2,i)) == 0){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
