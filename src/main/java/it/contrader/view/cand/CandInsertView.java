package it.contrader.view.cand;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CandInsertView extends AbstractView{
	private Request request;

	private String name;
	private String surname;
	private int age ;
	private String experience;
	private final String mode = "INSERT";

	public CandInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Cand", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del candidato da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome del candidato:");
			name = getInput();
			System.out.println("Inserisci cognome del candidato:");
			surname = getInput();
			System.out.println("Inserisci eta' del candidato:");
			age = Integer.parseInt(getInput());
			System.out.println("Inserisci esperienza del candidato:");
			experience = getInput();
			
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("surname", surname);
		request.put("age", age);
		request.put("experience", experience);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Cand", "doControl", request);
	}


}

