/*
Avtor: Luka Pušiæ, <luka@pusic.si>
FRI, 2012
*/

import java.io.*;
import java.util.Scanner;

public class Zaporedja{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int a, b, k;
		System.out.print("Vnesi zaèetno število: ");
		a = in.nextInt();
		System.out.print("Vnesi konèno mejo: ");
		b = in.nextInt();
		System.out.print("Vnesi korak: ");
		k = in.nextInt();
		
		//preveri pristnost uporabnikovega vnosa ;)
		if(k == 0){System.out.println("K ne sme biti 0!");System.exit(0);}
		if(a<b && k<0){System.out.println("Predznak koraka ni usklajen z mejama.");System.exit(0);}
		if(a>b && k>0){System.out.println("Predznak koraka ni usklajen z mejama.");System.exit(0);}
		
		for(int i = a; i <= b; i+=k){
			System.out.println(i);
		}
		
		for(int i = a; i >= b; i+=k){
			System.out.println(i);
		}
	}
}
