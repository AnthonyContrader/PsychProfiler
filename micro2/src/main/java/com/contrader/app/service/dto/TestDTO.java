package com.contrader.app.service.dto;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.mapping.List;

public class TestDTO implements Serializable {
	

	ArrayList<QuestDTO> testo = new ArrayList<QuestDTO>();
	String user;
	public ArrayList<QuestDTO> getTesto() {
		return testo;
	}
	public void setTesto(ArrayList<QuestDTO> testo) {
		this.testo = testo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((testo == null) ? 0 : testo.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		TestDTO other = (TestDTO) obj;
		if (testo == null) {
			if (other.testo != null)
				return false;
		} else if (!testo.equals(other.testo))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TestDTO [testo=" + testo + ", user=" + user + "]";
	}
	
	
}
