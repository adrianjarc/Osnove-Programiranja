/*
Luka Pušić, <luka@pusic.si>
FRI, 2012
Vraževerni Boris
*/

import java.util.Scanner;
import java.util.Random;

public class VrazeverniBoris{

	public static void main(String[] args){

		Random rand = new Random();
		Scanner stdin = new Scanner(System.in);

		System.out.print("Vnesi število dni: ");
		int n = stdin.nextInt();
		for(int dan = 1; dan <= n; dan++){
			int stMetov = 0, stLihih = 0, dozaDneva, randSt;
			System.out.print(dan+". dan: ");
			dozaDneva = (dan % 7 == 0) ?  5 : 3;
			while(stLihih < dozaDneva){
				randSt = rand.nextInt(6)+1;
				if(randSt % 2 != 0){stLihih++;}
				stMetov++;
				System.out.print(randSt+" ");
			}
			System.out.println("| skupaj: "+stMetov+" metov");
		}
	}
}
