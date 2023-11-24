package POO;

public class Palindromo {
	
	private String texto;
	
	public Palindromo() {
		this.texto = "";
	}
	
	public Palindromo(String texto) {
		this.texto = texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public boolean verifica() {
		int i = 0, j = texto.length() - 1;
		String texto1 = texto.toLowerCase();
		
		while(i < texto.length() && j >= 0) {
			if(Character.compare(texto1.charAt(i), ' ') == 0) i++;
			if(Character.compare(texto1.charAt(j), ' ') == 0) j--;
			if(Character.compare(texto1.charAt(i), texto1.charAt(j)) != 0) return false;
			j--;
			i++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Palindromo p = new Palindromo("A sacada da casa");
		
		if(p.verifica() == true) System.out.println("É palindromo!");
		
		else System.out.println("Não é palindromo");
	}
}
