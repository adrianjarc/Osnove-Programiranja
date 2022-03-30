/*
Avtor: Luka Pušiæ, <luka@pusic.si>
FRI, 2012
*/

import java.io.*;
import java.util.Scanner;

public class Postevanka2{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int a, b, i = 1;
		System.out.print("Vnesite pozitivno celo število: ");
		a = in.nextInt();
		System.out.print("Vnesite zgornjo mejo: ");
		b = in.nextInt();
		
		//preveri pristnost uporabnikovega vnosa ;)
		if(a<=0){System.out.println("Število ni pozitivno!");}

		while(a*i < b){
			System.out.println(a+" * "+i+" = "+(a*i));
			i++;
		}
	}
}
