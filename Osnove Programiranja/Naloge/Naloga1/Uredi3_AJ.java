/**
 *
 * @author aj2762
 */

import java.util.*;

public class Uredi3 {

    static int a;
    static int b;
    static int c;
    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        
        System.out.print("Vnesi prvo število: ");
        a = sc.nextInt();
        System.out.print("\n Vnesite drugo število: ");
        b = sc.nextInt();
        System.out.print("\n Vnesite tretje število: ");
        c = sc.nextInt();
        
        Izpisi();    
    }
    
    public static void Izpisi(){
        if (a<b && a<c){
           if (b<c){
               System.out.println(a+ " " + b + " " + c);
           } else if (b>c){
               System.out.println(a + " " + c + " " + b);
           }
        }else if (a<b && a>c){
            System.out.println(c + " " + a + " " + b);
        }else if (a>b && a>c){
            if (b<c){
                System.out.println(b + " " + c + " " + a);
            }else if (b>c){
                System.out.println(c + " " + b + " " + a);
            }
        }else if (a>b && a<c){
                System.out.println(b + " " + a + " " + c);
        }
        
    }
}
