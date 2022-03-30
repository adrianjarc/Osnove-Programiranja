/*
Avtor: Luka Pušić, <luka@pusic.si>
FRI, 2012
*/

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Uredi3{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int a, b, c;
		System.out.print("Enter a: ");
		a = in.nextInt();
		System.out.print("Enter b: ");
		b = in.nextInt();
		System.out.print("Enter c: ");
		c = in.nextInt();

		int[] ints = {a,b,c};
		Arrays.sort(ints);
		System.out.println(ints[0]+" "+ints[1]+" "+ints[2]);
	}
}
