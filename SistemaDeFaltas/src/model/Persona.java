package model;

abstract public class Persona {
	
	private int user;
	private String password;
	private Persona type;
	
	public Persona() {
		
	}
	
	public Persona(int user,String password) {
		this.user=user;
		this.password=password;
	}
	
	public int getUser() {
		return this.user;
	}
	
	public void setUser(int user) {
		this.user=user;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public void setType(Persona type) {
		this.type=type;
	}
	
	public Persona getType() {
		return this.type;
	}
	
}

