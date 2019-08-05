package it.contrader.model;

public class Test{
	private int id;
	private int idUser;
	private String quest1;
	private String ans1;
	private String quest2;
	private String ans2;
	private String quest3;
	private String ans3;
	private String quest4;
	private String ans4;
	private String quest5;
	private String ans5;
	public Test() {
		super();
	}
	public Test(int id, int idUser, String quest1, String ans1, String quest2, String ans2, String quest3, String ans3,
			String quest4, String ans4, String quest5, String ans5) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.quest1 = quest1;
		this.ans1 = ans1;
		this.quest2 = quest2;
		this.ans2 = ans2;
		this.quest3 = quest3;
		this.ans3 = ans3;
		this.quest4 = quest4;
		this.ans4 = ans4;
		this.quest5 = quest5;
		this.ans5 = ans5;
	}

	public Test(int idUser, String quest1, String ans1, String quest2, String ans2, String quest3, String ans3,
			String quest4, String ans4, String quest5, String ans5) {
		super();
		
		this.idUser = idUser;
		this.quest1 = quest1;
		this.ans1 = ans1;
		this.quest2 = quest2;
		this.ans2 = ans2;
		this.quest3 = quest3;
		this.ans3 = ans3;
		this.quest4 = quest4;
		this.ans4 = ans4;
		this.quest5 = quest5;
		this.ans5 = ans5;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getQuest1() {
		return quest1;
	}
	public void setQuest1(String quest1) {
		this.quest1 = quest1;
	}
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getQuest2() {
		return quest2;
	}
	public void setQuest2(String quest2) {
		this.quest2 = quest2;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getQuest3() {
		return quest3;
	}
	public void setQuest3(String quest3) {
		this.quest3 = quest3;
	}
	public String getAns3() {
		return ans3;
	}
	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}
	public String getQuest4() {
		return quest4;
	}
	public void setQuest4(String quest4) {
		this.quest4 = quest4;
	}
	public String getAns4() {
		return ans4;
	}
	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}
	public String getQuest5() {
		return quest5;
	}
	public void setQuest5(String quest5) {
		this.quest5 = quest5;
	}
	public String getAns5() {
		return ans5;
	}
	public void setAns5(String ans5) {
		this.ans5 = ans5;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", idUser=" + idUser + ", quest1=" + quest1 + ", ans1=" + ans1 + ", quest2=" + quest2
				+ ", ans2=" + ans2 + ", quest3=" + quest3 + ", ans3=" + ans3 + ", quest4=" + quest4 + ", ans4=" + ans4
				+ ", quest5=" + quest5 + ", ans5=" + ans5 + "]";
	}
	
	
}