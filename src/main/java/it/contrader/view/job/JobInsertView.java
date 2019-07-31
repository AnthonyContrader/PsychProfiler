package it.contrader.view.job;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class JobInsertView extends AbstractView{
	private Request request;

	private String name;
	private String description;
	private final String mode = "INSERT";

	public JobInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Job", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del candidato da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome del lavoro:");
			name = getInput();
			System.out.println("Inserisci descrizione del lavoro:");
			description = getInput();

			
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Job", "doControl", request);
	}


}


