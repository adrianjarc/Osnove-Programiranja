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
		
		//Kandidat.izpisi(Kandidat.razvrsti(tk));
		obakratOdlicen(tk);
	}
	
	public static void obakratOdlicen(Kandidat[] tk){
		for(int i = 0; i < tk.length; i++){
			if(tk[i].obakratOdlicen()){
					System.out.println(tk[i].toString());
			}
		}
	}
}
