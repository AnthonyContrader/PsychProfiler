package it.contrader.view.test;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TestUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String quest1;
	private String ans1;
	private String quest2;
	private String ans2;
	private String quest3;
	private String ans3;
	private String quest4;
	private String ans4;
	private String quest5;
	private String ans5;
	private String quest6;
	private String ans6;
	private String quest7;
	private String ans7;
	private String quest8;
	private String ans8;
	private String quest9;
	private String ans9;
	private String quest10;
	private String ans10;
	private int idUser;
	private final String mode = "UPDATE";

	public TestUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Test", null);
		}
	}

	/**
	 * Chiede al test di inserire gli attributi del test da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del test:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci domanda 1 del test:");
			quest1 = getInput();
			System.out.println("Inserisci risposta 1 del test:");
			ans1 = getInput();
			System.out.println("Inserisci domanda 2 del test:");
			quest2 = getInput();
			System.out.println("Inserisci risposta 2 del test:");
			ans2 = getInput();
			System.out.println("Inserisci domanda 3 del test:");
			quest3 = getInput();
			System.out.println("Inserisci risposta 3 del test:");
			ans3 = getInput();
			System.out.println("Inserisci domanda 4 del test:");
			quest4 = getInput();
			System.out.println("Inserisci risposta 4 del test:");
			ans4 = getInput();
			System.out.println("Inserisci domanda 5 del test:");
			quest5 = getInput();
			System.out.println("Inserisci risposta 5 del test:");
			ans5 = getInput();
			System.out.println("Inserisci domanda 6 del test:");
			quest6 = getInput();
			System.out.println("Inserisci risposta 6 del test:");
			ans6 = getInput();
			System.out.println("Inserisci domanda 7 del test:");
			quest7 = getInput();
			System.out.println("Inserisci risposta 7 del test:");
			ans7 = getInput();
			System.out.println("Inserisci domanda 8 del test:");
			quest8 = getInput();
			System.out.println("Inserisci risposta 8 del test:");
			ans8 = getInput();
			System.out.println("Inserisci domanda 9 del test:");
			quest9 = getInput();
			System.out.println("Inserisci risposta 9 del test:");
			ans9 = getInput();
			System.out.println("Inserisci domanda 10 del test:");
			quest10 = getInput();
			System.out.println("Inserisci risposta 10 del test:");
			ans10 = getInput();
			System.out.println("Inserisci idUser del test:");
			idUser = Integer.parseInt(getInput());
			
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
		request.put("quest1", quest1);
		request.put("ans1", ans1);
		request.put("quest2", quest2);
		request.put("ans2", ans2);
		request.put("quest3", quest3);
		request.put("ans3", ans3);
		request.put("quest4", quest4);
		request.put("ans4", ans4);
		request.put("quest5", quest5);
		request.put("ans5", ans5);
		request.put("quest6", quest6);
		request.put("ans6", ans6);
		request.put("quest7", quest7);
		request.put("ans7", ans7);
		request.put("quest8", quest8);
		request.put("ans8", ans8);
		request.put("quest9", quest9);
		request.put("ans9", ans9);
		request.put("quest10", quest10);
		request.put("ans10", ans10);
		request.put("idUser", idUser);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Test", "doControl", request);
	}

}

