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

	private TestService testService;

	/**
	 * Costruisce un oggetto di tipo TestService per poterne usare i metodi
	 */
	public TestController() {
		this.testService = new TestService();
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
		int idUser;
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


		switch (mode) {

		// Arriva qui dalla TestReadView. Invoca il Service con il parametro id e invia
		// alla TestReadView un test da mostrare
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			TestDTO testDTO = testService.read(id);
			request.put("test", testDTO);
			MainDispatcher.getInstance().callView(sub_pakage + "TestRead", request);
			break;

		// Arriva qui dalla TestInsertView. Estrae i parametri da inserire e chiama il
		// service per inserire un test con questi parametri
		case "INSERT":
			idUser = Integer.parseInt(request.get("idUser").toString());
			quest1 = request.get("quest1").toString();
			ans1 = request.get("ans1").toString();
			quest2 = request.get("quest2").toString();
			ans2 = request.get("ans2").toString();
			quest3 = request.get("quest3").toString();
			ans3 = request.get("ans3").toString();
			quest4 = request.get("quest4").toString();
			ans4 = request.get("ans4").toString();
			quest5 = request.get("quest5").toString();
			ans5 = request.get("ans5").toString();


			// costruisce l'oggetto test da inserire
			TestDTO testtoinsert = new TestDTO(idUser,quest1, ans1, quest2, ans2, quest3, ans3, quest4, ans4, quest5, ans5);
			// invoca il service
			testService.insert(testtoinsert);
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
			testService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_pakage + "TestDelete", request);
			break;

		// Arriva qui dalla TestUpdateView
		case "UPDATE":
			id= Integer.parseInt(request.getString("id").toString());
			idUser = Integer.parseInt(request.get("idUser").toString());
			quest1 = request.get("quest1").toString();
			ans1 = request.get("ans1").toString();
			quest2 = request.get("quest2").toString();
			ans2 = request.get("ans2").toString();
			quest3 = request.get("quest3").toString();
			ans3 = request.get("ans3").toString();
			quest4 = request.get("quest4").toString();
			ans4 = request.get("ans4").toString();
			quest5 = request.get("quest5").toString();
			ans5 = request.get("ans5").toString();
			TestDTO testtoupdate = new TestDTO(idUser, quest1, ans1, quest2, ans2, quest3,ans3, quest4,ans4,quest5,ans5);
			testtoupdate.setId(id);
			testService.update(testtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_pakage + "TestUpdate", request);
			break;

		// Arriva qui dalla UserView Invoca il Service e invia alla UserView il
		// risultato da mostrare
		case "TESTLIST":
			List<TestDTO> testsDTO = testService.getAll();
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
