package it.contrader.view.test;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TestInsertView extends AbstractView{
	private Request request;
	private int idUser ;
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
	private final String mode = "INSERT";

	public TestInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Test", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del test da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci IdUser del test:");
			idUser = Integer.parseInt(getInput());
			System.out.println("Inserisci la domanda 1:");
			quest1 = getInput();
			System.out.println("Inserisci risposta 1:");
			ans1 = getInput();
			System.out.println("Inserisci la domanda 2:");
			quest2 = getInput();
			System.out.println("Inserisci risposta 2:");
			ans2 = getInput();
			System.out.println("Inserisci la domanda 3:");
			quest3 = getInput();
			System.out.println("Inserisci risposta 3:");
			ans3 = getInput();
			System.out.println("Inserisci la domanda 4:");
			quest4 = getInput();
			System.out.println("Inserisci risposta 4:");
			ans4 = getInput();
			System.out.println("Inserisci la domanda 5:");
			quest5 = getInput();
			System.out.println("Inserisci risposta 5:");
			ans5 = getInput();


			
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idUser", idUser);
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
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Test", "doControl", request);
	}


}

