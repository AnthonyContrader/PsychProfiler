package it.contrader.model;

public class Cand {
	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;

	private String name;
	
	private String surname;
	
	private int age;
	
	private String experience;
	/**
	 * Definisco i due costruttori, uno vuoto e uno con 4 parametri per costrire oggetti di tipo Cand
	 */
	public Cand() {
		super();
	}
	
	public Cand(int id, String name, String surname, int age, String experience) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.experience = experience;
	}

	public Cand(String name, String surname, int age, String experience) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Cand [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", experience="
				+ experience + "]";
	}
	


	

}
