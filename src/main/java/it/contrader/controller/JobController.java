package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.JobDTO;
import it.contrader.service.JobService;

@RestController
@RequestMapping("/job")
@CrossOrigin(origins = "http://localhost:4200")
public class JobController extends AbstractController<JobDTO>{
	
	@Autowired
	private JobService jobService;

}