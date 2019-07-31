package it.contrader.service;

import it.contrader.converter.JobConverter;
import it.contrader.dao.JobDAO;
import it.contrader.dto.JobDTO;
import it.contrader.model.Job;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class JobService extends AbstractService<Job, JobDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public JobService(){
		this.dao = new JobDAO();
		this.converter = new JobConverter();
	}
	

}
