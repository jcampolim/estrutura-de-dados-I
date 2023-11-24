package POO;

public class Aluno {
	
	private String rgm;
	private String nome;
	private char sexo;
	private float notaA;
	private float notaB;
	private float notaC;
	private float notaD;
	
	public Aluno() {
		this.rgm = "";
		this.nome = "";
		this.sexo = 'n';
		this.notaA = 0;
		this.notaB = 0;
		this.notaC = 0;
		this.notaD = 0;
	}
	
	public Aluno(String rgm, String nome) {
		this.rgm = rgm;
		this.nome = nome;
		this.sexo = 'n';
		this.notaA = 0;
		this.notaB = 0;
		this.notaC = 0;
		this.notaD = 0;
	}
	
	public Aluno(String rgm, String nome, float notaA, float notaB,
			float notaC, float notaD) {
		this.rgm = rgm;
		this.nome = nome;
		this.notaA = notaA;
		this.notaB = notaB;
		this.notaC = notaC;
		this.notaD = notaD;
	}
	
	public void setRgm(String rgm) {
		this.rgm = rgm;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public void setNotaA(float notaA) {
		this.notaA = notaA;
	}
	
	public void setNotaB(float notaB) {
		this.notaB = notaB;
	}
	
	public void setNotaC(float notaC) {
		this.notaC = notaC;
	}
	
	public void setNotaD(float notaD) {
		this.notaD = notaD;
	}
	
	public String getRgm() {
		return rgm;
	}
	
	public String getNome() {
		return nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public float notaA() {
		return notaA;
	}
	
	public float notaB() {
		return notaB;
	}
	
	public float notaC() {
		return notaC;
	}
	
	public float notaD() {
		return notaD;
	}
	
	public float calculaMedia() {
		return (notaA + notaB + notaC + notaD) / 4.0f;
	}
	
	public boolean avaliaSituacao() {
		if(calculaMedia() >= 6) return true;
		else return false;
	}
	
	public void mostraDados() {
		System.out.println("Aluno: "+nome);
		System.out.printf("Notas: %.2f %.2f %.2f %.2f  ", notaA, notaB, notaC, notaD);
		System.out.printf("Média: %.2f  ", calculaMedia());
		System.out.printf("O aluno foi aprovado? %b", avaliaSituacao());
		System.out.println();
	}
	
	public static void main(String[] args) {
		Aluno julia = new Aluno("42201691", "Júlia", 8.7f, 9.5f, 7.5f, 4f);
		Aluno erika = new Aluno("32281691", "Erika", 6.7f, 9f, 8.5f, 5.9f);
		
		julia.mostraDados();
		erika.mostraDados();
	}
}
