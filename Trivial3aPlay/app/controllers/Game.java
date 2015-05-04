package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.Context;
import play.cache.Cache;
import play.data.*;
import static play.data.Form.*;

import java.util.*;

import business.game.tablero.mecanica.impl.JuegoEnTableroLineal;
import models.*;
import views.html.*;

public class Game extends Controller{
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
}
