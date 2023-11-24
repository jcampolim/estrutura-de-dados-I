package Pilha;

public class Palindromo {
	
	public static boolean palindromo(String texto) {
		texto = texto.replaceAll("\\s+", "");
		texto = texto.toLowerCase();
		Stack t = new Stack(texto.length());
		
		if(texto == "") {
			return true;
		}
		
		for(int i = 0; i < texto.length(); i++) {
			t.push(texto.charAt(i));
		}
		
		for(int i = 0; i < texto.length(); i++) {
			if(texto.charAt(i) != t.pop()) {
				return false;
			}
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		String texto = "Mussum";
		System.out.println(palindromo(texto));
	}

}
