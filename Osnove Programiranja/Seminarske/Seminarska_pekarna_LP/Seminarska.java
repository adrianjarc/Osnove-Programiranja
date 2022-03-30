//Luka Pevec
import java.util.Scanner;

public class Seminarska {

	//dolocitev konstant
	private static final int ZALOGA = 10;
	private static final int K_ZALOGA = 8; //ce pade kruh pod to vrednost, prodajalec naroci novega
	private static final int NAROCILO = 10; 

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		//delovni cas pekarne
		System.out.print("Vnesite uro odprtja: ");
		int uraOdprtja = input.nextInt();
		System.out.print("Vnesite uro zaprtja: ");
		int uraZaprtja = input.nextInt();
		int trenutniCas = uraOdprtja * 60;
		int trenutnaZaloga = ZALOGA;
		int casNarocila = 0; //ce je cas 0 potem narocila ni, ce pa je vecje od 0 je to cas, ko je bilo naroceno

		while(trenutniCas < uraZaprtja*60) {
			int interval = (int)(Math.random()*10)+2; // Ta del generira stevilo med 2 in 11 - razmik med strankami.
			int velikostNarocila = (int)(Math.random()*4)+1; // Rand st. hlebcev, ki ga kupi posamezna stranka.
			trenutniCas += interval;

			int ura = trenutniCas / 60;
			int minuta = trenutniCas % 60;
			
			if(velikostNarocila > trenutnaZaloga){
				System.out.println("povprasevanje: "+velikostNarocila+", premalo kruha, izguba: "+(velikostNarocila-trenutnaZaloga));
				trenutnaZaloga = 0;
			}else{
				trenutnaZaloga -= velikostNarocila;
				System.out.print(String.format("[ %02d:%02d ]", ura, minuta));
				System.out.println(", kupljeno hlebcev "+velikostNarocila+", zaloga ("+trenutnaZaloga+")");
			}
			//ce je zaloga pod mejo in ni se narocila, naroci
			if(trenutnaZaloga < K_ZALOGA && casNarocila == 0){
				casNarocila = trenutniCas;
				System.out.println("[Narocen]");
			}
			//ce narocilo obstaja in ce je cas za dostavo, dostavi
			if(casNarocila > 0 && casNarocila + 60 <= trenutniCas){
				trenutnaZaloga += NAROCILO;
				System.out.println("[Prispel]");
				casNarocila = 0; //ponastavi, ni vec narocil
			}
		}
		System.out.println("Ostalo je: "+trenutnaZaloga+" hlebcev.");
	}
}
