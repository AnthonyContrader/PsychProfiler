package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.QuestDTO;
import it.contrader.services.QuestService;

@Controller
@RequestMapping("/quest")
public class QuestController {
	
	@Autowired
	private QuestService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "quest/quest";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "quest/quest";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "quest/updatequest";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("args") String args,
			@RequestParam("quest") String quest, @RequestParam("ans1") String ans1,
			@RequestParam("ans2") String ans2, @RequestParam("ans3") String ans3, @RequestParam("ans4") String ans4 ) {

		QuestDTO dto = new QuestDTO();
		dto.setId(id);
		dto.setArgs(args);
		dto.setQuest(quest);
		dto.setAns1(ans1);
		dto.setAns2(ans2);
		dto.setAns3(ans3);
		dto.setAns4(ans4);
		service.update(dto);
		setAll(request);
		return "quest/quest";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("args") String args,
			@RequestParam("quest") String quest, @RequestParam("ans1") String ans1,
			 @RequestParam("ans2") String ans2, @RequestParam("ans3") String ans3, @RequestParam("ans4") String ans4) {
		QuestDTO dto = new QuestDTO();
		dto.setArgs(args);
		dto.setQuest(quest);
		dto.setAns1(ans1);
		dto.setAns2(ans2);
		dto.setAns3(ans3);
		dto.setAns4(ans4);
		service.insert(dto);
		setAll(request);
		return "quest/quest";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "quest/readquest";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}

