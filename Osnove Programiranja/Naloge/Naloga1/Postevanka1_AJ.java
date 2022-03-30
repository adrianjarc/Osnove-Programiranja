/**
 *
 * @author aj2762
 */
import java.util.Scanner;

public class Postevanka1 {

    static int a;
    static int b;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Vnesite celo število: ");
        a=sc.nextInt();
        System.out.print("\nVnesite pozitivno celo število: ");
        b=sc.nextInt();
        
        Postevanka();
        
    }
    
    public static void Postevanka(){
        
        if (b<=0){
            System.out.print("\nŠtevilo ni pozitivno!");                    
        }else if (b>0){
            for (int i=1;i<=b;i++){
                System.out.println(a + "*" + i + "=" + (a*i));
            }
        }
        
    }    
    
}
