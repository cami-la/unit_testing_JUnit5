package dev.camila.unitTesting.JUnit5.entities;

public class Aluno {
	private Long id;
	private String nome;
	private String numeroContato;
	
	public Aluno(Long id, String nome, String numeroContato) {
		this.id = id;
		this.nome = nome;
		this.numeroContato = numeroContato;
	}

	public Aluno() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}
}
