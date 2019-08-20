package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterAnswer;
import it.contrader.dao.AnswerRepository;
import it.contrader.dto.AnswerDTO;
import it.contrader.model.Answer;
@Service
public class AnswerService extends AbstractService<Answer, AnswerDTO> {
	@Autowired
	private ConverterAnswer converter;
	@Autowired
	private AnswerRepository repository;

	public AnswerDTO  findAnswerByid(long id) {
		return converter.toDTO(repository.findAnswerByid(id));
	}
}
