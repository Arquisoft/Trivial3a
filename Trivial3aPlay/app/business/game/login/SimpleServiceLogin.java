package business.game.login;

import modelo.usuario.Usuario;

public class SimpleServiceLogin implements ServiceLogin {

	@Override
	public Partida getPartida() {
		return new Partida();
	}

	@Override
	public Usuario getUsuario() {
		return new Usuario();
	}

}
