package it.contrader.service;

import it.contrader.converter.AnswerConverter;
import it.contrader.dao.AnswerDAO;
import it.contrader.dto.AnswerDTO;
import it.contrader.model.Answer;

public class AnswerService extends AbstractService<Answer, AnswerDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public AnswerService(){
		this.dao = new AnswerDAO();
		this.converter = new AnswerConverter();
	}
	

}
