package it.contrader.dto;

public class TestDTO {
	
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
	private String quest6;
	private String ans6;
	private String quest7;
	private String ans7;
	private String quest8;
	private String ans8;
	private String quest9;
	private String ans9;
	private String quest10;
	private String ans10;
	private int id;
	private int idUser;
	public TestDTO(String quest1, String ans1, String quest2, String ans2, String quest3, String ans3, String quest4,
			String ans4, String quest5, String ans5, String quest6, String ans6, String quest7, String ans7,
			String quest8, String ans8, String quest9, String ans9, String quest10, String ans10, int id, int idUser) {
		super();
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
		this.quest6 = quest6;
		this.ans6 = ans6;
		this.quest7 = quest7;
		this.ans7 = ans7;
		this.quest8 = quest8;
		this.ans8 = ans8;
		this.quest9 = quest9;
		this.ans9 = ans9;
		this.quest10 = quest10;
		this.ans10 = ans10;
		this.id = id;
		this.idUser = idUser;
	}
	public TestDTO(String quest1, String ans1, String quest2, String ans2, String quest3, String ans3, String quest4,
			String ans4, String quest5, String ans5, String quest6, String ans6, String quest7, String ans7,
			String quest8, String ans8, String quest9, String ans9, String quest10, String ans10, int id) {
		super();
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
		this.quest6 = quest6;
		this.ans6 = ans6;
		this.quest7 = quest7;
		this.ans7 = ans7;
		this.quest8 = quest8;
		this.ans8 = ans8;
		this.quest9 = quest9;
		this.ans9 = ans9;
		this.quest10 = quest10;
		this.ans10 = ans10;
		this.idUser = idUser;
	}
	public TestDTO() {
		super();
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
	public String getQuest6() {
		return quest6;
	}
	public void setQuest6(String quest6) {
		this.quest6 = quest6;
	}
	public String getAns6() {
		return ans6;
	}
	public void setAns6(String ans6) {
		this.ans6 = ans6;
	}
	public String getQuest7() {
		return quest7;
	}
	public void setQuest7(String quest7) {
		this.quest7 = quest7;
	}
	public String getAns7() {
		return ans7;
	}
	public void setAns7(String ans7) {
		this.ans7 = ans7;
	}
	public String getQuest8() {
		return quest8;
	}
	public void setQuest8(String quest8) {
		this.quest8 = quest8;
	}
	public String getAns8() {
		return ans8;
	}
	public void setAns8(String ans8) {
		this.ans8 = ans8;
	}
	public String getQuest9() {
		return quest9;
	}
	public void setQuest9(String quest9) {
		this.quest9 = quest9;
	}
	public String getAns9() {
		return ans9;
	}
	public void setAns9(String ans9) {
		this.ans9 = ans9;
	}
	public String getQuest10() {
		return quest10;
	}
	public void setQuest10(String quest10) {
		this.quest10 = quest10;
	}
	public String getAns10() {
		return ans10;
	}
	public void setAns10(String ans10) {
		this.ans10 = ans10;
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
	@Override
	public String toString() {
		return "TestDTO [quest1=" + quest1 + ", ans1=" + ans1 + ", quest2=" + quest2 + ", ans2=" + ans2 + ", quest3="
				+ quest3 + ", ans3=" + ans3 + ", quest4=" + quest4 + ", ans4=" + ans4 + ", quest5=" + quest5 + ", ans5="
				+ ans5 + ", quest6=" + quest6 + ", ans6=" + ans6 + ", quest7=" + quest7 + ", ans7=" + ans7 + ", quest8="
				+ quest8 + ", ans8=" + ans8 + ", quest9=" + quest9 + ", ans9=" + ans9 + ", quest10=" + quest10
				+ ", ans10=" + ans10 + ", id=" + id + ", idUser=" + idUser + "]";
	}

}
