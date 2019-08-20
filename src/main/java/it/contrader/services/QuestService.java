package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterQuest;
import it.contrader.dao.QuestRepository;
import it.contrader.dto.QuestDTO;
import it.contrader.model.Quest;
@Service
public class QuestService extends AbstractService<Quest, QuestDTO> {

	@Autowired
	private ConverterQuest converter;
	@Autowired
	private QuestRepository repository;

	public QuestDTO findQuestByid(long id) {
		return converter.toDTO(repository.findQuestByid(id));
	}


}
