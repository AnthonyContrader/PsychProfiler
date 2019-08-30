package it.contrader.controller;

 import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.QuestDTO;
import it.contrader.service.QuestService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/quest")

public class QuestController extends AbstractController<QuestDTO>{
	
	@Autowired
	private QuestService questService;

	@GetMapping(value= "/create")
	public Iterable<QuestDTO> getAll(String arg, Integer nquest){
		Iterable<QuestDTO> lista  = questService.getPar(arg);
		List<QuestDTO> Container = new ArrayList<QuestDTO>();
		int i=0;
		for (QuestDTO q: lista) {
			Container.add(q);
			i++;
			if(i==nquest)
			{
				break;
			}
		}
		return Container;
		
	}

	
}