package it.contrader.dto;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandDTO {
	private Long id;
    
	private String name;
	
	private String surname;
	
	private int age;
	
	private String experience;
	
	private User user;


}
