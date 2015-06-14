package net.bozorgi.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.bozorgi.validation.ValidEmail;

public class Offers {

	private int id;
	
	@Size(min=10, max=100, message="size must be between 10 and 100")
	private String name;
	
	@NotNull
	//@Pattern(regexp=".*\\@.*\\..*", message="It does not appear to be a valid email address")
	@ValidEmail(min=6, message="This email address is not valid.")
	private String email;
	
	@Size(min=20, max=255, message="Text must be between 20 and 255 characters.")
	private String text;

	public Offers() {
	}
	
	public Offers(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}
	
	public Offers(int id, String name, String email, String text) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}

}