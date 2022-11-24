package model;

 public class Persona {
	
	private int ci;
	private String contraseña;
	private String nombre;
	private String rol;
	
	public Persona() {
		
	}
	
	public Persona(int ci,String nombre,String rol,String contraseña) {
		this.ci=ci;
		this.nombre=nombre;
		this.rol=rol;
		this.contraseña=contraseña;
	}
	
	public int getCi() {
		return this.ci;
	}
	
	public void setCi(int user) {
		this.ci=user;
	}
	
	public String getPassword() {
		return this.contraseña;
	}
	
	public void setPassword(String password) {
		this.contraseña=password;
	}
	
	public void setRol(String rol) {
		this.rol=rol;
	}
	
	public String getRol() {
		return this.rol;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}

