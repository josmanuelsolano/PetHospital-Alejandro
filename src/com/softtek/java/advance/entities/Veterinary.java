package com.softtek.java.advance.entities;

public class Veterinary {
	
	private int veterinaryId;
	private String name;
	private String lastname;
	private String schoolCard;
	
	public Veterinary() {
		
	}
	public int getVeterinaryId() {
		return veterinaryId;
	}
	public void setVeterinaryId(int veterinaryId) {
		this.veterinaryId = veterinaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSchoolCard() {
		return schoolCard;
	}
	public void setSchoolCard(String schoolCard) {
		this.schoolCard = schoolCard;
	}
	@Override
	public String toString() {
		return veterinaryId +" [Id=" + veterinaryId + ", Name = " + name + ", Last name = " + lastname + ", School Card=" + schoolCard + "]";
	}
	
	
	
	
}
