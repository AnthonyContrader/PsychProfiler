package it.contrader.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CandDTO;

import it.contrader.service.CandService;
@RestController
@CrossOrigin
@RequestMapping("/cand")

public class CandController extends AbstractController<CandDTO>{
	
	@Autowired
	private CandService candService;

	

	
}