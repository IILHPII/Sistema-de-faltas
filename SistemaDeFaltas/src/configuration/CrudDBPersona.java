package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Persona;
import repository.CrudRepository;

public class CrudDBPersona extends Persona implements CrudRepository{
	
	private static String nombre;
	
	public CrudDBPersona() {
		super();
	}
	
	
	@Override
	public boolean consulta() {
		return false;
	}

	@Override
	public void alta() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("INSERT INTO proyectoProgramacionDocentes.usuarios (ciU, nombre, tipo, password) VALUES('"+getCi()+"', '"+getNombre()+"', '"+getRol()+"', '"+getPassword()+"')");
			conexion.close();
			
		}catch(SQLException ex) {
			
		}
	}

	@Override
	public void modificacionNombreTipo() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("UPDATE proyectoProgramacionDocentes.usuarios SET nombre='"+getNombre()+"', tipo='"+getRol()+"' WHERE ciU='"+getCi()+"'");
			conexion.close();
		}catch(SQLException ex) {
			
		}
	}
	
	@Override
	public void modificacionPassword() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("UPDATE proyectoProgramacionDocentes.usuarios SET password='"+getPassword()+"' WHERE ciU='"+getCi()+"'");
			conexion.close();
		}catch(SQLException ex) {
			
		}
	}

	@Override
	public void eliminacion() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("DELETE FROM proyectoProgramacionDocentes.usuarios WHERE ciU='"+getCi()+"'");
			conexion.close();
		}catch(SQLException ex) {
			
		}
	}
	
	public String getNombreFromDB() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT nombre FROM proyectoProgramacionDocentes.usuarios where ciU='"+getCi()+"'");
			while(result.next()) {
				nombre=result.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;	
	}



}
