class KandidatSplosnaMatura extends Kandidat {
	// možna števila točk za uspeh pri splošni maturi
	private static final double[] TOCKE_SPL_MATURA = {
	40, 45, 47.5, 50, 55, 60, 65, 67.5, 70, 75, 80, 85, 87.5,
	90, 91, 92, 93, 94, 95, 95.8, 96.7, 97.5, 98.3, 99.2, 100
	};
	// prvi element predstavlja delež v odstotkih, ki ga pri izračunu skupnega
	// števila točk predstavlja uspeh v 3. in 4. letniku, drugi element pa delež,
	// ki ga predstavlja uspeh pri maturi
	private static final int[] DELEZI = {40, 60};
	private static String vrstaMature;
	
	public KandidatSplosnaMatura(int stPrijave, String ime, String priimek, int uspeh3, int uspeh4, int[] ocenePredmetovNaMaturi){
		super(stPrijave, ime, priimek, uspeh3, uspeh4, ocenePredmetovNaMaturi);
		this.vrstaMature = "splosna";
	}
	
	public double tockeZaSplosnoMaturo(){
		return(TOCKE_SPL_MATURA[this.uspehMatura() - 10]);
	}
	
	public double skupajTock(){
		return(this.tockeZaUspeh34()*DELEZI[0]/100 + this.tockeZaSplosnoMaturo()*DELEZI[1]/100);
	}
	
	public String toString(){
		return(String.format("(%d) <%s> %s %s | %s | [%s] | %.2f", this.getId(), this.vrstaMature, this.getIme(), this.getPriimek(), this.getUspeh(), this.getOcenePredmetovNaMaturi(), this.skupajTock()));
	}
	
	
}
