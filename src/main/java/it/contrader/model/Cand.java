package it.contrader.model;

public class Cand {
	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id_cand;

	private String name;
	
	private String surname;
	
	private int age;
	
	private String experience;
	
	private int id_user;
	/**
	 * Definisco i due costruttori, uno vuoto e uno con 4 parametri per costrire oggetti di tipo Cand
	 * @param k 
	 * @param string3 
	 * @param j 
	 * @param string2 
	 * @param string 
	 * @param i 
	 */

	
	public Cand(int id_cand, String name, String surname, int age, String experience, int id_user) {
		super();
		this.id_cand = id_cand;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.experience = experience;
		this.id_user = id_user;
	}

	public Cand(String name, String surname, int age, String experience, int id_user) {
		super();

		this.name = name;
		this.surname = surname;
		this.age = age;
		this.experience = experience;
		this.id_user= id_user;
	}
	



	public int getId_cand() {
		return id_cand;
	}

	public void setId_cand(int id_cand) {
		this.id_cand = id_cand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	@Override
	public String toString() {
		return "Cand [id_cand=" + id_cand + ", name=" + name + ", surname=" + surname + ", age=" + age + ", experience="
				+ experience + ", id_user=" + id_user + "]";
	}




	

}
