package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AnswerDTO;
import it.contrader.model.Answer;

public class ConverterAnswer {
	public static AnswerDTO toDTO(Answer answer) {
		AnswerDTO answerDTO = null;
		if (answer != null) {
			answerDTO = new AnswerDTO();
			answerDTO.setId(answer.getId());
			answerDTO.setCand(answer.getCand());
			answerDTO.setQuest(answer.getQuest());
			answerDTO.setAns(answer.getAns());
			
		}
		return answerDTO;
	}
	public static Answer toEntity(AnswerDTO answerDTO) {
		Answer answer= null;
		if(answerDTO != null) {
			 answer= new Answer();
			 answer.setId(answerDTO.getId());
			 answer.setCand(answerDTO.getCand());
			 answer.setQuest(answerDTO.getQuest());
		}
		return answer;
	}
	public static List<AnswerDTO> toListDTO(List<Answer> list)
	{
		List<AnswerDTO> listAnswerDTO = new ArrayList<>();
		if(!list.isEmpty()) {
			for(AnswerDTO answerDTO : listAnswerDTO) {
				list.add(ConverterAnswer.toEntity(answerDTO));
			}
			
		}
		return listAnswerDTO;
	}
	public static List<Answer> toListEntity(List<AnswerDTO> listAnswerDTO){
		List<Answer> list = new ArrayList<>();
		if(!listAnswerDTO.isEmpty()) {
			for(AnswerDTO answerDTO : listAnswerDTO) {
				list.add(ConverterAnswer.toEntity(answerDTO));
			}
			
		}
		return list;
	}
 
}
