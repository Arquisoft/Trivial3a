package controllers;

import java.util.ArrayDeque;
import java.util.Queue;

import com.mongodb.util.JSON;

import modelo.usuario.Usuario;
import play.Routes;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import business.game.tablero.colores.Rojo;
import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.mecanica.impl.JuegoEnTableroLineal;
import business.game.tablero.tableros.impl.TableroLineal;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    public static Result menu() {
        return ok(menu.render());
    }
    public static Result createGame() {
        return ok(selectBoard.render());
    }
    public static Result game() {
    	//TODO METIENDO Partida de prueba
    	Usuario u = new Usuario("Usuario1", "", "Benito", "Camela", "b3ny@taximail.com", 0, 0, 0, 0);
    	Queue<Jugador> jugadores  = new ArrayDeque<Jugador>();
    	TableroLineal tablero = new TableroLineal();
    	jugadores.add(new Jugador(tablero, u, new Rojo()));
    	JuegoEnTableroLineal juego = new JuegoEnTableroLineal(jugadores);
    	//FIN DE PRUEBA
    	
    	//PruebaJSON
    	//String jsonTab = JSON.serialize(juego);
    	//JuegoEnTableroLineal j = (JuegoEnTableroLineal) JSON.parse(jsonTab);
    	
        return ok(game.render());
    }
}
