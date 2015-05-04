package controllers;

import java.util.ArrayDeque;
import java.util.Queue;

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
		if(!session().containsKey("gameID")){//Miramos si el jugador está jugando (si tiene un atributo gameID en la sesión), si no lo tiene creamos
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

		// PruebaJSON
		//String jsonTab = JSON.serialize(juego);
		//JuegoEnTableroLineal j = (JuegoEnTableroLineal) JSON.parse(jsonTab);

		return ok(game.render(juego));
	}
	
	
	public static Result move(String direction){
		JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session("gameID"));
		juego.lanzarDado();
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
		
		return ok(juego.getTextoPregunta());
	}
	
//	public static Result javascriptRoutes() {
//	    response().setContentType("text/javascript");
//	    return ok(
//	        Routes.javascriptRouter("jsRoutes",
//	            controllers.routes.javascript.Projects.add(),
//	            controllers.routes.javascript.Projects.delete(),
//	            controllers.routes.javascript.Projects.rename(),
//	            controllers.routes.javascript.Projects.addGroup()
//	        )
//	    );
//	}
}
