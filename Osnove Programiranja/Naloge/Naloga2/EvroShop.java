import java.util.Scanner;

public class EvroShop{
    
    static int z;
    static int x=0;
    static int y=0;
    static int f;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(){
        System.out.printf("Stanje v blagajni: %d | %d\n",x,y);
        EvroShop();
    }
    static void EvroShop(){
        while (true){
            System.out.print("Vnesite plačilo (1 ali 2): ");
            z=sc.nextInt();
            if(z==1 || z==2){
                if(z==1){
                    x+=z;
                }else if (z==2){
                    y+=z;
                    f++;
                    x--;
                    if(x<0){
                        System.out.print("Vračilo ni mogoče");
                        break;
                    }
                }
                System.out.printf("\n Stanje v blagajni: %d | %d\n",x,f);
            }else if(z<1 || z>2){
                break;
            }
        }
    }
}
