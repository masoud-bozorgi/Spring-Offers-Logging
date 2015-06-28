package net.bozorgi.dao;

import javax.validation.constraints.Size;

public class Offers {

	private int id;
	private User user;

	@Size(min = 20, max = 255, message = "Text must be between 20 and 255 characters.")
	private String text;

	public Offers() {
		this.user = new User();
	}

	public Offers(User user, String text) {
		this.user = user;
		this.text = text;
	}

	public Offers(int id, User user, String text) {
		this.id = id;
		this.user = user;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Offers other = (Offers) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
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
		return "Offers [id=" + id + ", user=" + user + ", text=" + text + "]";
	}

}