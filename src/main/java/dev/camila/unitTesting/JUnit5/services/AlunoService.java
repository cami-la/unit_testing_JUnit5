package dev.camila.unitTesting.JUnit5.services;

import java.util.Random;

import dev.camila.unitTesting.JUnit5.entities.Aluno;

public class AlunoService {
	
	public Aluno novoAluno(String nome, String numeroContato) {
		if(!validaNumero(numeroContato)) {
			throw new IllegalStateException(String.format("Número inválido [%s]", numeroContato));
		}
		Aluno aluno = new Aluno();
		aluno.setId(new Random().nextLong());
		aluno.setNome(nome);
		aluno.setNumeroContato(numeroContato);
		return aluno;
	}
	
	public static boolean validaNumero(String numeroContato) {
		return numeroContato.startsWith("81") &&
				numeroContato.indexOf("9") == 2 &&
				numeroContato.length() == 11;
	}
}
