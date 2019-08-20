package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Job;



public interface JobRepository extends CrudRepository <Job, Long  > {

	public Job findJobById (long id);
}
