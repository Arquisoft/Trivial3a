package test.java.es.uniovi.asw.steps;

import org.junit.Assert;

import business.game.login.Partida;
import business.game.tablero.colores.Color;
import business.game.tablero.colores.Verde;
import modelo.usuario.Usuario;
import cucumber.api.java.es.*;

public class PartidaSteps {
	 
	private Usuario usuario ;
	private Partida partida;
	
	@Dada("^una partida de trivial$")
	public void una_partida_de_trivial() throws Throwable {
		partida = new Partida();
	}
	
	@Cuando("^añado un usuario de nombre \"(.*?)\" y clave \"(.*?)\"$")
	public void añado_un_usuario_de_nombre_y_clave(String nombre, String clave) throws Throwable {
		Color color = new Verde();
		usuario.setNombre(nombre);
		usuario.setPassword(clave);
		partida.addUsuario(color, usuario);
	}
	
	@Entonces("^el numero de jugadores es (\\d+)$")
	public void el_numero_de_jugadores_es(int n) throws Throwable {
	    Assert.assertEquals(partida.getPartida().size(),n);  
	}
	
}
