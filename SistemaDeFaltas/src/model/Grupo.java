package model;

public class Grupo {
	
	private String nombre;
	private int anio;
	
	
	public Grupo() {
		
	}
	
	public Grupo(String nombre,int anio) {
		this.nombre=nombre;
		this.anio=anio;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setAnio(int anio) {
		this.anio=anio;
	}
	
	public int getAnio() {
		return this.anio;
	}
	

}
