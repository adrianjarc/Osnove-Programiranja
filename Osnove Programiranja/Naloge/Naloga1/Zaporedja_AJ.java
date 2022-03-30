/**
 *
 * @author aj2762
 */

import java.util.Scanner;

public class Zaporedja {
    
    static int a;
    static int b;
    static int k;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("Vnesite prvo mejo: ");
        a=sc.nextInt();
        System.out.print("\nVnesite drugo mejo: ");
        b=sc.nextInt();
        System.out.print("\nVnesite korak: ");
        k=sc.nextInt();
        
        Zaporedje();
    }
    
    public static void Zaporedje(){
        if (k==0){
            System.out.print("Korak ne sme biti enak 0.");
        }
        if (a<b && k>0){
            for (int i=a;a<=b;a=a+k){
                System.out.print(a + " ");
            }
        }else if(a<b && k<0){
            System.out.print("Predznak koraka ni usklajen z mejama.");
        }
        if (a>b && k<0){
            for (int i=b;a>=b;a=a+k){
                System.out.print(a + " ");
            }
        }else if (a>b && k>0){
            System.out.print("Predznak koraka ni usklajen z mejama.");
        }
    }
}
