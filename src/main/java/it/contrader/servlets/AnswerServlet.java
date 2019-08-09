package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.AnswerDTO;
import it.contrader.service.Service;
import it.contrader.service.AnswerService;

public class AnswerServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AnswerServlet() {
	}
	public void updateList(HttpServletRequest request) {
		Service<AnswerDTO> service = new AnswerService();
		List<AnswerDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<AnswerDTO> service = new AnswerService();
		String mode = request.getParameter("mode");
		AnswerDTO dto;
		int id_ans;
		boolean answ;
		System.out.println("mode:"+mode);
		switch (mode.toUpperCase()) {

		case "ANSWERLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/answer/answermanager.jsp").forward(request, response);
			break;

		case "READ":
			id_ans = Integer.parseInt(request.getParameter("id_ans"));
			dto = service.read(id_ans);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/answer/readanswer.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/answer/updateanswer.jsp").forward(request, response);
			
			break;

		case "INSERT":
			int id_cand = Integer.parseInt(request.getParameter("id_cand").toString());
			int id_quest = Integer.parseInt(request.getParameter("id_quest").toString());
			int ans = Integer.parseInt(request.getParameter("ans").toString());


			dto = new AnswerDTO (id_cand,id_quest,ans);
			answ = service.insert(dto);
			request.setAttribute("answ", answ);
			updateList(request);
			getServletContext().getRequestDispatcher("/answer/answermanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			id_cand = Integer.parseInt(request.getParameter("id_cand").toString());
			id_quest = Integer.parseInt(request.getParameter("id_quest").toString());
			ans = Integer.parseInt(request.getParameter("ans").toString());
			id_ans = Integer.parseInt(request.getParameter("id_ans"));
			dto = new AnswerDTO (id_cand, id_quest, ans,id_ans);
			answ = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/answer/answermanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id_ans = Integer.parseInt(request.getParameter("id_ans"));
			answ = service.delete(id_ans);
			request.setAttribute("answ", answ);
			updateList(request);
			getServletContext().getRequestDispatcher("/answer/answermanager.jsp").forward(request, response);
			break;
		}
	}
}
