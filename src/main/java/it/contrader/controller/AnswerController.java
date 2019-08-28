package it.contrader.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.AnswerDTO;
import it.contrader.service.AnswerService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/answer")

public class AnswerController extends AbstractController<AnswerDTO>{
	
	@Autowired
	private AnswerService AnswerService;

	

	
}