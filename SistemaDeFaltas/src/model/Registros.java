package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import repository.CrudRepository;

public class Registros implements CrudRepository {
	
	private String cedulaDocente;
	private String cedulaUsuario;
	private String fechaInicial;
	private String fechaFinal;
	private String nombreGrupo;
	private String motivo;
	
	public Registros() {
		
	}
	
	public Registros(String cedulaDocente,String cedulaUsuario,String fechaInicial,String fechaFinal,String nombreGrupo,String motivo) {
		this.cedulaDocente=cedulaDocente;
		this.cedulaUsuario=cedulaUsuario;
		this.fechaInicial=fechaInicial;
		this.fechaFinal=fechaFinal;
		this.nombreGrupo=nombreGrupo;
		this.motivo=motivo;
	}

	public String getCedulaDocente() {
		return this.cedulaDocente;
	}

	public void setCedulaDocente(String cedulaDocente) {
		this.cedulaDocente = cedulaDocente;
	}
	
	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public String getCedulaUsuario() {
		return cedulaUsuario;
	}


	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public static ArrayList<Registros>llenarDatos(){
		Registros datos;
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<Registros>lista=new ArrayList<>();
		String query="SELECT ciD, ciU, fechaInicial, fechaFinal, nombreGrupo, motivo FROM proyectoProgramacionDocentes.registra";
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			ps=conexion.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				datos=new Registros();
				datos.setCedulaDocente(rs.getString("ciD"));
				datos.setCedulaUsuario(rs.getString("ciU"));
				datos.setFechaInicial(rs.getString("fechaInicial"));
				datos.setFechaFinal(rs.getString("fechaFinal"));
				datos.setNombreGrupo(rs.getString("nombreGrupo"));
				datos.setMotivo(rs.getString("motivo"));
				lista.add(datos);
			}
			rs.close();
			ps.close();
			conexion.close();
			
		}catch(SQLException e) {
			
		}
		return lista;
	}
	
	public ArrayList<Registros>llenarDatosDocente(){
		Registros datos;
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<Registros>lista=new ArrayList<>();
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			String query="SELECT ciD, ciU, fechaInicial, fechaFinal, nombreGrupo, motivo FROM proyectoProgramacionDocentes.registra where ciD='"+getCedulaDocente()+"'";
			ps=conexion.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				datos=new Registros();
				datos.setCedulaDocente(rs.getString("ciD"));
				datos.setCedulaUsuario(rs.getString("ciU"));
				datos.setFechaInicial(rs.getString("fechaInicial"));
				datos.setFechaFinal(rs.getString("fechaFinal"));
				datos.setNombreGrupo(rs.getString("nombreGrupo"));
				datos.setMotivo(rs.getString("motivo"));
				lista.add(datos);
			}
			rs.close();
			ps.close();
			conexion.close();
			
		}catch(SQLException e) {
			
		}
		return lista;
	}
	
	
	public ArrayList<Registros>llenarDatosUsuario(){
		Registros datos;
		ResultSet rs;
		PreparedStatement ps;
		ArrayList<Registros>lista=new ArrayList<>();
		try {
			Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
			String query="SELECT ciD, ciU, fechaInicial, fechaFinal, nombreGrupo, motivo FROM proyectoProgramacionDocentes.registra where ciU='"+getCedulaUsuario()+"'";
			ps=conexion.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				datos=new Registros();
				datos.setCedulaDocente(rs.getString("ciD"));
				datos.setCedulaUsuario(rs.getString("ciU"));
				datos.setFechaInicial(rs.getString("fechaInicial"));
				datos.setFechaFinal(rs.getString("fechaFinal"));
				datos.setNombreGrupo(rs.getString("nombreGrupo"));
				datos.setMotivo(rs.getString("motivo"));
				lista.add(datos);
			}
			rs.close();
			ps.close();
			conexion.close();
			
		}catch(SQLException e) {
			
		}
		return lista;
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
	public void modificacionPassword() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminacion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombreFromDB() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
