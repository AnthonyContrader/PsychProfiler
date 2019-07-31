package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CandDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CandService;


public class CandController implements Controller {
	/*
	 * Definisce il pacchetto di vista controller
	 * */
	private static String sub_pakage = "cand.";
	
	private CandService candservice;
	/**
	 * Costruisce un oggetto di tipo CandService per poterne usare i metodi
	 */
	public CandController() {
		this.candservice = new CandService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta del candidato.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int id;
		String name;
		String surname;
		int age;
		String experience;

		switch (mode) {
		
		// Arriva qui dalla CandReadView. Invoca il Service con il parametro id e invia alla CandReadView un candidato da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			CandDTO candDTO = candservice.read(id);
			request.put("cand", candDTO);
			MainDispatcher.getInstance().callView(sub_pakage + "CandRead", request);
			break;
		
		// Arriva qui dalla CandInsertView. Estrae i parametri da inserire e chiama il service per inserire un candidato con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			age = Integer.parseInt(request.get("age").toString());
			experience = request.get("experience").toString();
			
			//costruisce l'oggetto cand da inserire
			CandDTO candtoinsert = new CandDTO(name, surname, age,experience);
			//invoca il service
			candservice.insert(candtoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_pakage + "CandInsert", request);
			break;
		
		// Arriva qui dalla CandDeleteView. Estrae l'id del candidato da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			candservice.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_pakage + "CandDelete", request);
			break;
		
		// Arriva qui dalla CandUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			surname = request.get("surname").toString();
			age = Integer.parseInt(request.get("age").toString());
			experience = request.get("experience").toString();
			CandDTO candtoupdate = new CandDTO(name, surname, age,experience);
			candtoupdate.setId(id);
			candservice.update(candtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_pakage + "CandUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "CANDLIST":
			List<CandDTO> candsDTO = candservice.getAll();
			//Impacchetta la request con la lista dei candidati
			request.put("cands", candsDTO);
			MainDispatcher.getInstance().callView("Cand", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito del candidato e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_pakage + "CandRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_pakage + "CandInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_pakage + "CandUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_pakage + "CandDelete", null);
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



