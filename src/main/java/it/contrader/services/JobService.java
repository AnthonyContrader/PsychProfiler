package it.contrader.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterJob;
import it.contrader.dao.JobRepository;
import it.contrader.dto.JobDTO;
import it.contrader.model.Job;

@Service
public class JobService extends AbstractService<Job, JobDTO> {

	@Autowired
	private ConverterJob converter;
	@Autowired
	private JobRepository repository;

	public JobDTO findById(Long id) {
		return converter.toDTO(repository.findJobById(id));
	}


}
