/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Time;

/**
 *
 * @author BLAZ
 */
public class Pekarna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Vnesite uro odprtja: ");
        int odpremo = BranjePodatkov.preberiInt()-1;
        System.out.print("Vnesite uro zaprtja: ");
        int zapremo = BranjePodatkov.preberiInt()-1;
        Pekarnica pek = new Pekarnica(new Time(odpremo * 3600000), new Time(zapremo * 3600000), 20, 8);
        // TODO code application logic here
        while(pek.NextCustomer() != false)
        {}
    }
}
