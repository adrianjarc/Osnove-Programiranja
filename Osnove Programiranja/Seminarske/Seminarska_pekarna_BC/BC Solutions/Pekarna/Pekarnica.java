/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Time;

/**
 *
 * @author BLAZ
 */
public class Pekarnica {
    private static final int MINIMAL_CUSTOMER_INTERVAL_MS = 2 * 60000;
    private static final int MAXIMAL_CUSTOMER_INTERVAL_MS = 11 * 60000;
    private static final boolean EXACT_MODE_ON = true;
    private Time zapremo;
    private Time TrenutniCas;
    private long Trenutne_Zaloge_Hlebcev;
    private int Dokupujemo_Po;
    private Time NextDelivery;
    private long Procure_Bread;
    
    
    Pekarnica(Time odpremo, Time zapremo, long trenutne_zaloge, int zaloga_dokupimo)
    {
        this.TrenutniCas = odpremo;
        this.zapremo = zapremo;
        this.Trenutne_Zaloge_Hlebcev = trenutne_zaloge;
        this.Procure_Bread = trenutne_zaloge;
        this.Dokupujemo_Po = zaloga_dokupimo;
        this.NextDelivery = null;
    }
    
    public boolean NextCustomer()
    {
        long step_ms;
        byte bread_wanted;
        if(Pekarnica.EXACT_MODE_ON)
        {
            step_ms = Math.round((Math.random() * ( Pekarnica.MINIMAL_CUSTOMER_INTERVAL_MS + Pekarnica.MAXIMAL_CUSTOMER_INTERVAL_MS) + Pekarnica.MINIMAL_CUSTOMER_INTERVAL_MS) / 60000); // Time elapsed
            bread_wanted = (byte)Math.ceil(Math.random()*4); //To buy
        }
        else
        {
            step_ms = (long)Math.ceil((Math.random() * ( Pekarnica.MINIMAL_CUSTOMER_INTERVAL_MS + Pekarnica.MAXIMAL_CUSTOMER_INTERVAL_MS) + Pekarnica.MINIMAL_CUSTOMER_INTERVAL_MS) / 60000);
            bread_wanted = (byte)Math.ceil(Math.random()*4); //To buy
        }
        
        int bread_got = (byte)this.TryBuying(bread_wanted, step_ms * 60000);
        if(bread_got < 0)
        {
            return false;
        }
        return true;
        
    }
    
    private long TryBuying(byte bread_ammount, long step_ms)
    {
        if((this.TrenutniCas.getTime() + step_ms) <= this.zapremo.getTime())
        {
            this.TrenutniCas.setTime(this.TrenutniCas.getTime() + step_ms);
        }
        else
        {
            System.out.println("Ostalo je: "+this.Trenutne_Zaloge_Hlebcev + " hlebcev kruha.");
            return -1;
        }
        if(this.NextDelivery != null)
        {
            if(this.TrenutniCas.getTime() >= this.NextDelivery.getTime())
            {
                System.out.println("    [prispel]");
                this.NextDelivery = null;
                this.Trenutne_Zaloge_Hlebcev += this.Procure_Bread;
            }
        }
        
        long procured;
        if(this.Trenutne_Zaloge_Hlebcev - bread_ammount >= 0)
        {
            procured = bread_ammount;
            this.Trenutne_Zaloge_Hlebcev -= bread_ammount;
            String minutes = (this.TrenutniCas.getMinutes() < 10) ? ("0" + Integer.toString(this.TrenutniCas.getMinutes())) : Integer.toString(this.TrenutniCas.getMinutes());
            System.out.println("["+this.TrenutniCas.getHours()+":"+minutes + "], kupljeno hlebcev "+bread_ammount+", zaloga ("+this.Trenutne_Zaloge_Hlebcev+").");
        }
        else
        {
            procured = this.Trenutne_Zaloge_Hlebcev;
            this.Trenutne_Zaloge_Hlebcev = 0;
            System.out.println("    povprasevanje: " + bread_ammount + ", premalo kruha, izguba: " + (bread_ammount - procured));
        }
        if((this.Trenutne_Zaloge_Hlebcev < this.Dokupujemo_Po) && this.NextDelivery == null)
        {
            System.out.println("    [narocen]");
            this.NextDelivery = new Time(this.TrenutniCas.getTime()+3600000);
        }
        
        return procured;
    }
    
}
