package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CandDTO;
import it.contrader.model.Cand;

public class ConverterCand {
	public static CandDTO toDTO(Cand cand) {
		CandDTO candDTO = null;
		if (cand != null) {
			candDTO = new CandDTO();
			candDTO.setId(cand.getId());
			candDTO.setName(cand.getName());
			candDTO.setAge(cand.getAge());
			candDTO.setExperience(cand.getExperience());
			candDTO.setUser(cand.getUser());

		}
		return candDTO;
	}

	public static Cand toEntity(CandDTO candDTO) {
		Cand cand = null;
		if (candDTO != null) {
			cand = new Cand();
			cand.setId(candDTO.getId());
			cand.setName(candDTO.getName());
			cand.setAge(candDTO.getAge());
			cand.setExperience(candDTO.getExperience());
			cand.setUser(candDTO.getUser());
		}
		return cand;
	}

	public static List<CandDTO> toListDTO(List<Cand> list) {
		List<CandDTO> listCandDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Cand cand : list) {
				listCandDTO.add(ConverterCand.toDTO(cand));
			}
		}
		return listCandDTO;
	}

	public static List<Cand> toListEntity(List<CandDTO> listCandDTO) {
		List<Cand> list = new ArrayList<>();
		if (!listCandDTO.isEmpty()) {
			for (CandDTO candDTO : listCandDTO) {
				list.add(ConverterCand.toEntity(candDTO));
			}
		}
		return list;
	}
}
