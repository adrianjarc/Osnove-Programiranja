/*
Luka Pušić <luka@pusic.si>
FRI, 2012
Razbijanje števil
*/

import java.util.Scanner;

//mal neučinkovita rešitev, ampak JE-BI-GA, deluje
public class Razbijanje{
	public static void main(String[] args){
		Scanner stdin = new Scanner(System.in);
		System.out.print("Vnesite naravno število n: ");
		int n = stdin.nextInt();
		System.out.print("Vnesite naravno število m: ");
		int m = stdin.nextInt();
		int index = 0, stStevk;

		if(vsotaStevk(m) != dolzinaStevila(n)){
			System.out.println("Vsota števk števila m mora biti enaka številu števk števila n.");
			System.exit(1);
		}

		for(int i = 0; i < dolzinaStevila(m); i++){
			stStevk = delStevila(m,i,i+1);
			if(stStevk != 0){
				System.out.println(delStevila(n,index,index+stStevk));
			}else{
				System.out.println();
			}
			index += stStevk;
		}
	}

	private static int dolzinaStevila(int stevilo){
		int dolzina = 1;
		while(stevilo > 9){
			stevilo = stevilo / 10;
			dolzina++;
		}
		return(dolzina);
	}

	private static int delStevila(int stevilo, int odSt, int doSt){

		//odstrani desno stran
		if(doSt > 0){
			int n = dolzinaStevila(stevilo)-doSt;
			stevilo = stevilo / (int)Math.pow(10,n);
		}
		//odstrani levo stran
		if(odSt > 0){
			int n = dolzinaStevila(stevilo)-odSt;
			stevilo = stevilo % (int)Math.pow(10,n);
		}
		return(stevilo);
	}

	private static int vsotaStevk(int stevilo){
		int vsota = 0;
		for(int i = 0; i < dolzinaStevila(stevilo); i++){
			vsota += delStevila(stevilo, i, i+1);
		}
		return(vsota);
	}
}
