/*
Luka Pušić <luka@pusic.si>
*/

import java.util.Scanner;

public class Vaja1_LP{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Vnesi stevilo: ");
		int n = sc.nextInt();
		while(n != 0){
			System.out.println(n%10);
			n = n / 10;
		}
	}
}
