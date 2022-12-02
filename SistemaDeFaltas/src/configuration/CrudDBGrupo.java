package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Grupo;
import repository.CrudRepository;

public class CrudDBGrupo extends Grupo implements CrudRepository {
	
	private static boolean confirmacion;

	@Override
	public boolean consulta() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT nombre, anio FROM proyectoProgramacionDocentes.grupos where nombre='"+getNombre()+"';");
			if(result.next()==true) {
				confirmacion=true;
			}else {
				confirmacion=false;
			}
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
			command.executeUpdate("INSERT INTO proyectoProgramacionDocentes.grupos (nombre, anio) VALUES('"+getNombre()+"', '"+getAnio()+"');");
			conexion.close();
			
		}catch(SQLException ex) {
			
		}
	}

	@Override
	public void modificacionNombreTipo() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("UPDATE proyectoProgramacionDocentes.grupos SET anio='"+getAnio()+"' WHERE nombre='"+getNombre()+"';");
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
			command.executeUpdate("DELETE FROM proyectoProgramacionDocentes.grupos WHERE nombre='"+getNombre()+"';");
			conexion.close();		
		}catch(SQLException ex) {
			
		}
	}

	@Override
	public String getNombreFromDB() {
		// TODO Auto-generated method stub
		return null;
	}

}
