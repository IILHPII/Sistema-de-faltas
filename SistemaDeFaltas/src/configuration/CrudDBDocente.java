package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Docente;
import repository.CrudRepository;

public class CrudDBDocente extends Docente implements CrudRepository {

	@Override
	public boolean consulta() {
		return false;
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

}
