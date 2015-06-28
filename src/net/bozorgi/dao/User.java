package net.bozorgi.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.bozorgi.validation.ValidEmail;

import org.hibernate.validator.constraints.NotBlank;

public class User {

	@NotBlank
	@Size(min = 8, max = 15)
	@Pattern(regexp = "^\\w{8,}$", message = "Username can only consist of numbers, letters and the underscire character.")
	private String username;

	@NotBlank
	@Pattern(regexp = "^\\S+$", message = "Space is not acceptable.")
	@Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters long.")
	private String password;

	private String authority;
	
	@NotBlank
	@Size(min = 8, max = 100)
	private String name;

	@ValidEmail(message = "It is not a valid Email address.")
	private String email;

	private boolean enabled = false;

	public User() {

	}

	public User(String username, String password, String name, String authority, String email, boolean enabled) {

		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", authority=" + authority + ", name=" + name + ", email=" + email + ", enabled=" + enabled + "]";
	}

}
