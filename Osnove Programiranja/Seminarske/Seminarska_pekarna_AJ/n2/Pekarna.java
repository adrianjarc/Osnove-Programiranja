/**
 *
 * @author Adrian Jarc
 * @version 1.0
 */
 
import java.util.Scanner;

public class Pekarna {

    private static final int ZALOGA = 10;
    private static final int K_ZALOGA = 8;
    private static final int NAROCILO = 10;
    static int k = 60;
	static Scanner sc = new Scanner(System.in);
    static int mp;
    static int up;
	static int st;
	static int mt;

    public static void main(String[] args) {
        System.out.print("Vnesite uro odprtja: ");
        int uo = sc.nextInt();
        System.out.print("Vnesite uro zaprtja: ");
        int uz = sc.nextInt();
		while (uo>=uz){
			System.out.println("Ura zaprtja mora biti vsaj eno uro po uri odprtja.");
			System.out.print("Vnesite uro odprtja: ");
			uo = sc.nextInt();
			System.out.print("Vnesite uro zaprtja: ");
			uz = sc.nextInt();
		}		
        Pekarna(uo, uz);
    }

    public static void Pekarna(int uo, int uz) {
        int z = ZALOGA;
        int u = uo;
        int mz;
        int m = 0;
        int povp;
		System.out.print("Vnesite interval: ");
		int f = sc.nextInt();
        while (u < uz) {
                mz = (int) (2 + (Math.random() * 9));
                povp = (int) (1 + (Math.random() * 8));
                m = m + mz;
                if (z > povp) {
                    z = z - povp;
                    if (m > k) {
                        m = m - k;
                        u++;
                    }
					if (u < 10 && m < 10) {
                        System.out.print("[0" + u + ":0" + m + "],");
                    } else if (u < 10 && m > 10) {
                        System.out.print("[0" + u + ":" + m + "],");
                    } else if (u > 10 && m < 10) {
                        System.out.print("[" + u + ":0" + m + "],");
                    } else if (u > 10 && m > 10) {
                        System.out.print("[" + u + ":" + m + "],");
                    }
                    System.out.println("kupljeno hlebcev: " + povp + ", zaloga (" + z + ").");
					st++;
					mt = mt + mz;
                    if (z <= K_ZALOGA && mp <= 0) {
                        up = u + 1;
                        System.out.println("  [narocen]");
                    }
					if (povp >= f){
						System.out.println("?tevilo strank v zadnjem intervalu: " + st);
						st = 0;
						System.out.println("Dol?ina zadnjega intervala: " + mt + " minut");
						mt = 0;
					}
                } else if (z < povp) {
                    if (m > k) {
                        m = m - k;
                        u++;
                    }
                    if (z > 0 && povp >= z) {
                        System.out.println("  poprasevanje: " + povp + ",premalo kruha, izguba: " + (povp - z));
                        z = z - povp;
                    } else {
                        System.out.println("  poprasevanje: " + povp + ",premalo kruha, izguba: " + povp);
                        if (u == up && m >= mp) {
                            System.out.println("  [prispel]");
                            z = z + NAROCILO;
                            mp = 0;
                    }
                }
            }
        }
		System.out.println("Ostalo je: " + z + " hlebcev kruha.");
    }

}

