package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Persona;
import repository.CrudRepository;

public class CrudDB extends Persona implements CrudRepository{

	public CrudDB() {
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
	public void modificacion() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("UPDATE proyectoProgramacionDocentes.usuarios SET nombre='"+getNombre()+"', tipo='"+getRol()+"' WHERE ciU='"+getCi()+"'");
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

}
