package it.contrader.dto;

import java.util.Set;

import it.contrader.model.Cand;
import it.contrader.model.Quest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
	private Long id;
	private Cand cand;
	Set<Quest> likedQuests;
	private int ans;
	

}
