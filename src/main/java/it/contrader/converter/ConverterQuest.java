package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.QuestDTO;
import it.contrader.model.Quest;

public class ConverterQuest {
	public static QuestDTO toDTO(Quest quest) {
		QuestDTO questDTO = null;
		if(quest != null) {
			questDTO= new QuestDTO();
			questDTO.setId(quest.getId());
			questDTO.setArgs(quest.getArgs());
			questDTO.setQuest(quest.getQuest());
			questDTO.setAns1(quest.getAns1());
			questDTO.setAns2(quest.getAns2());
			questDTO.setAns3(quest.getAns3());
			questDTO.setAns4(quest.getAns4());
		}
		return questDTO;
	}
	public static Quest toEntity(QuestDTO questDTO) {
		Quest quest = null;
		if(questDTO != null) {
		quest = new Quest();
		quest.setId(questDTO.getId());
		quest.setArgs(questDTO.getArgs());
		quest.setQuest(questDTO.getQuest());
		quest.setAns1(questDTO.getAns1());
		quest.setAns2(questDTO.getAns2());
		quest.setAns3(questDTO.getAns3());
		quest.setAns4(questDTO.getAns4());
		}
		return quest;
	}

	public static List<QuestDTO> toListDTO(List<Quest> list) {
		List<QuestDTO> listQuestDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Quest Quest : list) {
				listQuestDTO.add(ConverterQuest.toDTO(Quest));
			}
		}
		return listQuestDTO;
	}

	public static List<Quest> toListEntity(List<QuestDTO> listQuestDTO) {
		List<Quest> list = new ArrayList<>();
		if (!listQuestDTO.isEmpty()) {
			for (QuestDTO questDTO : listQuestDTO) {
				list.add(ConverterQuest.toEntity(questDTO));
			}
		}
		return list;
	}
}


