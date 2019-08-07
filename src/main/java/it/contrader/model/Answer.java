package it.contrader.model;

public class Answer {
	
	private int id_ans;
	private int id_cand;
	private int id_quest;
	private int ans;
	public Answer() {
		super();
	}
	
	public Answer(int id_ans, int id_cand, int id_quest, int ans) {
		super();
		this.id_ans = id_ans;
		this.id_cand = id_cand;
		this.id_quest = id_quest;
		this.ans = ans;
	}

	public Answer(int id_cand, int id_quest, int ans) {
		super();
		this.id_cand = id_cand;
		this.id_quest = id_quest;
		this.ans = ans;
	}

	public int getId_ans() {
		return id_ans;
	}
	public void setId_ans(int id_ans) {
		this.id_ans = id_ans;
	}
	public int getId_cand() {
		return id_cand;
	}
	public void setId_cand(int id_cand) {
		this.id_cand = id_cand;
	}
	public int getId_quest() {
		return id_quest;
	}
	public void setId_quest(int id_quest) {
		this.id_quest = id_quest;
	}
	public int getAns() {
		return ans;
	}
	public void setAns(int ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "Answer [id_ans=" + id_ans + ", id_cand=" + id_cand + ", id_quest=" + id_quest + ", ans=" + ans + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ans;
		result = prime * result + id_ans;
		result = prime * result + id_cand;
		result = prime * result + id_quest;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (ans != other.ans)
			return false;
		if (id_ans != other.id_ans)
			return false;
		if (id_cand != other.id_cand)
			return false;
		if (id_quest != other.id_quest)
			return false;
		return true;
	}
	
	
	

}
