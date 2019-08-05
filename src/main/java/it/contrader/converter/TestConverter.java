package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TestDTO;
import it.contrader.model.Test;

/**
 * 
 * @author Pasquale
 * 
 *         Implementando questa l'interfaccia converter la classe TestConverter
 *         è OBBLIGATA ad implementarne i metodi
 *
 */
public class TestConverter implements Converter<Test, TestDTO> {

	/**
	 * Crea un oggetto di tipo TestDTO e lo riempie con i campi del parametro test
	 * di tipo Test. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public TestDTO toDTO(Test test) {
		TestDTO testDTO = new TestDTO(test.getId(),test.getIdUser(), test.getQuest1(), test.getAns1(),
				test.getQuest2(), test.getAns2(), test.getQuest3(), test.getAns3(), test.getQuest4(), test.getAns4(),
				test.getQuest5(), test.getAns5());
		return testDTO;
	}

	/**
	 * Crea un oggetto di tipo Test e lo riempie con i campi del parametro test di
	 * tipo TestDTO. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public Test toEntity(TestDTO testDTO) {
		Test test = new Test(testDTO.getId(),testDTO.getIdUser(), testDTO.getQuest1(), testDTO.getAns1(),
				testDTO.getQuest2(), testDTO.getAns2(), testDTO.getQuest3(), testDTO.getAns3(), testDTO.getQuest4(),
				testDTO.getAns4(), testDTO.getQuest5(), testDTO.getAns5());
		return test;
	}

	/**
	 * Metodo per convertire le liste di Test.
	 */
	@Override
	public List<TestDTO> toDTOList(List<Test> testList) {
		// Crea una lista vuota.
		List<TestDTO> testDTOList = new ArrayList<TestDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Test test : testList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			testDTOList.add(toDTO(test));
		}
		return testDTOList;
	}
}
