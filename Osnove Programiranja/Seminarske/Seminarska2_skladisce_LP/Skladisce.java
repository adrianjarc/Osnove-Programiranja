public class Skladisce{
	
	int dolzina, sirina, visina;
	int[][][] jama;
	
	Skladisce(int dolzina, int sirina, int visina){
		this.dolzina = dolzina;
		this.sirina = sirina;
		this.visina = visina;
		int[][][] jama = new int[dolzina][sirina][visina];
		this.jama = jama;
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
		
		for(int x = 0; x < dolzina; x++){
			for(int y = 0; y < sirina; y++){
				for(int z = 0; z < visina; z++){
					if(jama[x][y][z] > 0){
						stanje += jama[x][y][z];
					}else{
						stanje += "-";
					}
				}
				stanje += " ";
			}
			stanje += "\n";
		}
		return(stanje);
	}
}
