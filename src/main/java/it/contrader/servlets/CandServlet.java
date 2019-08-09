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
		List<CandDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CandDTO> service = new CandService();
		String mode = request.getParameter("mode");
		CandDTO dto;
		int id_cand;
		boolean ans;
		System.out.println("Mode:" + mode);
		switch (mode.toUpperCase()) {

		case "CANDLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/cand/candmanager.jsp").forward(request, response);
			break;

		case "READ":

			id_cand = Integer.parseInt(request.getParameter("idCand"));
			System.out.println("idCand:" + id_cand);
			dto = service.read(id_cand);
			System.out.println("dto: " + dto.getId_user());
			request.setAttribute("dto", dto);

			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/cand/readcand.jsp").forward(request, response);

			}

			else
				getServletContext().getRequestDispatcher("/cand/updatecand.jsp").forward(request, response);

			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String surname = request.getParameter("surname").toString();
			int age = Integer.parseInt(request.getParameter("age"));
			String experience = request.getParameter("experience").toString();
			int id_user = Integer.parseInt(request.getParameter("idUser"));
			dto = new CandDTO(name, surname, age, experience, id_user);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/cand/candmanager.jsp").forward(request, response);
			break;

		case "UPDATE":
			id_cand =Integer.parseInt(request.getParameter("idCand"));
			name = request.getParameter("name");
			surname = request.getParameter("surname");
			age = Integer.parseInt(request.getParameter("age"));
			experience = request.getParameter("experience");
			id_user = Integer.parseInt(request.getParameter("id_user"));
			dto = new CandDTO(name, surname, age, experience, id_user);
			dto.setId(id_cand);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/cand/candmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id_cand = Integer.parseInt(request.getParameter("idCand"));
			ans = service.delete(id_cand);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/cand/candmanager.jsp").forward(request, response);
			break;
		}
	}

}
