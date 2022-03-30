class Polje {
    
    private String CENA = " ";
    private int ST_POLJA;
    private String LASTNISTVO = " ";
    private String NAPOLJU = " ";
    private int NAJEMNINA;
    
    public void nastavistPolja (int st){
        this.ST_POLJA = st;
    }
    public void nastaviCeno(int c){
        this.CENA = Integer.toString(c);
        this.NAJEMNINA = c/4;
    }
    public void nastaviLastnistvo(int l){
        this.LASTNISTVO = Integer.toString(l);
    }
    public void nastaviprLastinstvo(String l){
        this.LASTNISTVO = l;
    }
    public void naPolju(String x){
        this.NAPOLJU = x;
    }
    public String vrniStrCeno(){
        return CENA;
    }
    public int vrniintCeno(){
        return Integer.parseInt(this.CENA);
    }
    public String vrniLastnistvo(){
        return this.LASTNISTVO;
    }
    public String vrninaPolju(){
        return NAPOLJU;
    }
    public int vrnistPolja(){
        return ST_POLJA;
    }
    public int vrniNajemnino(){
        return NAJEMNINA;
    }
    
}
