package it.contrader.service;

import it.contrader.converter.JobConverter;
import it.contrader.dao.JobDAO;
import it.contrader.dto.JobDTO;
import it.contrader.model.Job;

public class JobService extends AbstractService<Job, JobDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public JobService(){
		this.dao = new JobDAO();
		this.converter = new JobConverter();
	}
	

}