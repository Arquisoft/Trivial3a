package presentacion.login;

import presentacion.login.impl.FondoLogin;
import presentacion.login.impl.VentanaLogin;
import presentacion.login.impl.VentanaRegistro;

/**
 * Interfaz de la factoria del login
 * @author Inigo Llaneza Aller
 *
 */
public interface PresentationLogin {
	
	/**
	 * Obtiene una instancia del FondoLogin
	 * @return nueva clase FondoLogin
	 */
	FondoLogin getFondoLogin();
	
	/**
	 * Obtiene una instancia de la ventana de Login
	 * @return nueva clase VentanaLogin
	 */
	VentanaLogin getVentanaLogin();
	
	/**
	 * Obtiene una instancia de ventana de registro
	 * @param vl VentanaLogin
	 * @return nueva clase Ventana de Registro
	 */
	VentanaRegistro getVentanaRegistro(VentanaLogin vl);
}
