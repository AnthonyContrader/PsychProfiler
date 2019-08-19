package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Answer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Cand cand;
	
	@ManyToOne
	private Quest quest;
	
	private int ans;
	
}
