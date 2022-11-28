package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Docente;
import repository.CrudRepository;

public class CrudDBDocente extends Docente implements CrudRepository {
	
	private boolean confirmacion;
	private String nombre;
	
	@Override
	public boolean consulta() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT ciD, nombre FROM proyectoProgramacionDocentes.docente where ciD='"+getCiD()+"'");
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
			command.executeUpdate("INSERT INTO proyectoProgramacionDocentes.docente (ciD, nombre) VALUES('"+getCiD()+"', '"+getNombre()+"')");
			conexion.close();
		}catch(SQLException ex) {
			
		}
	}

	@Override
	public void modificacionNombreTipo() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("UPDATE proyectoProgramacionDocentes.docente SET nombre='"+getNombre()+"' WHERE ciD='"+getCiD()+"'");
		}catch(SQLException ex) {
			
		}
		
	}


	@Override
	public void eliminacion() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("DELETE FROM proyectoProgramacionDocentes.docente WHERE ciD='"+getCiD()+"'");
			conexion.close();
		}catch(SQLException ex) {
			
		}
		
	}
	
	@Override
	public void modificacionPassword() {
		// TODO Auto-generated method stub
		
	}
	
	public String consultaPorNombre() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT nombre FROM proyectoProgramacionDocentes.docente where ciD='"+getCiD()+"'");
			while(result.next()) {
				nombre=result.getString(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		return nombre;
	}


}
