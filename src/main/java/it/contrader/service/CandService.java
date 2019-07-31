package it.contrader.service;

import it.contrader.converter.CandConverter;
import it.contrader.dao.CandDAO;
import it.contrader.dto.CandDTO;
import it.contrader.model.Cand;

/**
 * 
 * @author Pasquale
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class CandService extends AbstractService<Cand, CandDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public CandService(){
		this.dao = new CandDAO();
		this.converter = new CandConverter();
	}
	

}
