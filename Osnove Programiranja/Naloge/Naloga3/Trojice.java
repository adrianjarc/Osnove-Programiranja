/*
Luka Pušić <luka@pusic.si>
FRI, 2012
Trojice Števil
*/

import java.util.Scanner;

public class Trojice{


	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Vnesite zgornjo mejo: ");
		int n = stdin.nextInt();
		System.out.print("Vnesite GCD: ");
		int d = stdin.nextInt();
		int i, j, k;
		for(i = d; i < n; i+=d){
			for(j = i; j < n; j+=d){
				for (k = j; k < n; k+=d){
					if(gcd(gcd(i,j),k) == 3){
						System.out.println("("+i+", "+j+", "+k+")");
					}
				}
			}
		}
	}
	private static int gcd(int a, int b){
		if(b == 0){
			return(a);
		}else{
			return gcd(b, a % b);
		}
	}

}
