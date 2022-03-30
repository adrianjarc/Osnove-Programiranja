/*
V klubu matematičnih plesalcev so moški in ženske označeni z zaporednimi številkami
od 1 naprej. Moški s številko <m> lahko pleše z žensko s številko <z> samo, če je
GCD (največji skupni delitelj) števil <m> in <z> enak določenemu številu ("ustrezni GCD").

Napišite program, ki prebere število moških, število žensk in ustrezni GCD, nato pa
izpiše vse možne plesne pare.

Primer:
	
	Stevilo moskih: 10
	Stevilo zensk: 10
	Ustrezni GCD: 3
	
	Par 1: moski 3 in zenska 3
	Par 2: moski 3 in zenska 6
	Par 3: moski 3 in zenska 9
	Par 4: moski 6 in zenska 3
	Par 5: moski 6 in zenska 9
	Par 6: moski 9 in zenska 3
	Par 7: moski 9 in zenska 6
*/

public class Plesalci {

	// greatest common divisor 
	
	private static int gcd(int a, int b) {
		while (a != b) {
			if (a > b)
				a = a - b;
			else if (b > a)
				b = b - a;
		}
		return a;
	}
	
	// least common multiple
	private static int lcm(int a, int b) {
		return a*b / gcd(a, b); 
	}

	public static void main(String[] args) {
		System.out.print("Stevilo moskih: ");
		int stMoskih = BranjePodatkov.preberiInt();
		System.out.print("Stevilo zensk: ");
		int stZensk = BranjePodatkov.preberiInt();
		System.out.print("Ustrezni GCD: ");
		int ustrezniGCD = BranjePodatkov.preberiInt();
		System.out.println();
		
		int stevilkaPara = 1;
		for (int m = 1; m <= stMoskih; m++) {
			for (int z = 1; z <= stZensk; z++) {
				if (gcd(m, z) == ustrezniGCD) {
					System.out.printf("Par %d: moski %d in zenska %d%n", stevilkaPara, m, z);
					stevilkaPara++;
				}
			}
		}
	}
}