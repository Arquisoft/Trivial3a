package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

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
        return ok(game.render());
    }

}
