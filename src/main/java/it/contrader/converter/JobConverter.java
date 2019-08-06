package it.contrader.converter;

import java.util.List;
import java.util.ArrayList;

import it.contrader.dto.JobDTO;
import it.contrader.model.Job;

public  class JobConverter implements Converter<Job, JobDTO> {

	@Override
	public JobDTO toDTO(Job job) {
		JobDTO jobDTO = new JobDTO(job.getId(), job.getName(), job.getDescription());
		return jobDTO;
	}

	@Override
	public Job toEntity(JobDTO jobDTO) {
		Job job = new Job(jobDTO.getId(), jobDTO.getName(), jobDTO.getDescription());
		return job;
	}

	@Override
	public List<JobDTO> toDTOList(List<Job> jobList) {
		//Crea una lista vuota.
		List<JobDTO> jobDTOList = new ArrayList<JobDTO>();
		
		for(Job job : jobList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge alla lista di DTO
			jobDTOList.add(toDTO(job));
		}
		return jobDTOList;
	}


	

}
