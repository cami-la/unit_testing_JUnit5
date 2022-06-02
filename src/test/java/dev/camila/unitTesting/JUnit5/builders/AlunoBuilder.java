package dev.camila.unitTesting.JUnit5.builders;

import java.util.Random;

import dev.camila.unitTesting.JUnit5.entities.Aluno;

public class AlunoBuilder {
	private Aluno aluno;
	
	public static AlunoBuilder builder() {
		AlunoBuilder builder = new AlunoBuilder();
		Long idAluno = new Random().nextLong();
		String nomeAluno = "Camila";
		String contatoAluno = "00000000";
		builder.aluno = new Aluno(idAluno, nomeAluno, contatoAluno);		
		return builder;
	}
	
	public Aluno build() {
		return this.aluno;
	}

}
