public class Posta{
	private String imePoste;
	private int postnaSt;
	
	public String getImePoste(){
		return(this.imePoste);
	}
	
	public int getPostnaSt(){
		return(this.postnaSt);
	}
	public void setImePoste(String imePoste){
		this.imePoste = imePoste;
	}
	
	public void setPostnaSt(int postnaSt){
		this.postnaSt = postnaSt;
	}
	
	public String toString(){
		return(String.format("%d %s", this.postnaSt, this.imePoste));
	}
}
