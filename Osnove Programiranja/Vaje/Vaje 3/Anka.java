/*
Kleptomanka Anka bi rada ukradla kolo, ki je zaščiteno s številčno ključavnico. 
Ključavnica ima tri številska mesta (A-B-C). Nekdo Anki prišepne, da je prva številka liha,
zadnja deljiva s 3, srednja številka pa večja od t (t je številka med 0 in 8, ki jo vnese 
uporabnik). 

Napišite program, ki izpiše vse možne kombinacije števk. Na koncu naj program izpiše, 
koliko je teh kombinacij.

t = 7

1-8-0	5-9-0
1-8-3	5-9-3
1-8-6	5-9-6
1-8-9	5-9-9
1-9-0	7-8-0
1-9-3	7-8-3
1-9-6	7-8-6
1-9-9	7-8-9
3-8-0	7-9-0
3-8-3	7-9-3
3-8-6	7-9-6
3-8-9	7-9-9
3-9-0	9-8-0
3-9-3	9-8-3
3-9-6	9-8-6
3-9-9	9-8-9
5-8-0	9-9-0
5-8-3	9-9-3
5-8-6	9-9-6
5-8-9	9-9-9
...

Stevilo kombinacij: 40
*/

public class Anka {

	public static void main(String[] args) {
	
		System.out.print("Vnesi stevilo med 0 in vkljucno 8: ");
		int t = BranjePodatkov.preberiInt();

		int stKombinacij = 0;
		// for (int prva = 1; prva <= 9; prva++)
		// 		if (prva % 2 == 1)
		for (int prva = 1; prva <= 9; prva += 2) {
			for (int druga = t + 1; druga <= 9; druga++) {
				for (int tretja = 0; tretja <= 9; tretja += 3) {
					System.out.print(prva);
					System.out.print("-");
					System.out.print(druga);
					System.out.print("-");
					System.out.print(tretja);
					// System.out.printf("%d-%d-%d %n", prva, druga, tretja);
				}
			}	
		}
		
		System.out.println("Stevilo kombinacij: " + stKombinacij);
	}
}