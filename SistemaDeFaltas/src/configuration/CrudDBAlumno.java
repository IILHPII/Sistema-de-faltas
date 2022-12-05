package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Alumno;
import repository.CrudRepository;

public class CrudDBAlumno extends Alumno implements CrudRepository {
	
	private boolean confirmacion;
	private String nombre;
	
	
	@Override
	public boolean consulta() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT cedula, grupo FROM proyectoProgramacionDocentes.alumnos where cedula='"+getCedula()+"';");
			if(result.next()==true) {
				confirmacion=true;
			}else {
				confirmacion=false;
			}
			conexion.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}			
		return confirmacion;
	}

	@Override
	public void alta() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("INSERT INTO proyectoProgramacionDocentes.alumnos (cedula, grupo) VALUES('"+getCedula()+"', '"+getGrupo()+"');");
			conexion.close();
		}catch(SQLException ex) {
			
		}
	}

	@Override
	public void modificacionNombreTipo() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("UPDATE proyectoProgramacionDocentes.alumnos SET grupo='"+getGrupo()+"'  WHERE cedula='"+getCedula()+"'");
			conexion.close();		
		}catch(SQLException ex) {
			
		}
	}

	@Override
	public void modificacionPassword() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminacion() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("DELETE FROM proyectoProgramacionDocentes.alumnos WHERE cedula='"+getCedula()+"';");
			conexion.close();
		}catch(SQLException ex) {
			
		}
	}

	@Override
	public String getNombreFromDB() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT cedula FROM proyectoProgramacionDocentes.alumnos where cedula='"+getCedula()+"'");
			while(result.next()) {
				nombre=result.getString(1);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;	
	}
	
	
	public String getGrupoFromDB() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT grupo FROM proyectoProgramacionDocentes.alumnos where cedula='"+getCedula()+"'");
			while(result.next()) {
				nombre=result.getString(1);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;	
	}

}
