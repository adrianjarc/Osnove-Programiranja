/*
Avtor: Luka Pušiæ, <luka@pusic.si>
FRI, 2012
*/

import java.io.*;
import java.util.Scanner;

public class Potenca{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int a, b, c, i;
		System.out.print("Vnesite osnovo (>= 1): ");
		a = in.nextInt();
		System.out.print("Vnesite eksponent (>= 0): ");
		b = in.nextInt();
		
		//preveri pristnost uporabnikovega vnosa ;)
		if(a < 1 || b < 0){System.out.println("Tvoj vnos je neustrezen.");}
		
		c = a;
		for(i = 1; i < b; i++){
			c = c * a;
		}
			System.out.println(a+" ^ "+b+" = "+c);
	}
}
