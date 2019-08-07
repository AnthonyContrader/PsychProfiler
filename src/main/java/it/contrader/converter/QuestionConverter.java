package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.QuestionDTO;
import it.contrader.model.Question;

public class QuestionConverter implements Converter<Question, QuestionDTO> {

	@Override
	public QuestionDTO toDTO(Question question) {
		QuestionDTO questionDTO = new QuestionDTO(question.getId(), question.getArgs(), question.getQuest(), question.getAns1(), question.getAns2(), question.getAns3(), question.getAns4());
		return questionDTO;
	}

	@Override
	public Question toEntity(QuestionDTO questionDTO) {
		Question question = new Question(questionDTO.getId(), questionDTO.getArgs(), questionDTO.getQuest(), questionDTO.getAns1(), questionDTO.getAns2(), questionDTO.getAns3(), questionDTO.getAns4());
		return question;
	}

	@Override
	public List<QuestionDTO> toDTOList(List<Question> questionList) {
		//Crea una lista vuota.
		List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();
		
		for(Question question : questionList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge alla lista di DTO
			questionDTOList.add(toDTO(question));
		}
		return questionDTOList;
	}

}