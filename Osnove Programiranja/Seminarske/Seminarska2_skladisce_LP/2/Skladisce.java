public class Skladisce{
	
	int dolzina, sirina, visina;
	int[][][] jama;
	boolean prvi;
	
	Skladisce(int dolzina, int sirina, int visina){
		this.dolzina = dolzina;
		this.sirina = sirina;
		this.visina = visina;
		int[][][] jama = new int[dolzina][sirina][visina];
		this.jama = jama;
		this.prvi = true;
	}
	
	public int[] postaviSod(int barva, int visinaSoda){
		/*
		 * Za vsak stolpec v jami sestej visino; najmanjso visino
		 * ter koordinate stolpca sproti shranjuj v minVisina, minX,
		 * minY in sproti preverjaj pravila za izbiro stoplca.
		 */
		int trVisina = 0;
		int minVisina = visina;
		int minX = 0;
		int minY = 0;
		
		for(int x = 0; x < dolzina; x++){
			for(int y = 0; y < sirina; y++){
				for(int z = 0; z < visina; z++){
					if(jama[x][y][z] == 0)
						break; //optimizacija, ker v stolpcu vmes ni praznih elementov
					trVisina++;
				}
				if(trVisina < minVisina || (trVisina == minVisina && x + y < minX + minY)){
					minVisina = trVisina;
					minX = x;
					minY = y;
				}
				trVisina = 0; //resetiraj visino trenutnega stolpca
			}
		}
		
		/* 
		 * Preveri ce je dovolj prostora za nove sode.
		 * Ce je prostor jih dodaj in vrni koordinate stolpca.
		 * Ce ne gre vec, vrni {-1, *}.
		 */
		int[] coords = {-1, -1};
		if(minVisina + visinaSoda <= visina){
			for(int z = 0; z < visinaSoda; z++){
				jama[minX][minY][minVisina + z] = barva;
			}
			coords[0] = minX;
			coords[1] = minY;
		}else{
			coords[0] = -1;
			coords[1] = -1; //nepotrebna dodelitev, zrd lepsga
		}
		return(coords);
	}
	
	/*
	 * Izpis trodimenzionalne tabele oz. reprezentacija jame.
	 */
	public String izpisStanja(){
		String stanje = "";
		int[] barve = new int[9];
		String maxbarve = "Najbolj zastopane barve: ";
		
		for(int x = 0; x < dolzina; x++){
			for(int y = 0; y < sirina; y++){
				for(int z = 0; z < visina; z++){
					if(jama[x][y][z] > 0){
						stanje += jama[x][y][z];
						barve[jama[x][y][z]] += 1;
					}else{
						stanje += "-";
					}
				}
				stanje += " ";
			}
			stanje += "\n";
		}
		maxbarve += max(barve);

		if(this.prvi == true){
			this.prvi = false;
			return(stanje);
		}
			return(stanje+"\n"+maxbarve+"\n");
	}
	public String max(int[] t) {
		int maximum = t[0];   // start with the first value
		String maxstring = "";
		int maxi = 0;
		for (int i=1; i<t.length; i++) {
			if (t[i] > maximum) {
				maximum = i;   // new maximum
				maxi = i;
			}
		}
		maxstring = ""+maximum;
		for (int i=1; i<t.length; i++) {
			if(i == maxi){
				continue;
			}
			if (t[i] == maximum) {
				maxstring += " "+i;
			}
		}
		return maxstring;
	}
}
