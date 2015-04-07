package business.game.login;


public class Usuario {

	private String login;
	private String password;
	private String nombre;
	private String apellidos;
	private String email;
	private int edad;
	
	public Usuario(){}
	
	public Usuario (String login, String password, String nombre, 
			String apellidos, String email){
		this.login = login;
		this.password = password;
		this.nombre =  nombre;
		this.apellidos = apellidos;
		this.email = email;
	}
	
	public Usuario (String login, String password, String nombre, 
			String apellidos, String email, int edad){
		this(login, password, nombre, apellidos, email);
		this.edad = edad;
		
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String toString(){
		return "login:" + getLogin() + ", pass:" + getPassword(); 
	}


	
}
