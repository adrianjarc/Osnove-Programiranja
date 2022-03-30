/**
 *
 * @author aj2762
 */
import java.util.Scanner;

public class Postevanka2 {

    static int a;
    static int b;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Vnesite pozitivno celo število: ");
        a=sc.nextInt();
        System.out.print("\nVnesite zgornjo mejo: ");
        b=sc.nextInt();
        
        Postevanka();
        
    }
    
    public static void Postevanka(){
        
        if(b<a){
            System.out.print("Zgornja meja je premajhna!");
        }else if (b>a){
            for (int i=1;(a*i)<=b;i++){
                System.out.println(a + "*" + i + "=" + (a*i));
            }
        }
        
    }
    
}
