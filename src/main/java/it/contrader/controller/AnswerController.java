package it.contrader.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.AnswerDTO;
import it.contrader.model.Cand;
import it.contrader.model.Quest;
import it.contrader.services.AnswerService;
import it.contrader.services.CandService;
import it.contrader.services.QuestService;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService service;
	@Autowired
	private CandService cService;
	@Autowired
	private QuestService qService;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		setAllCand(request);
		setAllQuest(request);
		return "answer";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "answer";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateanswer";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("cand") Cand cand,
			@RequestParam("quest") Quest quest, @RequestParam("ans") int ans) {

		AnswerDTO dto = new AnswerDTO();
		dto.setId(id);
		dto.setCand(cand);
		dto.setQuest(quest);
		dto.setAns(ans);
		service.update(dto);
		setAll(request);
		return "answer";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("cand") Cand cand,
			@RequestParam("quest") Quest quest, @RequestParam("ans") int ans) {
		AnswerDTO dto = new AnswerDTO();
		dto.setCand(cand);
		dto.setQuest(quest);
		dto.setAns(ans);
		service.insert(dto);
		setAll(request);
		return "answer";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readanswer";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	
	private void setAllQuest(HttpServletRequest request) {
		request.getSession().setAttribute("Questlist", qService.getAll());
	}
	private void setAllCand(HttpServletRequest request) {
		request.getSession().setAttribute("Candlist", cService.getAll());
	}
}



