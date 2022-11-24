
package configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.*;
import repository.CrudRepository;


public class Conexion extends Persona implements CrudRepository{
		
		private static boolean confirmacionConsulta;
		private static boolean confirmacionFechaInit;
		private static int idGrupo;
		private static int codAsignatura;
		private List<String>listType;
		private List<String>listGroup;
		private List<String>listCourse;
		private List<String>listInitDate;
		
		
		
		public Conexion() {
			super();
			cargarDriver();
			listType=new ArrayList<String>();
			listGroup=new ArrayList<String>();
			listCourse=new ArrayList<String>();
			listInitDate=new ArrayList<String>();
		}		
				
		@Override
		public boolean consulta(){
			try {
				Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
				Statement command=conexion.createStatement();
				ResultSet result=command.executeQuery("SELECT ciU, password FROM proyectoProgramacionDocentes.usuarios where ciU='"+getCi()+"' and password='"+getPassword()+"'");
				if(result.next()==true) {
					confirmacionConsulta=true;
				}else {
					confirmacionConsulta=false;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			return confirmacionConsulta;
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
		
		
		// Lleno los comboBox
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
		
		
		
		
		
		private void cargarDriver() {
		    try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		    }catch(Exception ex) {
		      
		    }
		  }		
		
		
			
		
		
		
		
		
							
}

