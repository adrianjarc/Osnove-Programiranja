public class Test{
	public static void main(String[] args){
		Pismo lj2mb = new Pismo("1000 Ljubljana", "2000 Maribor", true, 130);
		
		System.out.println(lj2mb.toString());
		Pismo mb2lj = lj2mb.izdelajPovratno();
		System.out.println(mb2lj.toString());
		System.out.println(mb2lj.izdelajPovratno().toString());
	}
}
