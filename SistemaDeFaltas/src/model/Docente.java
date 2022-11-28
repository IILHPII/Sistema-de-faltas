package model;

public class Docente {
	
	private int ciD;
	private String nombre;
	
	public Docente() {
		
	}
	
	public Docente(int ciD,String nombre) {
		this.ciD=ciD;
		this.nombre=nombre;
	}
	
	public void setCiD(int ciD) {
		this.ciD=ciD;
	}
	
	public int getCiD() {
		return this.ciD;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}
