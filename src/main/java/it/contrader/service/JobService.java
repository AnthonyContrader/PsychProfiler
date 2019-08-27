package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.JobConverter;
import it.contrader.dao.JobRepository;
import it.contrader.dto.JobDTO;
import it.contrader.model.Job;

@Service
public class JobService extends AbstractService<Job,JobDTO> {
	@Autowired
	private JobConverter converter;
	@Autowired
	private JobRepository repository;
	//ALL crud methods in AbstractService
	
	//LOGIN method
	public JobDTO findJobById(long id) {
		return converter.toDTO(repository.findJobById(id));
	}

}
	