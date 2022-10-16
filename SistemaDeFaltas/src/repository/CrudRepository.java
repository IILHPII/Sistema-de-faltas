package repository;

public interface CrudRepository {
	
	 final String url="jdbc:mysql://localhost/registro";
	 final String userDB="root";
	 final String passwordDB="root";
	
	 public boolean consulta();
	 
	 public void alta();
	
	
}
