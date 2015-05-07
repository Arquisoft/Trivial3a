package controllers;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import com.mongodb.util.JSON;

import controllers.util.SalaEspera;
import modelo.usuario.Usuario;
import play.mvc.Controller;
import play.mvc.Result;
import play.cache.Cache;
import play.data.Form;
import views.html.*;
import modelo.*;
import persistencia.impl.*;
import business.game.tablero.colores.*;
import business.game.tablero.jugadores.impl.Jugador;
import business.game.tablero.mecanica.impl.JuegoEnTableroLineal;
import business.game.tablero.tableros.impl.TableroLineal;
import business.game.login.acciones.impl.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render(Form.form(Registro.class), null));
	}

	public static Result menu() {
		return ok(menu.render());
	}

	public static Result createGame() {
		if(Cache.get(session("gameID")) == null)
			return ok(selectBoard.render());
		return game();
	}
	public static Result leaveGame() {
		System.out.println(session("gameID"));
		if(session("gameID") != null){
			if(Cache.get(session("gameID")) != null){
				Cache.remove(session("gameID"));
			}
			session().remove("gameID");
		}
		return menu();
	}

	public static Result inicio() {
		return ok(selectBoard.render());
	}

	public static Result newRegister() {
		Form<Registro> registerForm = Form.form(Registro.class)
				.bindFromRequest();
		if (!registerForm.hasErrors()) {
			String login = registerForm.get().login;
			String pass = registerForm.get().pass;
			String pass2 = registerForm.get().pass2;
			if (pass!= null && pass2 != null && !pass.equals(pass2))
				return ok(index.render(Form.form(Registro.class),
						"Las contrasenias no coinciden"));
			String name = registerForm.get().nombre;
			String surname = registerForm.get().apellidos;
			String email = registerForm.get().email;
			int age = registerForm.get().edad;
			RegistrarseAction registro = new RegistrarseAction(login, pass,
					name, surname, email, age);
			String result = registro.execute();
			return ok(index.render(Form.form(Registro.class), result));
		}
		return ok(index.render(Form.form(Registro.class), "Debe rellenar todos los campos"));
	}

	
	public static Result newLogin() {
		Form<Registro> registerForm = Form.form(Registro.class)
				.bindFromRequest();
		if (!registerForm.hasErrors()) {
			String login = registerForm.get().loginInicio;
			String pass = registerForm.get().password;
			//System.out.println("LOGIN " + login + "PASS " + pass);
			ValidarseAction validarse = new ValidarseAction(login, pass);
			Object res = validarse.execute();
			if(res == null){
				session("user", login);
				if(validarse.getIsAdmin()){
					//Incluir aqui informacion de todos los usuarios, para tener
					//sus estadisticas antes de cargar el menu de administrador
					List<Usuario> listaUsuario = new GetUsuarios().get();
					return ok(menu_admin.render(listaUsuario));
				}
				return ok(menu.render());
			}
			else
				return ok(index.render(Form.form(Registro.class), res.toString()));
			}
		return ok(index.render(Form.form(Registro.class), "Debe rellenar todos los campos"));
	}
	public static Result newRoom() {	
		if (session("user") == null){
			return index();
		}
		Form<SalaEspera> roomForm = Form.form(SalaEspera.class).bindFromRequest();
		new GetUsuario().getUsuario(session("user"));
		List<Jugador> players = new ArrayList<Jugador>();
		players.add(new Jugador(null, new GetUsuario().getUsuario(session("user")), null));
		Sala sala = new Sala(players, roomForm.get().maxJugadores, roomForm.get().nombrePartida, roomForm.get().passPartida);
		if(Cache.get("rooms") == null)
			Cache.set("rooms", new HashMap<String,Sala>());
		((HashMap<String,Sala>)Cache.get("rooms")).put(sala.getName(), sala);
		return ok();
	}
	

	
	public static Result logout(){
		session().clear();
		return redirect("/");
	}

	public static Result game() {		
		//Recoge el usuario en sesion
		if(!session().containsKey("user"))
			return index();
		String login = session("user");
		Usuario u = new GetUsuario().getUsuario(login);
		JuegoEnTableroLineal juego;
		if(Cache.get(session("gameID")) == null){//Miramos si el jugador está jugando (si tiene un atributo gameID en la sesión), si no lo tiene creamos
			Queue<Jugador> jugadores = new ArrayDeque<Jugador>();
			TableroLineal tablero = new TableroLineal();
			jugadores.add(new Jugador(tablero, u, new Rojo()));
			juego = new JuegoEnTableroLineal(jugadores);
			Estadisticas.setJuego(juego);
			Estadisticas.actualizar("numJugadas");
			// FIN DE PRUEBA
			//TODO Generar gameID con nombre de usuario creador y system.currenttimemillis();
			String gameID = u.getLogin() + "-" + System.currentTimeMillis();
			session().put("gameID", gameID);
			Cache.set(session("gameID"), juego);
		}else {//Si lo tiene está en una partida y sacamos el gameID de su sesión
			juego = (JuegoEnTableroLineal) Cache.get(session("gameID"));
		}
		//System.out.println(session("gameID"));
		return ok(game.render(juego));
	}
	public static Result state() {
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			String result = session("user") + " - " + juego.getActual().getUsuario().getLogin() + " - " + juego.getAccion() + " - " + juego.getValorDado() + " - " 
							+ juego.getTextoPregunta() + " - " + juego.getRespuestasMezcladas().get(0) + " - " + juego.getRespuestasMezcladas().get(1) + " - " 
							+ juego.getRespuestasMezcladas().get(2) + " - " + juego.getRespuestasMezcladas().get(3);
			return ok(result);
		}
		return forbidden();
	}
	public static Result getAction(){
		//System.out.println(session("gameID"));
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			String result = session("user");
			result += " - " + juego.getAccion() + " - " + juego.getActual().getUsuario().getLogin();
			return ok(result);
		}
		return forbidden();
	}
	public static Result rollDice(boolean reroll){
		//System.out.println(session("gameID"));
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			if(reroll)
				juego.lanzarDado();
			return ok(String.valueOf(juego.getValorDado()));
		}
		return forbidden();
	}
	public static Result answer(int id){
		//System.out.println(session("gameID"));
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			//juego.responderAsociadoBoton(id);
			return ok(String.valueOf(juego.responderAsociadoBoton(id)));
		}
		return forbidden();
	}
	public static Result getPosition(){
		//System.out.println(session("gameID"));
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			String result = "";
			result += juego.getActual().getUsuario().getLogin() + "/" + juego.getActual().getActual().getX() + "/" + juego.getActual().getActual().getY();
			Iterator<Jugador> iter = juego.getQueueJugadores().iterator();
			Jugador j;
			while(iter.hasNext()){
				j = iter.next();
				result += " - " + j.getUsuario().getLogin() + "/" + j.getActual().getX() + "/" + j.getActual().getY();
			}
				
			return ok(result);
		}
		return forbidden();
	}
	public static Result move(String direction){
		System.out.println(session("gameID"));
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			switch (direction) {
			case "up":
				break;
			case "down":
				break;
			case "left":
				juego.jugarIzquierda();
				break;
			case "right":
				juego.jugarDerecha();
				break;
			}
			List<String> respuestas = juego.getRespuestasMezcladas();
			return ok(juego.getTextoPregunta() + " - " + respuestas.get(0) + " - " + respuestas.get(1) + " - " + respuestas.get(2) + " - " + respuestas.get(3));
		}
		return forbidden();
	}
	public static Result isFinished(){
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			if(juego.isGameFinished()){
				Cache.remove(session("gameID"));
				return ok(juego.getActual().getUsuario().getLogin());
			}
		}
		return ok();
	}
	public static Result getTokens(){
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			String result = "";
			Jugador j = juego.getActual();
			result += j.getUsuario().getLogin();
			for(Color c: j.getQuesitos())
				if(c!=null)
					result += " - " + c.toString();
			Iterator<Jugador> iter = juego.getQueueJugadores().iterator();
			while(iter.hasNext()){
				j = iter.next();
				result += j.getUsuario().getLogin();
				for(Color c: j.getQuesitos())
					result += " - " + c.toString();
			}
			return ok(result);
		}
		return ok();
	}
	public static Result getPlayer(){
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			return ok(juego.getActual().getUsuario().getLogin());
		}
		return forbidden();
	}
}
