public class TestOseba {
	public static void main(String[] args) {
		osnovniPreizkus();
		preizkusRelacij();
	}
	private static void osnovniPreizkus() {
		Oseba joze = new Oseba("Jože", "Gorišek", true, 1953);
		Oseba ana = new Oseba("Ana", "Gorišek", false, 1956);

		System.out.println("Jožetov priimek: " + joze.getPriimek());
		System.out.println("Anino leto rojstva: " + ana.getLetoRojstva());
		System.out.println("Jože bo postal Jožek ...");
		joze.setIme("Jožek");

		System.out.println();
		System.out.println(joze.toString());
		System.out.println(ana.toString());

		System.out.println();
		System.out.printf("Jože bo leta 2030 star %d let.%n", joze.starost(2030));
		System.out.printf("Ana letos praznuje %d let.%n", ana.starost());

		System.out.println();
		System.out.println("joze.jeStarejsaOd(ana): " + joze.jeStarejsaOd(ana));
		System.out.println("ana.jeStarejsaOd(joze): " + ana.jeStarejsaOd(joze));
		System.out.println("joze.jeStarejsaOd(joze): " + joze.jeStarejsaOd(joze));

		System.out.println();
		System.out.println("Število ustvarjenih oseb: " + Oseba.getStUstvarjenih());
	}

	private static void preizkusRelacij() {
		Oseba os11 = new Oseba("Jožef", "Pogačnik", true, 1921);
		Oseba os12 = new Oseba("Marija", "Pogačnik", false, 1928);
		Oseba os13 = new Oseba("France", "Kotnik", true, 1932);
		Oseba os14 = new Oseba("Ivana", "Kotnik", false, 1931);
		Oseba os15 = new Oseba("Anton", "Zajc", true, 1922);
		Oseba os21 = new Oseba("Marjan", "Pogačnik", true, 1946, os11, os12);
		Oseba os22 = new Oseba("Dana", "Pogačnik", false, 1950);
		Oseba os23 = new Oseba("Milan", "Smole", true, 1953);
		Oseba os24 = new Oseba("Metka", "Smole", false, 1953);
		Oseba os25 = new Oseba("Zvone", "Kotnik", true, 1956, os13, os14);
		Oseba os26 = new Oseba("Tanja", "Kotnik", false, 1954);
		Oseba os27 = new Oseba("Branka", "Zajc", false, 1952, os15, os14);
		Oseba os31 = new Oseba("Dejan", "Pogačnik", true, 1973, os21, os22);
		Oseba os32 = new Oseba("Mojca", "Pogačnik", false, 1977, os23, os24);
		Oseba os33 = new Oseba("Miha", "Smole", true, 1978, os23, os24);
		Oseba os34 = new Oseba("Neža", "Smole", false, 1980, os25, os26);
		Oseba os35 = new Oseba("Aleš", "Kotnik", true, 1982, os25, os26);
		Oseba os36 = new Oseba("Jana", "Kotnik", false, 1981);
		Oseba os41 = new Oseba("Rok", "Pogačnik", true, 2003, os31, os32);
		Oseba os42 = new Oseba("Eva", "Pogačnik", false, 2006, os31, os32);
		Oseba os43 = new Oseba("Gal", "Smole", true, 2009, os33, os34);
		Oseba os44 = new Oseba("Maj", "Kotnik", true, 2010, os35, os36);
		Oseba os45 = new Oseba("Nika", "Kotnik", false, 2012, os35, os36);
		System.out.println("os32.imeOceta(): " + os32.imeOceta()); // Milan
		System.out.println("os27.imeOceta(): " + os27.imeOceta()); // Anton
		System.out.println("os14.imeOceta(): " + os14.imeOceta()); // null
		System.out.println();
		System.out.println("os32.jeBratAliSestraOd(os33): " + os32.jeBratAliSestraOd(os33)); // true
		System.out.println("os32.jeBratAliSestraOd(os31): " + os32.jeBratAliSestraOd(os31)); // false
		System.out.println("os27.jeBratAliSestraOd(os25): " + os27.jeBratAliSestraOd(os25)); // false
		System.out.println();
		System.out.println("os27.jeBratOd(os25): " + os27.jeBratOd(os25)); // false
		System.out.println("os32.jeBratOd(os33): " + os32.jeBratOd(os33)); // false
		System.out.println("os33.jeBratOd(os32): " + os33.jeBratOd(os32)); // true
		System.out.println("os13.jeBratOd(os14): " + os13.jeBratOd(os14)); // false
		System.out.println();
		System.out.println("os34.jeSestra(os35): " + os34.jeSestraOd(os35)); // true
		System.out.println("os35.jeSestra(os34): " + os35.jeSestraOd(os34)); // false
		System.out.println("os34.jeSestra(os26): " + os34.jeSestraOd(os26)); // false
		System.out.println();
	}
}
/*
System.out.println("os34.jePolsestraOd(os35): " + os34.jePolsestraOd(os35)); // false
System.out.println("os27.jePolsestraOd(os25): " + os27.jePolsestraOd(os25)); // true
System.out.println("os25.jePolsestraOd(os27): " + os25.jePolsestraOd(os27)); // false
System.out.println();
System.out.println("os23.jeStariOceOd(os42): " + os23.jeStariOceOd(os42)); // true
System.out.println("os11.jeStariOceOd(os41): " + os11.jeStariOceOd(os41)); // false
System.out.println("os22.jeStariOceOd(os41): " + os22.jeStariOceOd(os41)); // false
System.out.println();
System.out.println("os32.jeTetaOd(os43): " + os32.jeTetaOd(os43)); // true
System.out.println("os34.jeTetaOd(os45): " + os34.jeTetaOd(os45)); // true
System.out.println("os35.jeTetaOd(os43): " + os35.jeTetaOd(os43)); // false
System.out.println();
System.out.println("os11.jeOcetovskiPrednikOd(os41): " + os11.jeOcetovskiPrednikOd(os41)); // true
System.out.println("os23.jeOcetovskiPrednikOd(os42): " + os23.jeOcetovskiPrednikOd(os42)); // false
System.out.println("os13.jeOcetovskiPrednikOd(os45): " + os13.jeOcetovskiPrednikOd(os45)); // true
System.out.println("os14.jeOcetovskiPrednikOd(os45): " + os14.jeOcetovskiPrednikOd(os45)); // false
System.out.println("os15.jeOcetovskiPrednikOd(os14): " + os15.jeOcetovskiPrednikOd(os14)); // false
System.out.println();
System.out.println("os11.jeOcetovskiPrednikOd_r(os41): " + os11.jeOcetovskiPrednikOd_r(os41)); // true
System.out.println("os23.jeOcetovskiPrednikOd_r(os42): " + os23.jeOcetovskiPrednikOd_r(os42)); // false
System.out.println("os13.jeOcetovskiPrednikOd_r(os45): " + os13.jeOcetovskiPrednikOd_r(os45)); // true
System.out.println("os14.jeOcetovskiPrednikOd_r(os45): " + os14.jeOcetovskiPrednikOd_r(os45)); // false
System.out.println("os15.jeOcetovskiPrednikOd_r(os14): " + os15.jeOcetovskiPrednikOd_r(os14)); // false
System.out.println();
}
*/
