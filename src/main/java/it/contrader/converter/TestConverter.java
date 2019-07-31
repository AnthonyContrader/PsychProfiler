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
		TestDTO testDTO = new TestDTO(test.getQuest1(), test.getAns1(), test.getQuest2(), test.getAns2(),
				test.getQuest3(), test.getAns3(), test.getQuest4(), test.getAns4(), test.getQuest5(), test.getAns5(),
				test.getQuest6(), test.getAns6(), test.getQuest7(), test.getAns7(), test.getQuest8(), test.getAns8(),
				test.getQuest9(), test.getAns9(), test.getQuest10(), test.getAns10(), test.getId(), test.getIdUser());
		return testDTO;
	}

	/**
	 * Crea un oggetto di tipo Test e lo riempie con i campi del parametro test di
	 * tipo TestDTO. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public Test toEntity(TestDTO testDTO) {
		Test test = new Test(testDTO.getQuest1(), testDTO.getAns1(),
				testDTO.getQuest2(), testDTO.getAns2(), testDTO.getQuest3(), testDTO.getAns3(), testDTO.getQuest4(),
				testDTO.getAns4(), testDTO.getQuest5(), testDTO.getAns5(), testDTO.getQuest6(), testDTO.getAns6(),
				testDTO.getQuest7(), testDTO.getAns7(), testDTO.getQuest8(), testDTO.getAns8(), testDTO.getQuest9(),
				testDTO.getAns9(), testDTO.getQuest10(), testDTO.getAns10(), testDTO.getId(), testDTO.getIdUser());
		return test;
	}

	/**
	 * Metodo per convertire le liste di Test.
	 */
	@Override
	public List<TestDTO> toDTOList(List<Test> testList) {
		//Crea una lista vuota.
		List<TestDTO> testDTOList = new ArrayList<TestDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Test test : testList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			testDTOList.add(toDTO(test));
		}
		return testDTOList;
	}
}
