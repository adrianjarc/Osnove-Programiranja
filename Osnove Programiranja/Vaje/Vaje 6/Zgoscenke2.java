/*
Na voljo imamo določeno število praznih 700-megabajtnih CD-jev, na katere bi radi shranili
svoje ključne datoteke. Nobena datoteka ni večja od 700 MB. Datoteke shranjujemo
zaporedoma. Vsako datoteko shranimo na tisti CD, na katerem je trenutno največ prostora.
Če je takih CD-jev več, izberemo prvega od njih.
Napišite program, ki najprej prebere število CD-jev, nato pa zaporedoma bere velikosti
datotek (v MB). Za vsako datoteko naj program izpiše, na kateri CD se shrani in koliko
MB podatkov je trenutno zapisanih na posameznih CD-jih. Program naj se zaključi, ko
zmanjka CD-jev ali ko uporabnik vnese 0.
Primer:
Vnesite število praznih CD-jev: 3
Vnesite velikost datoteke (v MB): 300
Datoteka se shrani na CD št. 1
[300, 0, 0]
Vnesite velikost datoteke (v MB): 200
Datoteka se shrani na CD št. 2
[300, 200, 0]
Vnesite velikost datoteke (v MB): 500
Datoteka se shrani na CD št. 3
[300, 200, 500]
Vnesite velikost datoteke (v MB): 400
Datoteka se shrani na CD št. 2
[300, 600, 500]
Vnesite velikost datoteke (v MB): 400
Datoteka se shrani na CD št. 1
[700, 600, 500]
Vnesite velikost datoteke (v MB): 150
Datoteka se shrani na CD št. 3
[700, 600, 650]
Vnesite velikost datoteke (v MB): 200
Datoteke ni mogoče shraniti na noben CD.
*/
import java.util.Scanner;
import java.util.Arrays;

public class Zgoscenke2 {
	private static final int KAPACITETA = 700;
	private static int n = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Vnesite stevilo praznih CD-jev: ");
		n = sc.nextInt();
		int[] cdji = new int[n];
		Arrays.fill(cdji, 0);
		while(true){
			System.out.print("Vnesite velikost datoteke v MB: ");
			int size = sc.nextInt();
			int minCd = najmanjZasedenCd(cdji);
			if(cdji[minCd]+size <= KAPACITETA && size != 0){
				cdji[minCd] += size;
				System.out.println("Datoteka se shrani na CD st. "+minCd);
				System.out.println(Arrays.toString(cdji));
			}else{
				System.out.println("Datoteke ni mogoče shraniti na noben CD");
				System.exit(0);
			}
		}
	}
	private static int najmanjZasedenCd(int[] cdji){
		int index = 0;
		for(int i = 1; i < cdji.length; i++){
			if(cdji[i] < cdji[i - 1]){
				index = i;
			}
		}
		return(index);
	}
}
