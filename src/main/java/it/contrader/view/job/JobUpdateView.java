package it.contrader.view.job;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class JobUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String name;
	private String description;
	private final String mode = "UPDATE";

	public JobUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Job", null);
		}
	}

	/**
	 * Chiede al candidato di inserire gli attributi del candidato da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del lavor:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome del lavoro:");
			name = getInput();
			System.out.println("Inserisci descrizione del lavoro:");
			description = getInput();
			
			
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Job", "doControl", request);
	}

}


