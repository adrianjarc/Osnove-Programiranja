public class Ulomek{
	private int stevec;
	private int imenovalec;
	
	Ulomek(int stevec, int imenovalec){
		int delitelj = GCD(stevec, imenovalec);
		this.stevec = stevec / delitelj;
		this.imenovalec = imenovalec / delitelj;
		
		if(this.imenovalec < 0){
			this.stevec *= -1;
			this.imenovalec *= -1;
		}
	}
	
	private int GCD(int a, int b){
		if (b==0) return a;
		return GCD(b,a%b);
	}
	
	public int getStevec(){
		return(this.stevec);
	}
	
	public int getImenovalec(){
		return(this.imenovalec);
	}
	
	public String toString(){
		return(String.format("%d/%d", this.stevec, this.imenovalec));
	}
	
	public Ulomek negacija(){
		Ulomek negiran = new Ulomek(-this.stevec, this.imenovalec);
		return(negiran);
	}
	
	public Ulomek obrat(){
		Ulomek obrnjen = new Ulomek(this.imenovalec, this.stevec);
		return(obrnjen);
	}
	
	public Ulomek vsota(Ulomek u){
		Ulomek sestevek = new Ulomek(this.stevec * u.imenovalec + this.imenovalec * u.stevec, this.imenovalec * u.imenovalec);
		return(sestevek);
	}
	
	public Ulomek razlika(Ulomek u){
		Ulomek razlika = new Ulomek(this.stevec * u.imenovalec - this.imenovalec * u.stevec, this.imenovalec * u.imenovalec);
		return(razlika);
	}
	
	public Ulomek zmnozek(Ulomek u){
		Ulomek zmnozek = new Ulomek(this.stevec * u.stevec, this.imenovalec * u.imenovalec);
		return(zmnozek);
	}
	
	public Ulomek kolicnik(Ulomek u){
		Ulomek sestevek = new Ulomek(this.stevec * u.imenovalec, this.imenovalec * u.stevec);
		return(sestevek);
	}
	
	public Ulomek potenca(int eksponent){
		if(eksponent < 0){
			eksponent *= -1;
			return(new Ulomek((int)Math.pow(this.imenovalec, eksponent), (int)Math.pow(this.stevec, eksponent)));
		}else{
			return(new Ulomek((int)Math.pow(this.stevec, eksponent), (int)Math.pow(this.imenovalec, eksponent)));
		}
	}
	
	public boolean jeManjsiOd(Ulomek u){
		if(this.stevec * u.imenovalec < this.imenovalec * u.stevec){
			return(true);
		}else{
			return(false);
		}
	}
}
