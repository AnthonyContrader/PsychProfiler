package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.TestDTO;
import it.contrader.main.MainDispatcher;

public class TestView  extends AbstractView {

	private Request request;
	private String choice;

	public TestView() {
		
	}

	/**
	 * Mostra la lista test
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Test ----------------\n");
			System.out.println("ID\tdomanda1\trisposta1\tdomanda2\trisposta2\tdomanda3\trisposta3\tdomanda4\trisposta4\tdomanda5\trisposta5\tdomanda6\trisposta6\tdomanda7\trisposta7\tdomanda8\trisposta8\tdomanda9\trisposta9\tdomanda10\trisposta10");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<TestDTO> tests = (List<TestDTO>) request.get("tests");
			for (TestDTO c: tests)
				System.out.println(c);
			System.out.println();
		}
	}

	/**
	 * Chiede al test un input (lettera da tastiera) per la choice (vedi TestController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo TestController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Test", "doControl", this.request);
	}

}

