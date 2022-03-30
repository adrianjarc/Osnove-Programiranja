/*
Luka Pušić <luka@pusic.si>
FRI, 2012
*/

import java.util.Scanner;

public class Piramida_LP{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int n, j, k, p;
		System.out.print("Vnesite višino piramide: ");
		n = in.nextInt();

		for(int i = 1; i <= n; i++){
			j = (i-1)*2+1;
			for(p = 0; p < n-i; p++){
				System.out.print(" ");
			}
			for(k = i; k < i+j; k++){
				System.out.print(k%10);
			}
			System.out.println();
		}
	}
}

