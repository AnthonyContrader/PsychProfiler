package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.QuestDTO;

import it.contrader.model.Quest;

@Component
public class QuestConverter extends AbstractConverter<Quest,QuestDTO> {

	@Override
	public Quest toEntity(QuestDTO questDTO) {
		Quest quest = null;
		if (questDTO != null) {
			quest = new Quest(questDTO.getId(),questDTO.getArgs(),questDTO.getQuest(),questDTO.getAns1(),
						questDTO.getAns2(),questDTO.getAns3(),questDTO.getAns4());			
		}
		return quest;
	}

	@Override
	public QuestDTO toDTO(Quest quest) {
		QuestDTO questDTO = null;
		if (quest != null) {
			questDTO = new QuestDTO(quest.getId(),quest.getArgs(),quest.getQuest(),quest.getAns1(),
					quest.getAns2(),quest.getAns3(),quest.getAns4());	
			
		}
		return questDTO;
	}
}