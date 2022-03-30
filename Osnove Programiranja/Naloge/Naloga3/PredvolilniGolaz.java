/*
Luka Pušić <luka@pusic.si>
FRI, 2012
Predvolilni Golaž
*/

import java.util.Scanner;

public class PredvolilniGolaz{


	public static void main(String[] args){

		boolean vino;
		int stKosil;
		double cenaKosila, koncnaCena;
		Scanner stdin = new Scanner(System.in);
		System.out.print("Vnesite začetno zalogo denarja: ");
		double budget = stdin.nextDouble();

		while(budget > 0){
			vino = false;
			System.out.print("\nVnesite ceno kosila: ");
			cenaKosila = stdin.nextDouble();
			System.out.print("Vnesite število kosil: ");
			stKosil = stdin.nextInt();
			System.out.print("So gostje naročili vino (1: da / 2: ne)? ");
			if(stdin.nextInt() == 1){vino = true;}
			koncnaCena = cenaPogostitve(cenaKosila, stKosil, vino);
			System.out.println("Skupna cena pogostitve znaša "+koncnaCena+" EUR.");
			budget -= koncnaCena;
			if(budget > 0){System.out.println("Trenutna zaloga denarja znaša "+budget+" EUR.");}
		}
		System.out.println("Zmanjkalo je denarja!");
	}

	private static double cenaPogostitve(double cenaKosila, int stKosil, boolean vino){
		double k = vino ? 1.5 : 1.0;
		return (cenaKosila * stKosil * k);
	}

}
