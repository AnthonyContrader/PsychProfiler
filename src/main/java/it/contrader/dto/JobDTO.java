package it.contrader.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobDTO {
	private Long id;
	
    private String name;
	
	private String description;

}
