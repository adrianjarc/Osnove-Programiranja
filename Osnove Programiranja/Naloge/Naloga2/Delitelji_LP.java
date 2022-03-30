/*
Luka Pušić <luka@pusic.si>
FRI, 2012
*/

import java.util.Scanner;

public class Delitelji_LP{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int a, i;
		System.out.print("Vnesi pozitivno celo število: ");
		a = in.nextInt();

		if(a < 1){System.out.println("Nisi vnesel pozitivnega celega števila");System.exit(1);}

		for(i = 1; i <= a; i++){
			if(a % i == 0){System.out.print(i+" ");}
		}
		System.out.println();
	}
}

