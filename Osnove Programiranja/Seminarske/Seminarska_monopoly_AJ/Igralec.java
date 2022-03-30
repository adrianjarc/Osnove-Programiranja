class Igralec {
    
    private int DENAR = 20;
    private int POLOZAJ;
    private int ST_IGRALCA;
    private int PREJSNI_POLOZAJ;
    private int STEVILO_POLJ;
	private int V_LASTI;
    Polje po[];
    
    public void nastaviSteviloPolj(int x){
        this.STEVILO_POLJ = x;
    }   
    public void narediTabelo(){
        po = new Polje[STEVILO_POLJ];
        for (int i=0;i<po.length;i++){
            this.po[i] = new Polje();
        }
    }
    public void nastavistIgralca(int i){
        this.ST_IGRALCA = i;
    }
    public void nastaviprPolozaj(int p){
        this.POLOZAJ = p;
        this.po[POLOZAJ].naPolju("x");
        
    }
	public void nastavivprLasti(int x){
		this.V_LASTI = x;
	}
	public void nastavivLasti(int x){
		this.V_LASTI += x;
	}
    public int izpisistIgralca(){
       return ST_IGRALCA; 
    }
    public void nastaviPolozaj(int x){
        this.PREJSNI_POLOZAJ = this.POLOZAJ;
        this.POLOZAJ += x;
        if (this.POLOZAJ>=this.po.length){
            this.POLOZAJ -= this.po.length;
        }
        this.po[PREJSNI_POLOZAJ].naPolju(" ");
        this.po[POLOZAJ].naPolju("x");
    }
    public void kupi(int x){
        this.DENAR -= x;
    }
    public void placaj(int x){
        this.DENAR -= x;
    }
    public void prejmiPlacilo(int x){
        this.DENAR += x;
    }
    public void izpisiPolja(){
        for(int j=0;j<po.length;j++){
            System.out.printf("%4s", po[j].vrninaPolju());
        }
    }
    public int izpisiDenar(){
        return DENAR;
    }
    public int vrniPolozaj(){
        return POLOZAJ;
    }
    public int vrniPrejsniPolozaj(){
        return PREJSNI_POLOZAJ;
    }
	public int vrnivLasti(){
		return V_LASTI
	}
}
