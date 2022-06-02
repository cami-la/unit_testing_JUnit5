package dev.camila.unitTesting.JUnit5.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import dev.camila.unitTesting.JUnit5.entities.Aluno;

class AlunoServiceTest {

	@Test
	void devera_CriarUmNovoAluno_RetornarAluno() {
		// given
		String nomeAluno = "Camila";
		String contatoAluno = "81900000000";

		// when
		AlunoService alunoService = new AlunoService();
		Aluno actual = alunoService.novoAluno(nomeAluno, contatoAluno);

		// then
		Assertions.assertNotNull(actual);
		Assertions.assertEquals(nomeAluno, actual.getNome());
		Assertions.assertEquals(contatoAluno, actual.getNumeroContato());
	}

	@ParameterizedTest
	@CsvSource({ 
		"81900000000, true",
		"82900000000, false", 
		"81800000000, false", 
		"81900, false" })
	void devera_ValidarONumeroDeContatoDoAluno(String numeroContato, Boolean expected) {
		// when
		boolean actual = AlunoService.validaNumero(numeroContato);

		// then
		Assertions.assertEquals(expected, actual);

	}
	
	@Test
	void devera_LancarIllegalArgumentException_QuandoNumeroContatoInvalido() {
		//given
		String nomeAluno = "Camila";
		String numeroContato = "87382";
		
		//when
		//then
		AlunoService alunoService = new AlunoService();
		IllegalStateException actualException = Assertions.assertThrows(IllegalStateException.class,
				() -> alunoService.novoAluno(nomeAluno, numeroContato));
		
		String expectedMessage = String.format("Número inválido [%s]", numeroContato);
		
		Assertions.assertEquals(expectedMessage, actualException.getMessage());		
	}

	

}
