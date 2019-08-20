package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Quest;

public interface QuestRepository extends CrudRepository < Quest ,Long>{
	public Quest findQuestByid(long id);

}
