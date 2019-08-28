package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CandDTO;
import it.contrader.model.Cand;

@Component
public class CandConverter extends AbstractConverter<Cand,CandDTO> {

	@Override
	public Cand toEntity(CandDTO candDTO) {
		Cand cand = null;
		if (candDTO != null) {
			cand = new Cand(candDTO.getId(), candDTO.getName(), candDTO.getSurname(), candDTO.getAge(), candDTO.getExperience(), candDTO.getUser());
		}
		return cand;
	}

	@Override
	public CandDTO toDTO(Cand cand) {
		CandDTO candDTO = null;
		if (cand != null) {
			candDTO = new CandDTO(cand.getId(), cand.getName(), cand.getSurname(), cand.getAge(), cand.getExperience(), cand.getUser());

		}
		return candDTO;
	}
}