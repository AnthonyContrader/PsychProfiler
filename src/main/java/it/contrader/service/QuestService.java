package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.QuestConverter;
import it.contrader.dao.QuestRepository;
import it.contrader.dto.QuestDTO;
import it.contrader.model.Quest;

@Service
public class QuestService extends AbstractService<Quest,QuestDTO> {
	@Autowired
	private QuestConverter converter;
	@Autowired
	private QuestRepository repository;
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public QuestDTO findQuestById(long id) {
		return converter.toDTO(repository.findQuestById(id));
	}

	public Iterable<QuestDTO> getPar(String arg) {
		// TODO Auto-generated method stub
		return converter.toDTOList(repository.findByArgs(arg));
	}

}
	