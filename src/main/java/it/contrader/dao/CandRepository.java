package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Cand;
import it.contrader.model.User;
@Repository
@Transactional
public interface CandRepository extends CrudRepository<Cand, Long> {

	 Cand findCandById(long id);
	 List<Cand> findAllByUser(User user);
}

