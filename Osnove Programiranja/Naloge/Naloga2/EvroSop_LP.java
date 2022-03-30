/*
Luka Pušić <luka@pusic.si>
FRI, 2012
*/

import java.util.Scanner;

public class EvroSop_LP{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		int en = 0, dva = 0, x = 0;
		while(true){
			System.out.println("Stanje v blagajni je: "+en+" | "+dva);
			System.out.print("\nVnesite plačilo (1 | 2): ");
			x = stdin.nextInt(); //preberi uporabnikov vnos - stevilo
			if(x == 1){
				en++; //ce je vnos 1, povecaj st kovancev za 1
			}else if(x == 2){
				if(en > 0){
					dva++; //ce je vnos 2, povečaj št. kovancev za 2
					en--; //in zmajšaš enke, ker si mu dal drobiž
				}else{
					System.exit(0); //zmanjka drobiža po 1 €
				}
			}else{
				System.exit(0); //napačen vnos
			}

		}
	}
}
