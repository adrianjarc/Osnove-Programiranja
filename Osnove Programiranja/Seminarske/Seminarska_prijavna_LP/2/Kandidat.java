abstract class Kandidat {
	private int stPrijave; // številka prijave
	private String ime, priimek; // ime in priimek kandidata
	private int uspeh3; // uspeh v 3. letniku, vrednost med 2 in 5
	private int uspeh4; // uspeh v 4. letniku, vrednost med 2 in 5
	// vsak element vsebuje oceno enega predmeta;
	// število točk na maturi je seštevek vseh ocen
	private int[] ocenePredmetovNaMaturi;
	// vsebuje število točk, ki jih kandidat lahko dobi za uspeh
	// v 3. in 4. letniku; vsak element ustreza eni izmed možnih
	// kombinacij uspeha; podrobnejša razlaga sledi v nadaljevanju
	private static final int[] TOCKE_USPEH_3IN4 = {40, 50, 60, 70, 80, 90, 100};
	// vrne skupno število točk, ki se upošteva pri razvrščanju
	public abstract double skupajTock();
	// izpis kandidata
	public abstract String toString();
	public abstract String getVrsta();
	
	public Kandidat(int stPrijave, String ime, String priimek, int uspeh3, int uspeh4, int[] ocenePredmetovNaMaturi){
		this.stPrijave = stPrijave;
		this.ime = ime;
		this.priimek = priimek;
		this.uspeh3 = uspeh3;
		this.uspeh4 = uspeh4;
		this.ocenePredmetovNaMaturi = ocenePredmetovNaMaturi;
	}
	
	public int getId(){
		return(this.stPrijave);
	}
	
	public String getIme(){
		return(this.ime);
	}
	
	public String getPriimek(){
		return(this.priimek);
	}
	
	public String getUspeh(){
		return(String.format("%d, %d", this.uspeh3, this.uspeh4));
	}
	
	public String getOcenePredmetovNaMaturi(){
		String tmp;
		tmp = ""+this.ocenePredmetovNaMaturi[0];
		for(int i = 1; i < this.ocenePredmetovNaMaturi.length; i++){
			tmp += ", "+this.ocenePredmetovNaMaturi[i];
		}
		return(tmp);
	}
	
	public int tockeZaUspeh34(){
		return(TOCKE_USPEH_3IN4[uspeh3 + uspeh4 - 4]);
	}
	
	public int uspehMatura(){
		int sum = 0;
		for(int i = 0; i < ocenePredmetovNaMaturi.length; i++){
			sum += ocenePredmetovNaMaturi[i];
		}
		return(sum);
	}
	
	public boolean jeBoljsiOd(Kandidat k){
		return(this.skupajTock() > k.skupajTock());
	}
	
	public static void izpisi(Kandidat[] tk){
		for(int i = 0; i < tk.length; i++){
			System.out.println(tk[i].toString());
		}
	}
	
	//BUBBLE SORT FTW
	public static Kandidat[] razvrsti(Kandidat[] tk){
		int n = tk.length;
		boolean swapped = false;
		do{
			swapped = false;
			for(int i = 1; i < n; i++){
				if(tk[i-1].skupajTock() < tk[i].skupajTock()){
					tk = swap(tk, i-1, i);
					swapped = true;
				}
			}
			n = n -1;
		}while(swapped == true);
		return tk;
	}
	
	// v tabeli zamenja elementa z index1 in index2
	public static Kandidat[] swap(Kandidat[] tk, int index1, int index2){
		Kandidat temp = tk[index1];
		Kandidat obj1 = tk[index2];
		Kandidat obj2 = temp;
		
		tk[index1] = obj1;
		tk[index2] = obj2;
		
		return(tk);
	}
}
