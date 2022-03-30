/**
 *
 * @author aj2762
 */
import java.util.Scanner;

public class Vaja1 {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Vnesi število: ");
        int st= sc.nextInt();
        while (st>0){
            int stevka = st%10;
            System.out.print(stevka + " ");
            st=st/10;
        }
    }
}
//Rastava na desetice, stotice, ...