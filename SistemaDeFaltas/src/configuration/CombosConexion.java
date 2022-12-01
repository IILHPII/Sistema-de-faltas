package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import repository.CrudRepository;

public class CombosConexion implements CrudRepository {
	
	
	private static int idGrupo;
	private static int codAsignatura;
	private List<String>listType;
	private List<String>listGrupos;
	
	
	public CombosConexion() {
		listType=new ArrayList<String>();
		listGrupos=new ArrayList<String>();
	}
	
	
	public List<String> llenarCombo() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT tipo FROM proyectoProgramacionDocentes.tipos");
			
			while(result.next()) {
				listType.add(result.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listType;	
	}
	
	
	public List<String> llenarComboGrupos() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT nombre FROM proyectoProgramacionDocentes.grupos");
			
			while(result.next()) {
				listGrupos.add(result.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listGrupos;	
	}
	
	
	public List<String> llenarComboConsulta() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT nombre FROM proyectoProgramacionDocentes.grupos");
			
			while(result.next()) {
				listGrupos.add(result.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listGrupos;	
	}
	

	@Override
	public boolean consulta() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void alta() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificacionNombreTipo() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminacion() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificacionPassword() {
		// TODO Auto-generated method stub
		
	}
	

}
