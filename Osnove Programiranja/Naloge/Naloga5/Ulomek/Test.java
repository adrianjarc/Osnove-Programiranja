public class Test{
	public static void main(String[] args){
		Ulomek p = new Ulomek(-2,3).potenca(-3).vsota(new Ulomek(6,4).zmnozek(new Ulomek(1,3).potenca(2))).vsota(new Ulomek(3,1));
		System.out.println(p.toString());
		
		System.out.println();
		
		Ulomek q = new Ulomek(1,2).vsota(new Ulomek(-1,4)).negacija().kolicnik(new Ulomek(1,2).vsota(new Ulomek(1,4)).potenca(-2));
		System.out.println(q.toString());
		
		if(p.jeManjsiOd(q) == true){
			System.out.println("p < q");
		}else{
			System.out.println("p > q");
		}
	}
}
