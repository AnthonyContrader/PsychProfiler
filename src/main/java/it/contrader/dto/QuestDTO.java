package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class QuestDTO {
	private Long id;

	private String args;
	private String quest;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;

}
