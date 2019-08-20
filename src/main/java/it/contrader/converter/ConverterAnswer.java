package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.AnswerDTO;

import it.contrader.model.Answer;

@Component
public class ConverterAnswer extends AbstractConverter<Answer, AnswerDTO> {

	@Override
	public Answer toEntity(AnswerDTO answerDTO) {
		Answer answer = null;
		if(answerDTO != null) {
			answer = new Answer(answerDTO.getId(), answerDTO.getCand(),answerDTO.getQuest(),answerDTO.getAns());
		}
		return answer;
	}

	@Override
	public AnswerDTO toDTO(Answer answer) {
		AnswerDTO answerDTO = null;
		if (answer != null) {
			answerDTO = new AnswerDTO(answer.getId(), answer.getCand(), answer.getQuest(), answer.getAns());

		}
		return answerDTO;
	}


}