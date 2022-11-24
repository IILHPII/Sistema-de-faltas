package repository;

public interface CrudRepository {
	
	 final String url="jdbc:mysql://localhost/proyectoProgramacionDocentes";
	 final String userDB="root";
	 final String passwordDB="Cd430785!";
	
	 public boolean consulta();
	 
	 public void alta();
	 
	 public void modificacion();
	 
	 public void eliminacion();	
	
}
