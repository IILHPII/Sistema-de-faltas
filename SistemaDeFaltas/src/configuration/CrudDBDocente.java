package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import model.Docente;
import model.Persona;
import repository.CrudRepository;

public class CrudDBDocente extends Docente implements CrudRepository {
	
	private boolean confirmacion;
	private String nombre;
	private int cedulaUsuario=55822124;
	
	public CrudDBDocente() {
		super();
	}
	
	
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
	
	
	public void altaAusencia() throws ParseException{
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			command.executeUpdate("INSERT INTO proyectoProgramacionDocentes.registra (ciD, ciU, fechaInicial, fechaFinal, nombreGrupo, motivo) VALUES('"+getCiD()+"', '"+getCiU()+"', '"+getFechaInicial()+"', '"+getFechaFinal()+"', '"+getGrupo()+"', '"+getMotivo()+"')");
			conexion.close();
		}catch(SQLException ex) {
			
		}
	}


}