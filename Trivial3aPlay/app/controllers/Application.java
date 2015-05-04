package controllers;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.mongodb.util.JSON;

import modelo.usuario.Usuario;
import play.mvc.Controller;
import play.mvc.Result;
import play.cache.Cache;
import play.data.Form;
import views.html.*;
import modelo.*;
import persistencia.impl.GetUsuario;
import business.game.tablero.colores.Rojo;
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
		return ok(selectBoard.render());
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
					List<Usuario> listaUsuario = new ArrayList<Usuario>();
					return ok(menu_admin.render(listaUsuario));
				}
				return ok(menu.render());
			}
			else
				return ok(index.render(Form.form(Registro.class), res.toString()));
			}
		return ok(index.render(Form.form(Registro.class), "Debe rellenar todos los campos"));
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
			// FIN DE PRUEBA
			//TODO Generar gameID con nombre de usuario creador y system.currenttimemillis();
			String gameID = u.getLogin() + "-" + System.currentTimeMillis();
			session().put("gameID", gameID);
			Cache.set(session("gameID"), juego);
		}else {//Si lo tiene está en una partida y sacamos el gameID de su sesión
			juego = (JuegoEnTableroLineal) Cache.get(session("gameID"));
		}
		System.out.println(session("gameID"));
		return ok(game.render(juego));
	}
	public static Result rollDice(){
		System.out.println(session("gameID"));
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			juego.lanzarDado();
			return ok(String.valueOf(juego.getValorDado()));
		}
		return forbidden();
	}
	public static Result answer(int id){
		System.out.println(session("gameID"));
		if(Cache.get(session("gameID")) != null){
			JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
			juego.responderAsociadoBoton(id);
			return ok(String.valueOf(juego.responderAsociadoBoton(id)));
		}
		return forbidden();
	}
	public static Result getPosition(){
		System.out.println(session("gameID"));
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
}
