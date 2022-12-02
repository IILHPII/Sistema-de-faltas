package model;

public class Alumno {
	
	private int cedula;
	private String grupo;
	
	public Alumno() {
		
	}
	
	public Alumno(int cedul,String grupo) {
		
	}
	
	public void setCedula(int cedula) {
		this.cedula=cedula;
	}
	
	public int getCedula() {
		return this.cedula;
	}
	
	public void setGrupo(String grupo) {
		this.grupo=grupo;
	}
	
	public String getGrupo() {
		return this.grupo;
	}
	

}
