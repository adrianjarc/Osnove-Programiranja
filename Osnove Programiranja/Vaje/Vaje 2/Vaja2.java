/**
 *
 * @author aj2762
 */
import java.util.Scanner;

public class Vaja2 {
    
    
    static int k=700;
    
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Število praznih cdjev: ");
        int n=sc.nextInt();
        int stevilkaCDja=1;
        int zasedenostCDja=0;
        
        while(stevilkaCDja <= n){
            System.out.print("Velikost datoteke (v MB): ");
            int velDat=sc.nextInt();
            
            if(velDat==0){
                System.out.print("Bye!");
                break;
            }
            
            if (zasedenostCDja+velDat <= k){
                zasedenostCDja+=velDat;
            } else {
                stevilkaCDja++;
                zasedenostCDja=velDat;
            }
            
            if (stevilkaCDja <=n){
                System.out.println("Datoteka se napiše na CD " + stevilkaCDja + ". CD vsebuje " + zasedenostCDja + "MB");
            } else{
                System.out.print("Zmanjkalo je CDjev.");
            }
        }
        
    }
}
//CDji