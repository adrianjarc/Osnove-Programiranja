/*
Berač se usede na pločnik živahne ulice in predse pomoli svoj klobuk. Po ulici se poleg
domačinov sprehaja tudi veliko angleških in ameriških turistov. Domačini beraču v klobuk
mečejo evre, Angleži in Američani pa funte oziroma dolarje. Berač zaključi svoj dnevni
"šiht", ko zbere denar v vrednosti 50 evrov. Ker ne zna preračunavati funtov in dolarjev,
v evre mu moramo pomagati.

Napišite program, ki simulira potek beračevega "šihta". Za vsakega mimoidočega naključno
izberite številko valute (0: evro, 1: funt, 2: dolar) in podarjeni znesek (celo številko 
med 1 in vključno 5). Sproti izpisujte prejemke in količino denarja v beračevem klobuku 
v evrih.

V programu napišite in uporabite naslednji metodi:

-- private static String oznakaValute(int valuta)

	Ta metoda vrne oznako valuite za podano številko valute
	(0 --> "EUR", 1 --> "GBP", 2 --> "USD")
	
-- private static double preracunajVEvre(double znesek, int valuta)

	Ta metoda vrne znesek v evrih, ki ustreza podanemu znesku v podani valuti. Na primer
	klic preracunajVEvre(2.7, 1) vrne vrednost v evrih, ki ustreza znesku 2.7 GBP.

Primer izpisa:

  Prejemnik      Klobuk
--------------------------
      4 GBP    4.97 EUR
      4 EUR    8.97 EUR
      2 USD   10.51 EUR
      3 USD   12.82 EUR
      5 EUR   17.82 EUR
      3 USD   20.13 EUR
      2 EUR   22.13 EUR
      4 EUR   26.13 EUR
      1 GBP   27.37 EUR
      3 USD   29.68 EUR
      1 GBP   30.92 EUR
      4 GBP   35.89 EUR
      3 USD   38.20 EUR
      2 EUR   40.20 EUR
      2 EUR   42.20 EUR
      2 EUR   44.20 EUR
      4 USD   47.28 EUR
      3 GBP   51.00 EUR	
--------------------------	
*/

public class Berac {

	// tecajnice
	private static final double TECAJ_USD = 0.7696;
	private static final double TECAJ_GBP = 1.2424;
	
	// ciljni znesek v klobuku (v EUR)
	private static final double CILJNI_ZNESEK_V_KLOBUKU = 50.0;
	
	// metoda vrne oznako valute za podano stevilko valute (0 --> "EUR", 1 --> "GBP", 2 --> "USD")
	
	private static String oznakaValute(int valuta) {
		switch (valuta) {
			case 0:
				return "EUR";
			case 1:
				return "GBP";
			case 2:
				return "USD";
		}
		return "neznana valuta";
	}
	
	// vrne znesek v evrih, ki ustreza podanemu znezku v podani valuti
	
	private static double preracunajVEvre(double znesek, int valuta) {
		if (valuta <= 0 || valuta > 2) {
			return znesek;
		}
		double tecaj = 1;
		if (valuta == 1)
			tecaj = TECAJ_GBP;
		else if (valuta == 2)
			tecaj = TECAJ_USD;
		// double tecaj = (valuta == 1) ? TECAJ_GBP :TECAJ_USD;
		return znesek * tecaj;
	}
	
	private static void crta(int len, boolean nline) {
		for (int i = 0; i < len; i++)
			System.out.print("-");
		if (nline)
			System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.printf("%11s %11s%n", "Prejemnik", "Klobuk");
		crta(28, true);
		
		double klobuk = 0.0;
		while (klobuk < CILJNI_ZNESEK_V_KLOBUKU) {
			int valuta = (int)(Math.random() * 3);
			int znesek = 1 + (int)(Math.random() * 5);
			
			String oznaka = oznakaValute(valuta);
			double prejemek = preracunajVEvre(znesek, valuta);
			klobuk += prejemek;
			
			System.out.printf("%7d %s %7.2f EUR %n", znesek, oznaka, klobuk);
		}
		crta(28, true);
	}
}