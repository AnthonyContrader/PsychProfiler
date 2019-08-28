package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.AnswerConverter;
import it.contrader.dao.AnswerRepository;
import it.contrader.dto.AnswerDTO;
import it.contrader.model.Answer;

@Service
public class AnswerService extends AbstractService<Answer,AnswerDTO> {
	@Autowired
	private AnswerConverter converter;
	@Autowired
	private AnswerRepository repository;
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public AnswerDTO findJobById(long id) {
		return converter.toDTO(repository.findAnswerByid(id));
	}

}