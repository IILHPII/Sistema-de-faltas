package repository;

public interface CrudRepository {
	
	 final String url="jdbc:mysql://localhost/proyectoListaDB";
	 final String userDB="root";
	 final String passwordDB="Cd430785!";
	
	 public boolean consulta();
	 
	 public void alta(int ci,String nombre,String rol,String password);
	
	
}
