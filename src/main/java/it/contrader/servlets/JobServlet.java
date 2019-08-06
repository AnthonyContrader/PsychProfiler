package it.contrader.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.JobDTO;
import it.contrader.service.Service;
import it.contrader.service.JobService;


public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JobServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<JobDTO> service = new JobService();
		List<JobDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<JobDTO> service = new JobService();
		String mode = request.getParameter("mode");
		JobDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "JOBLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/job/jobmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/job/readjob.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/job/updatejob.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String description = request.getParameter("description").toString();
			dto = new JobDTO (name,description);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/job/jobmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			description = request.getParameter("description");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new JobDTO (id,name, description);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/job/jobmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/job/jobmanager.jsp").forward(request, response);
			break;
		}
	}
}
