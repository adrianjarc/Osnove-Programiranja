public class Skladisce{
	
	int dolzina, sirina, visina;
	int[][][] jama;
	int maxX, maxY, maxZ, maxVisina, maxBarva, maxTo;
	boolean prva;
	
	Skladisce(int dolzina, int sirina, int visina){
		this.dolzina = dolzina;
		this.sirina = sirina;
		this.visina = visina;
		int[][][] jama = new int[dolzina][sirina][visina];
		this.jama = jama;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxZ = maxZ;
		this.maxVisina = maxVisina;
		this.maxBarva = maxBarva;
		this.maxTo = maxTo;
		this.prva = true;
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
		int tmpX, tmpY, tmpZ, tmpFrom, tmpTo = -1;
		int tmpVisina = visinaSoda;
		
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
			tmpX = minX;
			tmpY = minY;
			tmpZ = minVisina;
			
			for(int i = tmpZ; i>=0; i--){
				if(barva == jama[minX][minY][i]){
					tmpFrom = i;
					tmpVisina += 1;
				}
			}
			for(int i = tmpZ + visinaSoda; i<visina; i++){
				if(barva == jama[minX][minY][i]){
					tmpTo = i;
					tmpVisina += 1;
				}
			}
			if(tmpVisina > maxVisina -1){
				maxZ = tmpZ;
				maxTo = tmpTo;
				maxBarva = barva;
				maxVisina = tmpVisina-1;
				maxX = tmpX;
				maxY = tmpY;
			}
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
		if(prva == true){
			prva = false;
			return(stanje);
		}
		return(stanje + String.format("Najvišji blok: celica = (%d, %d), odmik od dna = %d, barva = %d, višina = %d",maxX,maxY,maxZ,maxBarva,maxVisina));
	}
}
