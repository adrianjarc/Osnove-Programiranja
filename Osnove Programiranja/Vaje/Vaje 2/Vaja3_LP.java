/*
Luka Pušić <luka@pusic.si>
FRI, 2012
Piramida
*/

import java.util.Scanner;

public class Vaja3_LP{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Vnesite visino piramide: ");
		int n = sc.nextInt();
		int j;
		for(int i = 0; i < n; i++){
			for(j = 0; j < n-i-1; j++){
				System.out.print(" ");
			}
			for(j = 0; j < i*2+1; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
