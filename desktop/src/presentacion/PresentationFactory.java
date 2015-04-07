package presentacion;

import presentacion.login.PresentationLogin;

/**
 * Interfaz: Factoria encargada de la parte de Presentacion
 * @author Inigo Llaneza Aller
 *
 */
public interface PresentationFactory {
	/**
	 * Creacion del login
	 * @return instancia del Login
	 */
	PresentationLogin createPresentationLogin();
}
