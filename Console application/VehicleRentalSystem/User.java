import java.util.*;

public class User {
	String email;
	String password;
	String role;
	double deposit=30000;
	List<String> rentedVehicle=new ArrayList<>();
	int extension=2;
	
	public User(String email,String password,String role) {
		this.email=email;
		this.password=password;
		this.role=role;
	}
}