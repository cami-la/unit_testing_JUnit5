package dev.camila.unitTesting.JUnit5.entities;

import dev.camila.unitTesting.JUnit5.enums.Turno;

public class Matricula {
	private Long id;
	private Aluno aluno;
	private Curso curso;
	private Turno turno;
	private Double valorMatricula;
	
	public Matricula(Long id, Aluno aluno, Curso curso, Turno turno, Double valorMatricula) {
		this.id = id;
		this.aluno = aluno;
		this.curso = curso;
		this.turno = turno;
		this.valorMatricula = valorMatricula;
	}

	public Matricula() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Double getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(Double valorMatricula) {
		this.valorMatricula = valorMatricula;
	}
}
