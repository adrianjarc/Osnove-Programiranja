/*
Vojaki bi se na poziv "V vrsto zbor!" morali razvrstiti po višini od najmanjšega do največjega,
a tega ne znajo najbolje. Napišite program, ki prebere zaporedje višin vojakov v
"vrsti zbor" in izpiše indekse vojakov, ki so postavljeni lokalno pravilno. Vojak je postavljen
lokalno pravilno, če je njegov levi sosed nižji ali enako visok, desni pa višji ali enako
visok kot on. Če noben vojak ni postavljen lokalno pravilno, naj program to sporoči z besedico
"nihce". Tabelo višin preberite iz tekstovne datoteke. Lahko si pomagate z metodo
BranjePodatkov.preberi1i.
Primer 1:
Za tabelo višin {185, 172, 180, 181, 190, 183, 178, 185, 191, 207} naj program izpiše:
Postavljeni lokalno pravilno: 2 3 7 8 9
Primer 2:
Za tabelo višin {175, 169, 183, 176, 200, 180} naj program izpiše:
Postavljeni lokalno pravilno: nihce
*/
public class VrstaZbor {
	private static final String VHODNA_DATOTEKA = "visine1.txt";
	private static void lokalnoPravilni(int[] visine) {

		System.out.print("Postavljeni lokalno pravilno: ");
		boolean vsajen = false;

		for (int i = 0; i < visine.length; i++) {
			if (visine[i] >= visine[i - 1] && visine[i] <= visine[i + 1]){
				System.out.print(visine[i]+", ");
				vsajen = true;
			}
		}
		if(vsajen == false){
			System.out.print("nobeden");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] visine = BranjePodatkov.preberi1i(VHODNA_DATOTEKA);
		lokalnoPravilni(visine);
	}
}
