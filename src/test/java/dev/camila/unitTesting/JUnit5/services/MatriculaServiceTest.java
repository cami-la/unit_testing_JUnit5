package dev.camila.unitTesting.JUnit5.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import dev.camila.unitTesting.JUnit5.builders.AlunoBuilder;
import dev.camila.unitTesting.JUnit5.builders.CursoBuilder;
import dev.camila.unitTesting.JUnit5.entities.Aluno;
import dev.camila.unitTesting.JUnit5.entities.Curso;
import dev.camila.unitTesting.JUnit5.entities.Matricula;
import dev.camila.unitTesting.JUnit5.enums.Turno;

class MatriculaServiceTest {
	
	private MatriculaService matriculaService;
	
	@BeforeEach
	void setup() {
		this.matriculaService = new MatriculaService();
	}

	@ParameterizedTest
	@EnumSource(Turno.class)
	void devera_CriarUmaNovaMatricula_IndependenteDoTurno(Turno turno) {
		Assumptions.assumeTrue("camila".equals(System.getProperty("user.name")));
		// given
		Aluno aluno = AlunoBuilder.builder().build();
		Curso curso = CursoBuilder.builder().build();

		// when
		Matricula actual = matriculaService.novaMatricula(aluno, curso, turno);

		// then
		Matricula expectedMatricula = curso.getMatriculas().get(0);
		double expectedValorMatricula = curso.getValorCurso() * turno.porcentagemDesconto();

		Assertions.assertEquals(aluno, actual.getAluno());
		Assertions.assertEquals(curso, actual.getCurso());
		Assertions.assertEquals(turno, actual.getTurno());
		Assertions.assertEquals(expectedValorMatricula, actual.getValorMatricula());
		Assertions.assertEquals(expectedMatricula, actual);
	}

	
	@Test
	void devera_lancarNullPointerException_QuandoAlunoNull() {
		Assumptions.assumeFalse("Windows".equals(System.getProperty("os.name")));
		// given
		Curso curso = CursoBuilder.builder().build();
		Turno turno = Turno.NOITE;

		// when
		// then
		NullPointerException actualException = Assertions.assertThrows(NullPointerException.class,
				() -> matriculaService.novaMatricula(null, curso, turno));

		String expectedMessage = "Entre em contato com o suporte";
		
		Assertions.assertEquals(expectedMessage, actualException.getMessage());
	}
	
	@Test
	@EnabledForJreRange(min=JRE.JAVA_8, max=JRE.JAVA_11)
	void devera_lancarNullPointerException_QuandoCursoNull() {
		// given
		Aluno aluno = AlunoBuilder.builder().build();
		Turno turno = Turno.NOITE;

		// when
		// then
		NullPointerException actualException = Assertions.assertThrows(NullPointerException.class,
				() -> matriculaService.novaMatricula(aluno, null, turno));

		String expectedMessage = "Entre em contato com o suporte";
		
		Assertions.assertEquals(expectedMessage, actualException.getMessage());
	}

	@Test
	@EnabledIfSystemProperty(named = "os.arch", matches = "amd64")
	void devera_lancarNullPointerException_QuandoTurnoNull() {
		// given
		Aluno aluno = AlunoBuilder.builder().build();
		Curso curso = CursoBuilder.builder().build();

		// when
		// then
		NullPointerException actualException = Assertions.assertThrows(NullPointerException.class,
				() -> matriculaService.novaMatricula(aluno, curso, null));

		String expectedMessage = "Entre em contato com o suporte";
		
		Assertions.assertEquals(expectedMessage, actualException.getMessage());
	}
	
	@Test
	@DisabledIfEnvironmentVariable(named = "USER", matches = "camila")
	void devera_lancarIllegalStateException_QuandoCursoDesativado() {
		// given
		Aluno aluno = AlunoBuilder.builder().build();
		Curso curso = CursoBuilder.builder().build();
		Turno turno = Turno.MANHA;

		// when
		// then
		curso.setStatus(false);
		IllegalStateException actualException = Assertions.assertThrows(IllegalStateException.class,
				() -> matriculaService.novaMatricula(aluno, curso, turno));

		String expectedMessage = String.format("O curso '%s' não está ativo", curso.getNome());
		
		Assertions.assertEquals(expectedMessage, actualException.getMessage());
	}
}
