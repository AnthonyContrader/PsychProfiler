package it.contrader.service;

import it.contrader.converter.QuestionConverter;
import it.contrader.dao.QuestionDAO;
import it.contrader.dto.QuestionDTO;
import it.contrader.model.Question;

public class QuestionService  extends AbstractService<Question, QuestionDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public QuestionService(){
		this.dao = new QuestionDAO();
		this.converter = new QuestionConverter();
	}
	

}