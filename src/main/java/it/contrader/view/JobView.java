package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.dto.JobDTO;
import it.contrader.main.MainDispatcher;


public class JobView extends AbstractView {

	private Request request;
	private String choice;

	public JobView() {
		
	}

	/**
	 * Mostra la lista job
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione lavori ----------------\n");
			System.out.println("ID\tMansione\tDescrizione");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<JobDTO> jobs = (List<JobDTO>) request.get("jobs");
			for (JobDTO j: jobs)
				System.out.println(j);
			System.out.println();
		
		}
	}

	/**
	 * Chiede al job un input (lettera da tastiera) per la choice (vedi JobController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Job", "doControl", this.request);
	}

}



