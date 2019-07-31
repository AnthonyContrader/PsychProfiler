package it.contrader.view.cand;

import it.contrader.controller.Request;

import it.contrader.dto.CandDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Pasquale
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class CandReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public CandReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			CandDTO cand = (CandDTO) request.get("cand");
			System.out.println(cand);
			MainDispatcher.getInstance().callView("Cand", null);
		}
	}

	
	/**
	 * chiede al candidato di inserire l'id del candidato da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del candidato:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id del candidato da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Cand", "doControl", request);
	}

}
