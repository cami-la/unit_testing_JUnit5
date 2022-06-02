package dev.camila.unitTesting.JUnit5.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.camila.unitTesting.JUnit5.entities.Curso;
import dev.camila.unitTesting.JUnit5.entities.Matricula;

public class CursoBuilder {
	private Curso curso;
	
	public static CursoBuilder builder() {
		CursoBuilder builder = new CursoBuilder();
		Long idCurso = new Random().nextLong();
		String nomeCurso = "Unit Tests JUnit5";
		Long idProfessor = new Random().nextLong();
		List<Matricula> matriculas = new ArrayList<Matricula>();
		Double valorCurso = 1000d;
		Boolean status = true;
		builder.curso = new Curso(idCurso, nomeCurso, idProfessor, matriculas, valorCurso, status);
		return builder;
	}
	
	public Curso build() {
		return this.curso;
	}

}
