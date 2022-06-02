package dev.camila.unitTesting.JUnit5.services;

import java.util.Random;

import dev.camila.unitTesting.JUnit5.entities.Aluno;
import dev.camila.unitTesting.JUnit5.entities.Curso;
import dev.camila.unitTesting.JUnit5.entities.Matricula;
import dev.camila.unitTesting.JUnit5.enums.Turno;

public class MatriculaService {
	
	public Matricula novaMatricula(Aluno aluno, Curso curso, Turno turno) {
		if (aluno == null || curso == null || turno == null) {
			throw new NullPointerException("Entre em contato com o suporte");
		}
		if (!curso.getStatus()) {
			throw new IllegalStateException(String.format("O curso '%s' não está ativo", curso.getNome()));
		}
		Matricula novaMatricula = new Matricula();
		novaMatricula.setId(new Random().nextLong());
		novaMatricula.setAluno(aluno);
		novaMatricula.setCurso(curso);
		novaMatricula.setTurno(turno);
		novaMatricula.setValorMatricula(calculaValorMatricula(curso, turno));
		adicionaMatriculaCurso(curso, novaMatricula);
		return novaMatricula;
	}	
	
	public double calculaValorMatricula(Curso curso, Turno turno) {
		return curso.getValorCurso() * turno.porcentagemDesconto();
	}
	
	public void adicionaMatriculaCurso(Curso curso, Matricula matricula) {
		curso.getMatriculas().add(matricula);
	}
}
