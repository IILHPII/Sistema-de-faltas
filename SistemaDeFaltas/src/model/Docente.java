package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Docente {
	
	private int ciD;
	private int ciU;
	private String nombre;
	private String fechaInicial;
	private String fechaFinal;
	private String motivo;
	private String grupo;

	
	
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
	
	public void setFechaInicial(String fechaInicial){
		this.fechaInicial=fechaInicial;
	}
	
	public Date getFechaInicial() throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsed= formatter.parse(this.fechaInicial);
	    java.sql.Date fechaInicialSql=new java.sql.Date(parsed.getTime());
	    return fechaInicialSql;
	}
	
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal=fechaFinal;
	}
	
	public Date getFechaFinal() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsed= formatter.parse(this.fechaFinal);
	    java.sql.Date fechaFinalSql=new java.sql.Date(parsed.getTime());
		return fechaFinalSql;
	}
	
	public void setMotivo(String motivo) {
		this.motivo=motivo;
	}
	
	public String getMotivo() {
		return this.motivo;
	}
	
	public void setGrupo(String grupo) {
		this.grupo=grupo;
	}
	
	public String getGrupo() {
		return this.grupo;
	}
	
	public void setCiU(int ciU) {
		this.ciU=ciU;
	}
	
	public int getCiU() {
		return this.ciU;
	}
	
}
