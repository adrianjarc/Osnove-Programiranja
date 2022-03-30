/**
 *
 * @author aj2762
 */

import java.util.Scanner;

public class Potenca {

    static int a;
    static int b;
    static int c = 1;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {

        System.out.print("Vnesite osnovo: ");
        a=sc.nextInt();
        System.out.print("Vnesite eksponent: ");
        b=sc.nextInt();
        
        Potenca();
        
    }
    
    public static void Potenca(){
        if(a>=1 && b>=0){
            for(int i=0;i<b;i++){
               c=c*a; 
            }
            System.out.print(a+ "^" + b + "=" + c);
        }else{
            System.out.print("Osnova ali exponent nista pravilna!");
        }
    }
    
}
