package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AnswerDTO;
import it.contrader.model.Answer;

public class AnswerConverter implements Converter<Answer, AnswerDTO>{

	@Override
	public AnswerDTO toDTO(Answer answer) {
		AnswerDTO answerDTO = new AnswerDTO(answer.getId_ans(),answer.getId_cand(),answer.getId_quest(),answer.getAns());
		return answerDTO;
	}

	@Override
	public Answer toEntity(AnswerDTO answerDTO) {
		Answer answer = new Answer(answerDTO.getId_ans(),answerDTO.getId_cand(),answerDTO.getId_quest(),answerDTO.getAns());
		return answer;
	}

	@Override
	public List<AnswerDTO> toDTOList(List<Answer> answerList) {
		List<AnswerDTO> answerDTOList = new ArrayList<AnswerDTO>();
		for(Answer answer : answerList) {
			answerDTOList.add(toDTO(answer));
		}
		return answerDTOList;
	}

}
