
package configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.*;
import repository.CrudRepository;


public class Conexion extends Persona implements CrudRepository{
		
		private static boolean confirmacionConsulta;
		
		private List<String>listType;
		
		public Conexion() {
			cargarDriver();
			listType=new ArrayList<String>();
		}		
				
		@Override
		public boolean consulta(){
			try {
				Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
				Statement command=conexion.createStatement();
				ResultSet result=command.executeQuery("SELECT ci, contraseña, `rol` FROM proyectoListaDB.persona where ci='"+getCi()+"' and contraseña='"+getPassword()+"'");
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
		public void alta(int ci,String nombre,String rol,String password) {
			try {
				Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
				Statement command=conexion.createStatement();
				command.executeUpdate("INSERT INTO proyectoListaDB.persona (ci, nombre, rol, contraseña) "
						+ "VALUES("+ci+", '"+nombre+"', '"+rol+"', '"+password+"')");
				conexion.close();
				
			}catch(SQLException ex) {
				
			}
		}
		
		
		public List<String> llenarCombo() {
			try {
				Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
				Statement command=conexion.createStatement();
				ResultSet result=command.executeQuery("SELECT rol_persona FROM proyectoListaDB.rol");
				
				while(result.next()) {
					listType.add(result.getString(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listType;	
		}
		
		
		
		private void cargarDriver() {
		    try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		    }catch(Exception ex) {
		      
		    }
		  }		
		
		
			
		
		
		
		
		
							
}

