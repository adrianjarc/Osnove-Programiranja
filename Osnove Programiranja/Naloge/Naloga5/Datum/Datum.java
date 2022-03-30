public class Datum{
	public int dan, mesec, leto;
	
	private Datum(int dan, int mesec, int leto){
		this.dan = dan;
		this.mesec = mesec;
		this.leto = leto;
	}
	
	public static Datum ustvari(int dan, int mesec, int leto){
		switch(mesec){
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				if(dan >= 1 && dan <= 31){
					break;
				}
			case 4: case 6: case 9: case 11:
				if(dan >= 1 && dan <= 30){
					break;
				}
			case 2:
				if(prestopno()){
					if(dan >= 1 && dan <= 29){
						break;
					}else if(dan >= 1 && dan <= 28){
						break;
					}
				}
			default:
				return(null);
		}
		return(new Datum(dan, mesec, leto));
	}
	
	private boolean prestopno(leto){
		return((leto % 4 == 0 && leto % 100 != 0) || leto % 400 == 0);
	}
	
	public String toString(){
		return(String.format("%d.%d.%d", dan, mesec, leto));
	}
	
	public boolean jeEnakKot(Datum datum){
		return(this.dan == datum.dan && this.mesec == datum.mesec && this.leto == datum.leto);
	}
	
	public boolean jePred(Datum datum){
		return(this.leto < datum.leto || (this.leto == datum.leto && this.mesec < datum.mesec) || (this.leto == datum.leto && this.mesec = datum.mesec && this.dan < datum.dan));
	}
	
	public Datum naslednik(){
		Datum naslednji = new Datum(this.dan+1,this.mesec,this.leto);
		if(naslednji == null){
			naslednji = new Datum(1,this.mesec + 1,this.leto);
			if(naslednji == null){
				naslednji = new Datum(1,1,this.leto+1);
			}
		}
		return(naslednji);
	}
	
	public Datum predhodnik(){
		Datum naslednji = new Datum(this.dan-1,this.mesec,this.leto);
		if(naslednji == null){naslednji = new Datum(31,this.mesec - 1,this.leto);
			if(naslednji == null){naslednji = new Datum(30,this.mesec - 1,this.leto);
					if(naslednji == null){naslednji = new Datum(29,this.mesec - 1,this.leto);
						if(naslednji == null){naslednji = new Datum(28,this.mesec - 1,this.leto);
							if(naslednji == null){naslednji = new Datum(31,12,this.leto - 1);
						}
					}
				}
			}
		}
		return(naslednji);
	}
}
