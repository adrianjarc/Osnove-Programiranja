import java.util.Scanner;

public class Test{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		
		System.out.print("Vnesite dimenzije jame: ");
		int vnos = stdin.nextInt();
		int[] xyz = razbijInt(vnos);
		Skladisce jama = new Skladisce(xyz[0], xyz[1], xyz[2]);
		
		while(true){
			System.out.println("\n"+jama.izpisStanja());
			System.out.print("Vnesite barvo in visino soda: ");
			vnos = stdin.nextInt();
			if(vnos == -1)
				break;
			int[] bv = razbijInt(vnos);
			int[] coords = jama.postaviSod(bv[0], bv[1]);
			
			if(coords[0] == -1){
				System.out.println("\nSoda ni mogoce postaviti nikamor.");
				break;
			}
			System.out.printf("\nSod postavimo na polozaj (%d, %d).\n", coords[0], coords[1]);
		}
	}
	
	//razbij stevilo na tabelo stevk npr: 123 => {1, 2, 3} in vrni tabelo
	public static int[] razbijInt(int stevilo){
		int dolzina = String.valueOf(stevilo).length();
		int[] temp = new int[dolzina];
		
		for(int i = dolzina-1; i >= 0; i--){
			int stevka = stevilo % 10;
			temp[i] = stevka;
			stevilo /= 10;
		}
		
		return(temp);
	}
}
