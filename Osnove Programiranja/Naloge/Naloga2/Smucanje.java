import java.util.Scanner;

public class Smucanje{
    
    static int n;
    static int c1;
    static int c2;
    static int s=2147483647;
    static int t;
    static Scanner sc= new Scanner(System.in);
    
    public static void main(){
        System.out.print("Vnesite število tekmovalcev: ");
        n = sc.nextInt();
        Smucanje();
    }
    public static void Smucanje(){
        for(int i=0;i<n;i++){
            System.out.println("Tekmovalec " + (i+1));
            for(int j=0;j<1;j++){
                System.out.print("Vnesite čas v prvem teku: ");
                c1=sc.nextInt();
                if(c1<0){
                    break;
                }
                System.out.print("Vnesite čas v drugem teku: ");
                c2=sc.nextInt();
                if (c2<0){
                    break;
                }
                if((c1+c2)<s){
                    s = c1+c2;
                    t = i+1;
                }
            }               
        }
        if(t>0){
            System.out.print("Najboljši skupni čas (" + s + ") je dosegel tekmovalec " + t + ".");
        }else{
            System.out.print("Vsi tekmovalci so bili diskvalificirani");
        }
    }
}
