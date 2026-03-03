package model;

public class Aluno {

	private String nome;
	private String cpf;
	private int idade;
	private String plano;
	private Double mensalidade;
	
	
	public Aluno() {
	}

	public Aluno(String nome, String cpf, int idade, String plano, Double mensalidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.plano = plano;
		this.mensalidade = mensalidade;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}


	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

}
