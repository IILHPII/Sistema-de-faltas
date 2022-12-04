
package configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.*;
import repository.CrudRepository;


public class Conexion extends Usuario implements CrudRepository{
		
		private static boolean confirmacionConsulta;
		private static boolean confirmacionFechaInit;
	
		
		public Conexion() {
			super();
			cargarDriver();
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
				e1.printStackTrace();
			}			
			return confirmacionConsulta;
		}
		
		
		public boolean consultaCiU(){
			try {
				Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
				Statement command=conexion.createStatement();
				ResultSet result=command.executeQuery("SELECT ciU FROM proyectoProgramacionDocentes.usuarios where ciU='"+getCi()+"'");
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
		
		
		public boolean consultaCiURegistro(int ci){
			try {
				Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
				Statement command=conexion.createStatement();
				ResultSet result=command.executeQuery("SELECT ciU FROM proyectoProgramacionDocentes.usuarios where ciU='"+ci+"'");
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
			
		}
		
		@Override
		public void modificacionNombreTipo() {
			
		}
		
		@Override
		public void eliminacion() {
		
		}
		
			
		
		private void cargarDriver() {
		    try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		    }catch(Exception ex) {
		      
		    }
		  }

		@Override
		public void modificacionPassword() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getNombreFromDB() {
			// TODO Auto-generated method stub
			return null;
		}			
							
}

