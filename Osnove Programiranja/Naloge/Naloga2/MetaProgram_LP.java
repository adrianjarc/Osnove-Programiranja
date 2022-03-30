/*
Luka Pušić <luka@pusic.si>
FRI, 2012
Metaprogram
*/

public class MetaProgram_LP{
	public static void main(String[] args){
		final int n = 4;
		String metaprogram = "";
		//prvi del
		metaprogram += "public class Nizi{\n";
		metaprogram += "\tpublic static void main(String[] args){\n";
		for (int i = 1; i <= n; i++){
			for(int indent = 0; indent <= i; indent++){
				metaprogram += "\t";
			}
			metaprogram += "for (char c"+i+" = 'A'; c"+i+" <= 'Z'; c"+i+"++;){\n";
		}
		//srednji del
		for(int indent = 1; indent < n+2; indent++){
			metaprogram += "\t";
		}
		metaprogram += "\tSystem.out.println(\"\"";
		for (int i = 1; i <= n; i++){
			metaprogram += " + c"+i;
		}
		metaprogram += ");\n";
		//zadnji del
		for (int i = n+2; i > 0; i--){
                        for(int indent = i; indent > 1; indent--){
				metaprogram += "\t";
                        }
			metaprogram += "}\n";
		}
		System.out.print(metaprogram);
	}
}
