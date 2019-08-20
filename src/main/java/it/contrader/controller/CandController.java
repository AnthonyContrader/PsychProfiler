package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.CandDTO;
import it.contrader.model.User;
import it.contrader.services.CandService;

@Controller
@RequestMapping("/cand")
public class CandController {
	@Autowired
	private CandService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "cands";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "cands";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatecand";
    }
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("age") int age, @RequestParam("experience") String experience, @RequestParam("user") User user) {

		CandDTO dto = new CandDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSurname(surname);
		dto.setAge(age);
		dto.setExperience(experience);
		dto.setUser(user);
		service.update(dto);
		setAll(request);
		return "cands";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("age") int age, @RequestParam("experience") String experience, @RequestParam("user") User user) {
		CandDTO dto = new CandDTO();
		dto.setName(name);
		dto.setSurname(surname);
		dto.setAge(age);
		dto.setExperience(experience);
		dto.setUser(user);
		service.update(dto);
		setAll(request);
		return "cands";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("age") int age, @RequestParam("experience") String experience, @RequestParam("user") String user) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readcand";
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

