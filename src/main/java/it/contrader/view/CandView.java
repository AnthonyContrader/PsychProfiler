package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CandDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class CandView extends AbstractView {

	private Request request;
	private String choice;

	public CandView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Candidati ----------------\n");
			System.out.println("ID\tname\tsurname\tage\texperience Candidato");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<CandDTO> cands = (List<CandDTO>) request.get("cands");
			for (CandDTO c: cands)
				System.out.println(c);
			System.out.println();
		}
	}

	/**
	 * Chiede al candidato un input (lettera da tastiera) per la choice (vedi CandController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo CandController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Cand", "doControl", this.request);
	}

}

