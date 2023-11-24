package POO;

public class Circulo {
	
	private float raio;
	
	public Circulo(float raio) {
		if(raio > 0) this.raio = raio;
		else System.out.println("Raio inválido");
	}
	
	public void setRaio(float raio) {
		if(raio > 0) this.raio = raio;
		else System.out.println("Raio inválido");
	}
	
	public float getRaio() {
		return raio;
	}
	
	public float calculaDiametro() {
		return raio + raio;
	}
	
	public double calculaArea() {
		return Math.PI * raio * raio;
	}
	
	public void mostraDados() {
		System.out.println("raio = "+raio+ "\tdiametro = "+calculaDiametro()+"\t     area = "+calculaArea());
	}
	
	public static void main(String[] args) {
		Circulo c1 = new Circulo(3.0f);
		c1.mostraDados();
	}
}
