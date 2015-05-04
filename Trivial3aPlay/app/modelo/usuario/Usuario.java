package modelo.usuario;


public class Usuario {

	public String login;
	public String password;
	public String nombre;
	public String apellidos;
	public String email;
	public int edad;
	public int numJugadas;
	public int numGanadas;
	public int preguntasJugadas;
	public int preguntasAcertadas;
	
	public Usuario(){}
	
	public Usuario (String login, String password, String nombre, 
			String apellidos, String email, int numJugadas, int numGanadas,
			int preguntasJugadas, int preguntasAcertadas){
		this.login = login;
		this.password = password;
		this.nombre =  nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.numJugadas = numJugadas;
		this.numGanadas = numGanadas;
		this.preguntasAcertadas = preguntasAcertadas;
		this.preguntasJugadas = preguntasJugadas;
	}
	
	public Usuario (String login, String password, String nombre, 
			String apellidos, String email, int edad, int numJugadas, 
			int numGanadas, int preguntasJugadas, int preguntasAcertadas){
		this(login, password, nombre, apellidos, email, numJugadas, numGanadas,
				preguntasJugadas, preguntasAcertadas);
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
	
	public int getNumJugadas() {
		return numJugadas;
	}

	public void setNumJugadas(int numJugadas) {
		this.numJugadas = numJugadas;
	}

	public int getNumGanadas() {
		return numGanadas;
	}

	public void setNumGanadas(int numGanadas) {
		this.numGanadas = numGanadas;
	}

	public String toString(){
		return "login:" + getLogin() + ", pass:" + getPassword(); 
	}

	public int getRespuestasJugadas() {
		return preguntasJugadas;
	}

	public void setRespuestasJugadas(int respuestasJugadas) {
		this.preguntasJugadas = respuestasJugadas;
	}

	public int getRespuestasAcertadas() {
		return preguntasAcertadas;
	}

	public void setRespuestasAcertadas(int respuestasAcertadas) {
		this.preguntasAcertadas = respuestasAcertadas;
	}


	
}
