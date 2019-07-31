package it.contrader.view.test;

import it.contrader.controller.Request;
import it.contrader.dto.TestDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TestReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public TestReadView() {
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
			TestDTO test = (TestDTO) request.get("test");
			System.out.println(test);
			MainDispatcher.getInstance().callView("Test", null);
		}
	}

	
	/**
	 * chiede al test di inserire l'id del test da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del test:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id del test da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Test", "doControl", request);
	}

}
