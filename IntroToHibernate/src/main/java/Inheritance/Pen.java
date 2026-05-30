package Inheritance;

import javax.persistence.Entity;

@Entity
public class Pen extends MyProduct{
	
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
