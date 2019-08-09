package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CandDTO;
import it.contrader.model.Cand;

/**
 * 
 * @author Pasquale
 * 
 * Implementando questa l'interfaccia converter la classe CandConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class CandConverter  implements Converter<Cand, CandDTO> {
	
	/**
	 * Crea un oggetto di tipo CandDTO e lo riempie con i campi del parametro candidato di tipo Cand.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public CandDTO toDTO(Cand cand) {
		CandDTO candDTO = new CandDTO(cand.getId_cand(), cand.getName(), cand.getSurname(), cand.getAge() ,cand.getExperience(),cand.getId_user());
		return candDTO;
	}

	/**
	 * Crea un oggetto di tipo Cand e lo riempie con i campi del parametro candidato di tipo CandDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Cand toEntity(CandDTO candDTO) {
		Cand cand = new Cand(candDTO.getId_cand(), candDTO.getName(), candDTO.getSurname(),candDTO.getAge(), candDTO.getExperience(),candDTO.getId_user());
		return cand;
	}
	
	/**
	 * Metodo per convertire le liste di Cand.
	 */
	@Override
	public List<CandDTO> toDTOList(List<Cand> candList) {
		//Crea una lista vuota.
		List<CandDTO> candDTOList = new ArrayList<CandDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Cand cand : candList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			candDTOList.add(toDTO(cand));
		}
		return candDTOList;
	}

	
	
}
