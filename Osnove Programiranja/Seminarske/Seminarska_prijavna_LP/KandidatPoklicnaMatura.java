class KandidatPoklicnaMatura extends Kandidat {
	private int ocenaDodatnegaPredmeta;
	// možna števila točk za uspeh pri poklicni maturi
	private static final double[] TOCKE_POK_MATURA = {
	40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 93, 96.7, 98.3, 100
	};
	// možna števila točk za oceno iz dodatnega predmeta
	private static final int[] TOCKE_DOD_PREDMET = {40, 60, 80, 100};
	// prvi element predstavlja delež v odstotkih, ki ga pri izračunu skupnega
	// števila točk predstavlja uspeh v 3. in 4. letniku, drugi element delež,
	// ki ga predstavlja uspeh pri poklicni maturi, tretji element pa delež,
	// ki ga predstavlja uspeh pri dodatnem predmetu
	private static final int[] DELEZI = {20, 20, 60};
	private static String vrstaMature;
	
	public KandidatPoklicnaMatura(int stPrijave, String ime, String priimek, int uspeh3, int uspeh4, int[] ocenePredmetovNaMaturi, int ocenaDodatnegaPredmeta){
		super(stPrijave, ime, priimek, uspeh3, uspeh4, ocenePredmetovNaMaturi);
		this.ocenaDodatnegaPredmeta = ocenaDodatnegaPredmeta;
		this.vrstaMature = "poklicna";
	}
	
	public double tockeZaPoklicnoMaturo(){
		return(TOCKE_POK_MATURA[this.uspehMatura() - 8]);
	}
	
	public int tockeZaDodatniPredmet(){
		return(TOCKE_DOD_PREDMET[ocenaDodatnegaPredmeta - 2]);
	}
	
	public double skupajTock(){
		return(this.tockeZaUspeh34()*DELEZI[0]/100 + this.tockeZaPoklicnoMaturo()*DELEZI[1]/100 + this.tockeZaDodatniPredmet()*DELEZI[2]/100);
	}
	
	public String toString(){
		return(String.format("(%d) <%s> %s %s | %s | [%s] | %d | %.2f", this.getId(), this.vrstaMature, this.getIme(), this.getPriimek(), this.getUspeh(), this.getOcenePredmetovNaMaturi(), this.ocenaDodatnegaPredmeta, this.skupajTock()));
	}
}
