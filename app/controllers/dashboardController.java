package controllers;

import buscinessLogics.LoginLogic;
import play.mvc.Controller;
import play.mvc.Result;

public class dashboardController extends Controller {

	public static Result dashboard() {
		return ok(views.html.dashboard.render());
	}
	
	public static Result category() {
		return ok(views.html.categories.render());
	}
	
}