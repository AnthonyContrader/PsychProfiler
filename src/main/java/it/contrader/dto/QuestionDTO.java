package it.contrader.dto;

public class QuestionDTO {
	private int id;
	private String args;
	private String quest;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	public QuestionDTO() {
		super();
	}
	public QuestionDTO(int id, String args, String quest, String ans1, String ans2, String ans3, String ans4) {
		super();
		this.id = id;
		this.args = args;
		this.quest = quest;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
	}
	public QuestionDTO(String args, String quest, String ans1, String ans2, String ans3, String ans4) {
		super();
		this.args = args;
		this.quest = quest;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
		this.ans4 = ans4;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	public String getQuest() {
		return quest;
	}
	public void setQuest(String quest) {
		this.quest = quest;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	@Override
	public String toString() {
		return "QuestionDTO [id=" + id + ", args=" + args + ", quest=" + quest + ", ans1=" + ans1 + ", ans2=" + ans2
				+ ", ans3=" + ans3 + ", ans4=" + ans4 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ans1 == null) ? 0 : ans1.hashCode());
		result = prime * result + ((ans2 == null) ? 0 : ans2.hashCode());
		result = prime * result + ((ans3 == null) ? 0 : ans3.hashCode());
		result = prime * result + ((ans4 == null) ? 0 : ans4.hashCode());
		result = prime * result + ((args == null) ? 0 : args.hashCode());
		result = prime * result + id;
		result = prime * result + ((quest == null) ? 0 : quest.hashCode());
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
		QuestionDTO other = (QuestionDTO) obj;
		if (ans1 == null) {
			if (other.ans1 != null)
				return false;
		} else if (!ans1.equals(other.ans1))
			return false;
		if (ans2 == null) {
			if (other.ans2 != null)
				return false;
		} else if (!ans2.equals(other.ans2))
			return false;
		if (ans3 == null) {
			if (other.ans3 != null)
				return false;
		} else if (!ans3.equals(other.ans3))
			return false;
		if (ans4 == null) {
			if (other.ans4 != null)
				return false;
		} else if (!ans4.equals(other.ans4))
			return false;
		if (args == null) {
			if (other.args != null)
				return false;
		} else if (!args.equals(other.args))
			return false;
		if (id != other.id)
			return false;
		if (quest == null) {
			if (other.quest != null)
				return false;
		} else if (!quest.equals(other.quest))
			return false;
		return true;
	}
	

}
