package dev.camila.unitTesting.JUnit5.entities;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	private Long id;
	private String nome;
	private Long idProfessor;
	private List<Matricula> matriculas = new ArrayList<Matricula>();
	private Double valorCurso;
	private Boolean status;
	
	public Curso(Long id, String nome, Long idProfessor, List<Matricula> matriculas, Double valorCurso,
			Boolean status) {
		this.id = id;
		this.nome = nome;
		this.idProfessor = idProfessor;
		this.matriculas = matriculas;
		this.valorCurso = valorCurso;
		this.status = status;
	}

	public Curso() {
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

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Double getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(Double valorCurso) {
		this.valorCurso = valorCurso;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
