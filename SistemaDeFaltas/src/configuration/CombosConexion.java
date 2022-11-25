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
	private List<String>listGroup;
	private List<String>listCourse;
	private List<String>listInitDate;
	private List<String>listNombres;
	
	
	public CombosConexion() {
		listType=new ArrayList<String>();
		listGroup=new ArrayList<String>();
		listCourse=new ArrayList<String>();
		listInitDate=new ArrayList<String>();
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
	
	public List<String> llenarComboGrupo() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT nombre FROM proyectoListaDB.grupo");
			
			while(result.next()) {
				listGroup.add(result.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listGroup;	
	}
	
	
	public List<String> llenarComboAsignatura() {
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			Statement command=conexion.createStatement();
			ResultSet result=command.executeQuery("SELECT nombre FROM proyectoListaDB.asignatura");
			while(result.next()) {
				listCourse.add(result.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCourse;	
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
