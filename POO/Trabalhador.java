package POO;

public class Trabalhador {

	  private String nome;
	  private float salario;
	  private String cpf;
	  private int idade;
	  private char sexo;
	  private String endereco;

	  public Trabalhador() {
	    this.nome = "";
	    this.salario = 0f;
	    this.cpf = "";
	    this.idade = 0;
	    this.sexo = 'n';
	    this.endereco = "";
	  }

	  public Trabalhador(String nome, float salario, String cpf, int idade, 
			  char sexo, String endereco) {
	    this.nome = nome;
	    this.salario = salario;
	    this.cpf = cpf;
	    this.idade = idade;
	    this.sexo = sexo;
	    this.endereco = endereco;
	  }

	  public void setNome(String nome) {
	    this.nome = nome;
	  }

	  public void setSalario(float salario) {
	    this.salario = salario;
	  }

	  public void setCpf(String cpf) {
	    this.cpf = cpf;
	  }

	  public void setIdade(int idade) {
	    this.idade = idade;
	  }

	  public void setSexo(char sexo) {
	    this.sexo = sexo;
	  }

	  public void setEndereco(String endereco) {
	    this.endereco = endereco;
	  }

	  public String getNome() {
	    return nome;
	  }

	  public float getSalario() {
	    return salario;
	  }

	  public String getCpf() {
	    return cpf;
	  }

	  public int getIdade() {
	    return idade;
	  }

	  public char getSexo() {
	    return sexo;
	  }

	  public String getEndereco() {
	    return endereco;
	  }

	  public void mostra() {
		  System.out.println("Funcionário: "+nome);
		  System.out.println("\nSalário: "+salario);
		  System.out.println("\nCPF: "+cpf);
		  System.out.println("\nIdade: "+idade);
		  System.out.println("\nSexo: "+sexo);
		  System.out.println("\nEndereço: "+endereco);
		 }

	  public float calculaSalarioAnual() {
	    return salario * 12;
	  }

	  static int MAX_TRABALHADOR = 50;
	  public static void main(String[] args) {
			 Trabalhador trabs[] = new Trabalhador[MAX_TRABALHADOR];
			 int n = 5;
			 trabs[0] = new Trabalhador("\nErika", 5500.00f , "123.456.789-01", 19, 'F', "Rua Eeeeee");
			 trabs[1] = new Trabalhador("\nJúlia", 6000.00f, "321.654.987-10", 19, 'F', "Rua Jjjjjjj");
			 trabs[2] = new Trabalhador("\nEmma", 5000.10f, "987.654.321-11", 31, 'F', "Rua Emmmmmm");
			 trabs[3] = new Trabalhador("\nLucas", 3300.00f, "555.222.111-90", 33, 'M', "Rua Llllllll");
			 trabs[4] = new Trabalhador("\nCaio", 2000.00f, "222.444.777-08", 39, 'M', "Rua Ccccccc");
			 
			 float media_salario = 0;
			 
			 for(int i = 0; i < n; i++){
			 	media_salario += trabs[i].getSalario();
			 }
			 
			 float media = media_salario/n;
			 System.out.println("\nMédia salarial: " + media);
			 
			 System.out.println("\n###################################################\n");
			 
			 for (int i = 0; i < n; i++) {
				 if(trabs[i].getSalario() > media) {
					 trabs[i].mostra();
				 }
			 }
			 
			 float media_30 = 0;
			 int aux = 0;
			 for (int i = 0; i < n; i++) {
				 if(trabs[i].getIdade() > 30) {
					 media_30 += trabs[i].getSalario();
					 aux++;
				 }
			 }
			 
			 System.out.println(aux);
			 
			 float media30_total = media_30/aux;
			 System.out.println("\nMédia dos trabalhadores maiores de 30 anos = " + media30_total);

			 System.out.println("\n###################################################\n");
			 
			 int totalAbaixo = 0;
			 for (int i = 0; i < n; i++) {
				 if(trabs[i].getIdade() > 30) {
					 if (trabs[i].getSalario() < media30_total) {
						 totalAbaixo++;
					 }
				 }
			 }
			 
			 System.out.println("\nQuantidade de trabalhadores (maiores de 30 anos) abaixo da média = " + totalAbaixo);
			 
			 System.out.println("\n###################################################\n");
			 
			 Trabalhador maior = new Trabalhador();
			 maior = trabs[0];
			 
			 Trabalhador menor = new Trabalhador();
			 menor = trabs[0];
			 
			 for (int i = 0; i < n; i++) {
				 if(trabs[i].getSalario() > maior.getSalario()) {
					 maior = trabs[i];
				 }
				 else if (trabs[i].getSalario() < menor.getSalario()) {
					 menor = trabs[i];
				 } 
			 }
			 
			 System.out.println("Dados do trabalhador de maior salário: ");
			 maior.mostra();
			 
			 System.out.println("\n###################################################\n");
			 
			 System.out.println("Dados do trabalhador de menor salário: ");
			 menor.mostra();
			 
			 System.out.println("\n###################################################\n");
		  }
}
