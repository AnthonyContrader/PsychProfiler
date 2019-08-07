package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.QuestionDTO;
import it.contrader.service.QuestionService;
import it.contrader.service.Service;

public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<QuestionDTO> service = new QuestionService();
		List<QuestionDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<QuestionDTO> service = new QuestionService();
		String mode = request.getParameter("mode");
		QuestionDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "QUESTIONLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/question/questionmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/question/readquestion.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/question/updatequestion.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String args = request.getParameter("args").toString();
			String quest = request.getParameter("quest").toString();
			String ans1 = request.getParameter("ans1").toString();
			String ans2 = request.getParameter("ans2").toString();
			String ans3 = request.getParameter("ans3").toString();
			String ans4 = request.getParameter("ans4").toString();
			dto = new QuestionDTO (args, quest, ans1, ans2, ans3, ans4);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/question/questionmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			args = request.getParameter("args");
			quest = request.getParameter("quest");
			ans1 = request.getParameter("ans1");
			ans2 = request.getParameter("ans2");
			ans3 = request.getParameter("ans3");
			ans4 = request.getParameter("ans4");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new QuestionDTO (id,args,quest,ans1,ans2,ans3,ans4);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/question/questionmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/question/questionmanager.jsp").forward(request, response);
			break;
		}
	}
}
