package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Answer;

import it.contrader.model.Quest;

import it.contrader.model.Cand;

import java.util.List;

public interface AnswerRepository extends CrudRepository <Answer,Long> {
	
	public Answer findAnswerByid(long id);
	public List<Answer> findAllByQuest (Quest quest);
	public List<Answer> findAllByCand (Cand cand);
	
}
