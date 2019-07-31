package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.JobDTO;
import it.contrader.model.Job;

/**
 * 
 * @author Pasquale
 * 
 * Implementando questa l'interfaccia converter la classe JobConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class JobConverter  implements Converter<Job, JobDTO> {
	
	/**
	 * Crea un oggetto di tipo JobDTO e lo riempie con i campi del parametro job di tipo Job.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public JobDTO toDTO(Job job) {
		JobDTO jobDTO = new JobDTO(job.getId(), job.getName(), job.getDescription());
		return jobDTO;
	}

	/**
	 * Crea un oggetto di tipo Job e lo riempie con i campi del parametro job di tipo JobDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Job toEntity(JobDTO jobDTO) {
		Job job = new Job(jobDTO.getId(), jobDTO.getName(), jobDTO.getDescription());
		return job;
	}
	
	/**
	 * Metodo per convertire le liste di Job.
	 */
	@Override
	public List<JobDTO> toDTOList(List<Job> jobList) {
		//Crea una lista vuota.
		List<JobDTO> jobDTOList = new ArrayList<JobDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Job job : jobList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			jobDTOList.add(toDTO(job));
		}
		return jobDTOList;
	}

	
	
}
