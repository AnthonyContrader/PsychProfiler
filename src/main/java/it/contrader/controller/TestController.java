package it.contrader.controller;

import java.util.List;

import it.contrader.dto.TestDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.TestService;

public class TestController implements Controller {
	/*
	 * Definisce il pacchetto di vista controller
	 */
	private static String sub_pakage = "test.";

	private TestService testservice;

	/**
	 * Costruisce un oggetto di tipo TestService per poterne usare i metodi
	 */
	public TestController() {
		this.testservice = new TestService();
	}

	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode (che riceve
	 * dalle view specifiche e può essere la richesta di una scelta da parte
	 * dell'utente "GETCHOICE") e la scelta del test.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {

		// Estrae dalla request mode e choice
		String mode = (String) request.get("mode");

		String choice = (String) request.get("choice");

		// Definisce i campi della classe (serviranno sempre, tanto vale definirli una
		// sola volta)
		int id;
		String quest1;
		String ans1;
		String quest2;
		String ans2;
		String quest3;
		String ans3;
		String quest4;
		String ans4;
		String quest5;
		String ans5;
		String quest6;
		String ans6;
		String quest7;
		String ans7;
		String quest8;
		String ans8;
		String quest9;
		String ans9;
		String quest10;
		String ans10;
		int idUser;

		switch (mode) {

		// Arriva qui dalla TestReadView. Invoca il Service con il parametro id e invia
		// alla TestReadView un test da mostrare
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			TestDTO testDTO = testservice.read(id);
			request.put("test", testDTO);
			MainDispatcher.getInstance().callView(sub_pakage + "TestRead", request);
			break;

		// Arriva qui dalla TestInsertView. Estrae i parametri da inserire e chiama il
		// service per inserire un test con questi parametri
		case "INSERT":
			quest1 = request.get("quest").toString();
			ans1 = request.get("ans").toString();
			quest2 = request.get("quest").toString();
			ans2 = request.get("ans").toString();
			quest3 = request.get("quest").toString();
			ans3 = request.get("ans").toString();
			quest4 = request.get("quest").toString();
			ans4 = request.get("ans").toString();
			quest5 = request.get("quest").toString();
			ans5 = request.get("ans").toString();
			quest6 = request.get("quest").toString();
			ans6 = request.get("ans").toString();
			quest7 = request.get("quest").toString();
			ans7 = request.get("ans").toString();
			quest8 = request.get("quest").toString();
			ans8 = request.get("ans").toString();
			quest9 = request.get("quest").toString();
			ans9 = request.get("ans").toString();
			quest10 = request.get("quest").toString();
			ans10 = request.get("ans").toString();
			idUser = Integer.parseInt(request.get("idUser").toString());

			// costruisce l'oggetto test da inserire
			TestDTO testtoinsert = new TestDTO(quest1, ans1, quest2, ans2, quest3, ans3, quest4, ans4, quest5, ans5,
					quest6, ans6, quest7, ans7, quest8, ans8, quest9, ans9, quest10, ans10, idUser);
			// invoca il service
			testservice.insert(testtoinsert);
			request = new Request();
			request.put("mode", "mode");
			// Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_pakage + "TestInsert", request);
			break;

		// Arriva qui dalla TestDeleteView. Estrae l'id del test da cancellare e lo
		// passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			// Qui chiama il service
			testservice.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_pakage + "TestDelete", request);
			break;

		// Arriva qui dalla TestUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			quest1 = request.get("ans1").toString();
			ans1 = request.get("ans1").toString();
			quest2 = request.get("ans1").toString();
			ans2 = request.get("ans1").toString();
			quest3 = request.get("ans1").toString();
			ans3 = request.get("ans1").toString();
			quest4 = request.get("ans1").toString();
			ans4 = request.get("ans1").toString();
			quest5 = request.get("ans1").toString();
			ans5 = request.get("ans1").toString();
			quest6 = request.get("ans1").toString();
			ans6 = request.get("ans1").toString();
			quest7 = request.get("ans1").toString();
			ans7 = request.get("ans1").toString();
			quest8 = request.get("ans1").toString();
			ans8 = request.get("ans1").toString();
			quest9 = request.get("ans1").toString();
			ans9 = request.get("ans1").toString();
			quest10 = request.get("ans1").toString();
			ans10 = request.get("ans1").toString();
			TestDTO testtoupdate = new TestDTO();
			testtoupdate.setId(id);
			testservice.update(testtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_pakage + "TestUpdate", request);
			break;

		// Arriva qui dalla UserView Invoca il Service e invia alla UserView il
		// risultato da mostrare
		case "TESTLIST":
			List<TestDTO> testsDTO = testservice.getAll();
			// Impacchetta la request con la lista dei test
			request.put("tests", testsDTO);
			MainDispatcher.getInstance().callView("Test", request);
			break;

		// Esegue uno switch sulla base del comando inserito del test e reindirizza
		// tramite il Dispatcher alla View specifica per ogni operazione
		// con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":

			// toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {

			case "L":
				MainDispatcher.getInstance().callView(sub_pakage + "TestRead", null);
				break;

			case "I":
				MainDispatcher.getInstance().callView(sub_pakage + "TestInsert", null);
				break;

			case "M":
				MainDispatcher.getInstance().callView(sub_pakage + "TestUpdate", null);
				break;

			case "C":
				MainDispatcher.getInstance().callView(sub_pakage + "TestDelete", null);
				break;

			case "Q":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;

			default:
				MainDispatcher.getInstance().callView("Login", null);
			}

		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
