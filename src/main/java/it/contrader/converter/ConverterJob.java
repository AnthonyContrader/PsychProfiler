package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.JobDTO;
import it.contrader.model.Job;

public class ConverterJob {
	public static JobDTO toDTO(Job job) {
		JobDTO jobDTO = null;
		if (job != null) {
			jobDTO = new JobDTO();
			jobDTO.setId(job.getId());
			jobDTO.setName(job.getName());
			jobDTO.setDescription(job.getDescription());
		}
		return jobDTO;
	}

	public static Job toEntity(JobDTO jobDTO) {
		Job job = null;
		if (jobDTO != null) {
			job = new Job();
			job.setId(jobDTO.getId());
			job.setName(jobDTO.getName());
			job.setDescription(jobDTO.getDescription());
		}
		return job;
	}

	public static List<JobDTO> toListDTO(List<Job> list) {
		List<JobDTO> listJobDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Job job : list) {
				listJobDTO.add(ConverterJob.toDTO(job));
			}
		}
		return listJobDTO;
	}

	public static List<Job> toListEntity(List<JobDTO> listJobDTO) {
		List<Job> list = new ArrayList<>();
		if (!listJobDTO.isEmpty()) {
			for (JobDTO jobDTO : listJobDTO) {
				list.add(ConverterJob.toEntity(jobDTO));
			}
		}
		return list;
	}
}


