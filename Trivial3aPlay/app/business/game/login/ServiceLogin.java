package business.game.login;

import modelo.usuario.Usuario;

/**
 * Factoria de Login [LOGICA]
 * @author Inigo Llaneza Aller
 *
 */
public interface ServiceLogin {

	/**
	 * Crea un elemento Partida
	 * @return Partida
	 */
	Partida getPartida();
	
	/**
	 * Crea un elemento Usuario
	 * @return Usuario
	 */
	Usuario getUsuario();
	
}
