package week2.model;

import java.io.Serializable;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String images;

	public UserModel() {
		super();
	}

	public UserModel(int id, String username, String password, String fullname, String email, String images) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ",  password=" + password + ", fullname=" + fullname
				+ ",email=" + email + ", images=" + images + "]";
	}

}
