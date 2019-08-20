package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Cand;
import it.contrader.model.User;

public interface CandRepository extends CrudRepository<Cand, Long> {

	public Cand findCandById(long id);
	public List<Cand> findAllByUser(User user);
}

