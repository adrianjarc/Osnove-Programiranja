public class PrijavnaSluzba{
	public static void main(String args[]){
		Kandidat[] tk = new Kandidat[10];
		tk[0] = new KandidatSplosnaMatura(1, "Luka", "Pusic", 5, 5, new int[]{4,6,7,4,5});
		tk[1] = new KandidatSplosnaMatura(2, "Luka", "Pevec", 3, 3, new int[]{4,4,4,4,4});
		tk[2] = new KandidatSplosnaMatura(3, "Desanka", "Sakic", 3, 2, new int[]{4,2,3,3,4});
		tk[3] = new KandidatSplosnaMatura(4, "Levanka", "Rukic", 2, 4, new int[]{4,5,2,5,5});
		tk[4] = new KandidatSplosnaMatura(5, "Li", "Mun", 2, 5, new int[]{4,6,7,8,3});
		tk[5] = new KandidatPoklicnaMatura(6, "Matako", "Kojamo", 5, 4, new int[]{4,5,3,5}, 3);
		tk[6] = new KandidatPoklicnaMatura(7, "Ekrem", "Jevric", 2, 2, new int[]{2,2,2,2}, 4);
		tk[7] = new KandidatPoklicnaMatura(8, "Piflarko", "Streber", 5, 5, new int[]{5,5,5,5}, 5);
		tk[8] = new KandidatPoklicnaMatura(9, "Jedva", "Proso", 2, 2, new int[]{2,2,2,2}, 2);
		tk[9] = new KandidatPoklicnaMatura(10, "Ano", "Nimen", 5, 5, new int[]{5,3,4,4}, 4);
		
		preuredi(tk);
	}
	
	private static void preuredi(Kandidat[] tk){
		int splosnih = stElPoVrsti(tk, "splosna");
		int poklicnih = stElPoVrsti(tk, "poklicna");
		Kandidat[] tsplosna = new Kandidat[splosnih];
		Kandidat[] tpoklicna = new Kandidat[poklicnih];
		int ts = 0;
		int tp = 0;
		
		for(int i = 0; i < tk.length; i++){
			if(tk[i].getVrsta() == "splosna"){
				tsplosna[ts] = tk[i];
				ts++;
			}else{
				tpoklicna[tp] = tk[i];
				tp++;
			}
		}
		
		Kandidat.izpisi(sortPoOcenah(tsplosna));
		Kandidat.izpisi(sortPoOcenah(tpoklicna));
	}
	
	public static int stElPoVrsti(Kandidat[] tk, String vrsta){
		int temp = 0;
		for(int i = 0; i < tk.length; i++){
			if(tk[i].getVrsta() == vrsta){
				temp++;
			}
		}
		return(temp);
	}
	
	public static Kandidat[] sortPoOcenah(Kandidat[] tk){
		int n = tk.length;
		boolean swapped = false;
		do{
			swapped = false;
			for(int i = 1; i < n; i++){
				if(tk[i-1].tockeZaUspeh34() < tk[i].tockeZaUspeh34()){
					tk = Kandidat.swap(tk, i-1, i);
					swapped = true;
				}
			}
			n = n -1;
		}while(swapped == true);
		return(tk);
	}
}
