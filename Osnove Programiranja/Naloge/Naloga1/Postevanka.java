/*
Avtor: Luka Pu�i�, <luka@pusic.si>
FRI, 2012
*/

import java.io.*;
import java.util.Scanner;

public class Postevanka{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int a, b, k;
		System.out.print("Vnesite celo �tevilo: ");
		a = in.nextInt();
		System.out.print("Vnesi celo pozitivno �tevilo: ");
		b = in.nextInt();
		
		//preveri pristnost uporabnikovega vnosa ;)
		if(b<=0){System.out.println("�tevilo ni pozitivno!");}

		for(int i = 1; i <= b; i++){
			System.out.println(a+" * "+i+" = "+(a*i));
		}
	}
}
