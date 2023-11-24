package Josephus;

//Erika Borges Piaui - 32284683
//João Pedro Zavanela Andreu - 42246271
//Júlia Campolim de Oste - 42201691

//Cria a classe soldado, contendo nome e código.
public class Soldier {
	
	private String name;
	private int code;

	public Soldier(String name, int code) {
		this.name= name;
		this.code = code;
	}

	public String getName() {
		return name;
	}
	
	public int getCode() {
		return code;
	}
}
