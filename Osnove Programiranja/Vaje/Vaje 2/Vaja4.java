/**
 *
 * @author aj2762
 */
import java.util.Scanner;

public class Vaja4 {
    
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Ura zacetka vožnje: ");
        int uz=sc.nextInt();
        System.out.print("Minuta zacetka voznje: ");
        int mz=sc.nextInt();
        System.out.print("Ura konca voznje: ");
        int uk=sc.nextInt();
        System.out.print("Minuta konca voznje: ");
        int mk=sc.nextInt();
        System.out.print("Interval (v minutah)");
        int in=sc.nextInt();
        
        int tu=uz;
        int tm=mz;
        
        while ((tu<uk) || ((tu==uk) && (tm<=mk))){
            System.out.print(tu + ":");
            if (tm<10)
                System.out.print("0");
            System.out.print(tm + " ");
            
            tm+=in;
            if(tm>=60)
                tu++;
            //dokončaj doma
        }
        System.out.print("\n");
    }
}

/**
 *Vozni red:
 *Program naj bi izpisal vozni red avtobusa glede na interval ki mu ga določimo in v mejah začetne in končne ure.
 */