package it.contrader.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CandConverter;
import it.contrader.dao.CandRepository;
import it.contrader.dto.CandDTO;
import it.contrader.model.Cand;

@Service
public class CandService extends AbstractService<Cand, CandDTO> {

	@Autowired
	private CandConverter converter;
	@Autowired
	private CandRepository repository;

	public CandDTO findById(Long id) {
		return converter.toDTO(repository.findCandById(id));
	}



}