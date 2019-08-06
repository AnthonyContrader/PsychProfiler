package it.contrader.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CandDTO;
import it.contrader.service.Service;
import it.contrader.service.CandService;


@SuppressWarnings("serial")
public class CandServlet extends HttpServlet {

	/**
	 * 
	 */
	public CandServlet() {
		}
	public void updateList(HttpServletRequest request) {
		Service<CandDTO> service = new CandService();
		List<CandDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CandDTO> service = new CandService();
		String mode = request.getParameter("mode");
		CandDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "CANDLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/cand/candmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/cand/readcand.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/cand/updatecand.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String surname = request.getParameter("surname").toString();
			int age= Integer.parseInt(request.getParameter("age"));
			String experience = request.getParameter("experience").toString();
			dto = new CandDTO (name,surname,age,experience);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/cand/candmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id"));
			name = request.getParameter("name");
			surname = request.getParameter("surname");
			age = Integer.parseInt(request.getParameter("age"));
			experience = request.getParameter("experience");
			dto = new CandDTO (id,name, surname,age, experience);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/cand/candmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/cand/candmanager.jsp").forward(request, response);
			break;
		}
	}


}
