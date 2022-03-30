public class Oseba{
	private static final int LETOS = 2012;
	
	public String ime, priimek;
	public boolean jeMoski;
	public int leto;
	private Oseba oce, mati;
	public static int stUstvarjenih = 0;
	
	public Oseba(String im, String pr, boolean m, int lr){
		this(im, pr, m, lr, null, null);
	}
	
	public Oseba(String im, String pr, boolean m, int lr, Oseba oce, Oseba mati){
		this.ime = im;
		this.priimek = pr;
		this.jeMoski = m;
		this.leto = lr;
		this.oce = oce;
		this.mati = mati;
		this.stUstvarjenih++;
	}
	
	public void dodajOsebo(String ime, String priimek, boolean spol, int leto){
		this.ime = ime;
		this.priimek = priimek;
		this.jeMoski = spol;
		this.leto = leto;
	}
	
	public void setIme(String ime){
		this.ime = ime;
	}
	
	public void setPriimek(String priimek){
		this.priimek = priimek;
	}
	
	public void setSpol(boolean Spol){
		this.jeMoski = jeMoski;
	}
	
	public void setLetoRojstva(int leto){
		this.leto = leto;
	}
	
	public String getIme(){
		return(this.ime);
	}
	
	public String getPriimek(){
		return(this.priimek);
	}
	
	public boolean getSpol(){
		return(this.jeMoski);
	}
	
	public int getLetoRojstva(){
		return(this.leto);
	}
	
	public String toString(){
		String spolCrka = "M";
		if(this.jeMoski == false){spolCrka = "Z";}
		return(String.format("%s %s [%s] (%d)", this.ime, this.priimek, spolCrka, this.leto));
	}
	
	public int starost(int leto){
		return(leto-this.leto);
	}
	
	public int starost(){
		return(LETOS-this.leto);
	}
	
	public boolean jeStarejsaOd(Oseba os){
		return(this.leto > os.leto);
	}
	
	public int getStUstvarjenih(){
		return(this.stUstvarjenih);
	}
	
	public boolean jeBratAliSestraOd(Oseba os){
		if (this.oce != null && this.mati != null && this.oce == os.oce){
			return(true);
		} else {
			return(false);
		}
	}
	
	public boolean jeSestraOd(Oseba os){
		return(!this.jeMoski && this.jeBratAliSestraOd(os));
	}
	
	public boolean jeBratOd(Oseba os){
		return(this.jeMoski && this.jeBratAliSestraOd(os));
	}
	
	public String imeOceta(){
		return();
	}
	
	/*
	public boolean jeStariOceOd(Oseba os){
		return();
	}
	*/
}
