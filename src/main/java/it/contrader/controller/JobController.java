package it.contrader.controller;

import java.util.List;

import it.contrader.dto.JobDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.JobService;



public class JobController implements Controller {

	/**
	 * definisce il pacchetto di vista job.
	 */
	private static String sub_package = "job.";
	
	private JobService jobService;
	/**
	 * Costruisce un oggetto di tipo UserService per poterne usare i metodi
	 */
	public JobController() {
		this.jobService = new JobService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
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
		String description;

		switch (mode) {
		
		// Arriva qui dalla JobReadView. Invoca il Service con il parametro id e invia alla JobReadView un job da mostrare 
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			JobDTO jobDTO = jobService.read(id);
			request.put("job", jobDTO);
			MainDispatcher.getInstance().callView(sub_package + "JobRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			description = request.get("description").toString();
			
			//costruisce l'oggetto job da inserire
			JobDTO jobtoinsert = new JobDTO(name, description);
			//invoca il service
			jobService.insert(jobtoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "JobInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			//Qui chiama il service
			jobService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "JobDelete", request);
			break;
		
		// Arriva qui dalla JobUpdateView
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			description = request.get("description").toString();
			JobDTO jobtoupdate = new JobDTO(name, description);
			jobtoupdate.setId(id);
			jobService.update(jobtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "JobUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "JOBLIST":
			List<JobDTO> jobsDTO = jobService.getAll();
			//Impacchetta la request con la lista degli user
			request.put("jobs", jobsDTO);
			MainDispatcher.getInstance().callView("Job", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "JobRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "JobInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "JobUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "JobDelete", null);
				break;
				
			case "E":
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

