package POO;

public class Carro {
	private int ano;
	private String marca;
	private String modelo;
	private String categoria;
		
	public Carro() {
		ano = 0;
		marca = "";
		modelo = "";
		categoria = "";
	}
		
	public Carro(int ano, String marca, String modelo, String categoria) {
		this.ano = ano;
		this.marca = marca;
		this.modelo = modelo;
		this.categoria = categoria;
	}
		
	public void setAno(int ano) {
		this.ano = ano;
	}
		
	public void setMarca(String marca) {
		this.marca = marca;
	}
		
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
		
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
		
	public int getAno() {
		return ano;
	}
		
	public String getMarca() {
		return marca;
	}
		
	public String getModelo() {
		return modelo;
	}
		
	public String getCategoria() {
		return categoria;
	}
	
	
	public static void main(String[] args) {
		Carro carro1 = new Carro(2023, "Fiat", "Toro", "4x4");
		
		System.out.println("Carro 1: "+carro1.getMarca()+" "+carro1.getModelo());
	}
}
