import java.util.Scanner;

public class Delitelji{
    static int x;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(){
        System.out.print("Vnesite naravno število: ");
        x=sc.nextInt();
        
        Delitelji();
    }

    public static void Delitelji()
    {
        for(int i=1;i<=x;i++){
            if (x%i==0){
                System.out.print(i + " ");
            }
        }
    }
}
