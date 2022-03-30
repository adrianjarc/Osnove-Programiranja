public class Pismo{
	private String izvorna_posta;
	private String ciljna_posta;
	private boolean vrsta_pisma; // true priporočeno, false navadno
	private int razdalja;
	public static final int K_RAZDALJA = 50;
	public static final int K_CENA = 2;
	public static final int K_PRIPOROCENO = 1;
	
	Pismo(){
		this("Ni podatka", "Ni podatka", false, 0);
	}
	
	Pismo(String izvorna_posta, String ciljna_posta, boolean vrsta_pisma, int razdalja){
		this.izvorna_posta = izvorna_posta;
		this.ciljna_posta = ciljna_posta;
		this.vrsta_pisma = vrsta_pisma;
		this.razdalja = razdalja;
	}
	
	public String getIzvor(){
		return(this.izvorna_posta);
	}
	
	public String getCilj(){
		return(this.ciljna_posta);
	}
	
	public String getVrstaPisma(){
		if(this.vrsta_pisma == true){
			return("priporoceno");
		}else{
			return("navadno");
		}
	}
	
	public int getRazdalja(){
		return(this.razdalja);
	}
	
	public boolean izviraOd(Pismo pismo){
		if(this.izvorna_posta == pismo.izvorna_posta){
			return(true);
		}else{
			return(false);
		}
	}
	
	public boolean staIzvorInCiljIsta(){
		if(this.izvorna_posta == this.ciljna_posta){
			return(true);
		}else{
			return(false);
		}
	}
	
	public boolean imaIstiCiljKot(Pismo pismo){
		if(this.ciljna_posta == pismo.ciljna_posta){
			return(true);
		}else{
			return(false);
		}
	}
	
	public static boolean imataIstiCilj(Pismo p1, Pismo p2){
		if(p1.ciljna_posta == p2.ciljna_posta){
			return(true);
		}else{
			return(false);
		}
	}
	
	public int cena(){
		int zacasna_cena = 0;
		if(this.vrsta_pisma == true){
			zacasna_cena += K_PRIPOROCENO;
		}
		if(this.razdalja < K_RAZDALJA){
			zacasna_cena += K_RAZDALJA;
		}else if(this.razdalja < 2*K_RAZDALJA){
			zacasna_cena += 2*K_RAZDALJA;
		}else if(this.razdalja < 3*K_RAZDALJA){
			zacasna_cena += 3*K_RAZDALJA;
		}
		return(zacasna_cena);
	}
	
	public boolean jeDrazjeOd(Pismo pismo){
		if(this.cena() > pismo.cena()){
			return(true);
		}else{
			return(false);
		}
	}
	
	public static Pismo vrniDrazje(Pismo p1, Pismo p2){
		if(p1.cena() > p2.cena()){
			return(p1);
		}else{
			return(p2);
		}
	}
	
	public Pismo izdelajPovratno(){
		Pismo povratno = new Pismo(this.ciljna_posta, this.izvorna_posta, this.vrsta_pisma, this.razdalja);
		return(povratno);
	}
	
	public String toString(){
		return(String.format("%s za %s -> %s (%d km)", this.getVrstaPisma(), this.izvorna_posta, this.ciljna_posta, this.razdalja));
	}
}
