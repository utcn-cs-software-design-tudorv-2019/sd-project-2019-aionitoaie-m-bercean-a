package Model.Repositories;

import java.util.List;

public interface MasterInterface <T,U> {
	
	public void create(T obiect);
	public List<T> selectAll();
	public  T read(U idObiect);
	public  void update(T obiect);
	public  void delete(U idObiect);
	
}
