package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.JobDTO;
import it.contrader.model.Job;

@Component
public class ConverterJob extends AbstractConverter<Job, JobDTO> {

	@Override
	public Job toEntity(JobDTO jobDTO) {
		Job job = null;
		if (jobDTO != null) {
			job = new Job(jobDTO.getId(), jobDTO.getName(), jobDTO.getDescription());
		}
		return job;
	}

	@Override
	public JobDTO toDTO(Job job) {
		JobDTO jobDTO = null;
		if (job != null) {
			jobDTO = new JobDTO(job.getId(), job.getName(), job.getDescription());

		}
		return jobDTO;
	}
}