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

	public static Result game() {
		// TODO METIENDO Partida de prueba
		Usuario u = new Usuario("Usuario1", "", "Benito", "Camela",
				"b3ny@taximail.com", 0, 0, 0, 0);
		Queue<Jugador> jugadores = new ArrayDeque<Jugador>();
		TableroLineal tablero = new TableroLineal();
		jugadores.add(new Jugador(tablero, u, new Rojo()));
		JuegoEnTableroLineal juego = new JuegoEnTableroLineal(jugadores);
		// FIN DE PRUEBA
		//TODO Generar gameID con nombre de usuario creador y system.currenttimemillis();
		String gameID = u.getLogin() + "-" + System.currentTimeMillis();
		session().put("gameID", gameID);
		Cache.set(session().get("gameID"), juego);

		// PruebaJSON
		//String jsonTab = JSON.serialize(juego);
		//JuegoEnTableroLineal j = (JuegoEnTableroLineal) JSON.parse(jsonTab);

		return ok(game.render(juego));
	}
	public static Result move(String direction){
		JuegoEnTableroLineal juego  = (JuegoEnTableroLineal) Cache.get(session().get("gameID"));
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
}
