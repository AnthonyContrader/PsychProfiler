package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Job;

@Repository
@Transactional
public interface JobRepository extends CrudRepository<Job, Long>{

	Job findJobById(long id);
	
}
