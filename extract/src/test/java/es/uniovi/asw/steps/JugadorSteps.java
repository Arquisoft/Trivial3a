package test.java.es.uniovi.asw.steps;

import org.junit.Assert;

import modelo.usuario.Usuario;
import business.game.login.Partida;
import business.game.tablero.colores.Color;
import business.game.tablero.colores.Rojo;
import business.game.tablero.colores.Verde;
import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.nodos.Nodo;
import business.game.tablero.tableros.Tablero;
import business.game.tablero.tableros.impl.TableroLineal;

public class JugadorSteps {
	private Jugador jugador;
	private Usuario usuario;
	private Tablero tablero;
	private Nodo nodo;
	
	@Dada("^un jugador$")
	public void un_jugador() throws Throwable {
		tablero = new TableroLineal();
		usuario = new Usuario();
		Color color = new Rojo();
		jugador = new Jugador(tablero, usuario, color);
		nodo = jugador.getActual();
	}
	
	@Cuando("^me muevo a la derecha \"(.*?)\" posiciones$")
	public void me_muevo_a_la_derecha_posiciones(int posiciones) throws Throwable {
		jugador.moverDerecha(posiciones);
	}
	
	@Cuando("^me muevo a la izquierda \"(.*?)\" posiciones$")
	public void me_muevo_a_la_izquierda_posiciones(int posiciones) throws Throwable {
		jugador.moverDerecha(posiciones);
	}
	
	@Entonces("^el jugador ha cambiado de posicion$")
	public void el_jugador_ha_cambiado_de_posicion() throws Throwable {
	    Assert.assertFalse(nodo.equals(jugador.getActual()));  
	}
	
	@Cuando("^gano un quesito de color $")
	public void gano_un_quesito_de_color_verde() throws Throwable {
		Color c = new Verde();
		jugador.addQuesito(c);
	}
	
	@Entonces("^el jugador tiene \"(.*?)\" quesito$")
	public void el_jugador_tiene_quesito(int n) throws Throwable {
	    Assert.assertEquals(jugador.getTamActual(), n);  
	    Color verde = new Verde();
	    Assert.assertEquals(jugador.getQuesitos()[0],verde);
	}

}
