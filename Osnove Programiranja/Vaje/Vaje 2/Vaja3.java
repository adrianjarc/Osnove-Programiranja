/**
 *
 * @author aj2762
 */
import java.util.Scanner;

public class Vaja3 {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Vnesi število vrstic: ");
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<(n-i-1);j++)
                System.out.print(" ");
            for(int j=0;j<(i*2+1);j++)
                System.out.print("*");
            System.out.println();
        }
    }
    
}
//Piramida zvezdic